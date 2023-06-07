package com.BackendProject.LibraryManagementSystem.Service.Implementation;

import com.BackendProject.LibraryManagementSystem.DTO.RequestDto.IssueBookRequestDto;
import com.BackendProject.LibraryManagementSystem.DTO.ResponseDto.IssueBookResponseDto;
import com.BackendProject.LibraryManagementSystem.Entity.Book;
import com.BackendProject.LibraryManagementSystem.Entity.LibraryCard;
import com.BackendProject.LibraryManagementSystem.Entity.Transaction;
import com.BackendProject.LibraryManagementSystem.Enum.CardStatus;
import com.BackendProject.LibraryManagementSystem.Enum.TransactionStatus;
import com.BackendProject.LibraryManagementSystem.Repository.BookRepository;
import com.BackendProject.LibraryManagementSystem.Repository.CardRepository;
import com.BackendProject.LibraryManagementSystem.Repository.TransactionRespository;
import com.BackendProject.LibraryManagementSystem.Service.Interface.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    CardRepository cardRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    TransactionRespository transactionRespository;
    @Autowired
    JavaMailSender mailSender;


    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();
        transaction.setTransactioNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIsIssuedOperation(true);

        LibraryCard libraryCard;
        try {
            libraryCard = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Card not found");
            transactionRespository.save(transaction);
            throw new Exception("Card not present");
        }
        Book book;
        try {
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        } catch (Exception e) {
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Book not found");
            transactionRespository.save(transaction);
            throw new Exception("Book not found");
        }
        transaction.setBook(book);
        transaction.setCard(libraryCard);
        if(libraryCard.getStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not activated");
            transactionRespository.save(transaction);
            throw new Exception("Your card is not activated");
        }
        if(book.isIsissued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Sorry book is already issue");
            transactionRespository.save(transaction);
            throw new Exception("Sorry book is already issue");
        }
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction was successful");
        book.setIsissued(true);
        book.setCard(libraryCard);
        book.getTransaction().add(transaction);
        libraryCard.getTransaction().add(transaction);
        libraryCard.getBookIssued().add(book);

        cardRepository.save(libraryCard);

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setTransactionId(transaction.getTransactioNumber());
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setBookName(book.getTitle());

        return issueBookResponseDto;


    }

}

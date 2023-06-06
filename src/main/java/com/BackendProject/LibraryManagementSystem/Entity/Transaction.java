package com.BackendProject.LibraryManagementSystem.Entity;

import com.BackendProject.LibraryManagementSystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String transactionumber;
    @Enumerated(EnumType.STRING)
    private TransactionStatus transactionStatus;
    @CreationTimestamp
    private Date transactionDate;
    private Boolean IsissuedOperation;
    private String Message;
    @ManyToOne
    @JoinColumn
    Book book;
    @ManyToOne
    @JoinColumn
    LibraryCard card;

}

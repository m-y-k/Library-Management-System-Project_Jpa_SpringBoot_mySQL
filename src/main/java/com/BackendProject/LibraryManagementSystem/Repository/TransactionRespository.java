package com.BackendProject.LibraryManagementSystem.Repository;

import com.BackendProject.LibraryManagementSystem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRespository extends JpaRepository<Transaction,Integer> {
}

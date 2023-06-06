package com.BackendProject.LibraryManagementSystem.Entity;

import com.BackendProject.LibraryManagementSystem.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int cardno;

     @Enumerated(EnumType.STRING)
     private CardStatus status;

     @CreationTimestamp
     private Date creationDate;
     @UpdateTimestamp
     private Date updationDate;
     @OneToOne
     @JoinColumn
     Student student;

     @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
     List<Transaction> transaction = new ArrayList<>();
     @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
     List<Book> bookIssued = new ArrayList<>();

}

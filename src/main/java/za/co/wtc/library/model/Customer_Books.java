package za.co.wtc.library.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table (name = "customer_books")
public class Customer_Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "date_issued")
    private LocalDateTime issuedDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    public Long getCustomerId(){
        return customerId;
    }

    public void setCustomerId(Long customerId){
        this.customerId = customerId;
    }

    public Long getBookId(){
        return bookId;
    }

    public void setBookId(Long bookId){
        this.bookId = bookId;
    }

    public LocalDateTime getIssuedDate(){
        return issuedDate;
    }

    public void setCustomerId(LocalDateTime issuedDate){
        this.issuedDate = issuedDate;
    }

    public LocalDateTime getDueDate(){
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate){
        this.dueDate = dueDate;
    }



}

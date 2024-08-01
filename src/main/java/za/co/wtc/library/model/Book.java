package za.co.wtc.library.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "ISBN")
  private String ISBN;

  @Column(name = "author_id")
  private Long authorId;

  @Column(name = "publisher")
  private String publisher;

  @Column(name = "date_published")
  private LocalDateTime datePublished;

  @Column(name = "category")
  private String category;

  @Column(name = "date_created")
  private LocalDateTime dateCreated;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String geTitle() {
    return title;
  }

  public void seTitle(String title) {
    this.title = title;
  }

  public String getISBN() {
    return ISBN;
  }

  public void setISBN(String ISBN) {
    this.ISBN = ISBN;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }


public LocalDateTime getDatePublished() {
    return datePublished;
}

public void setDatePublished(LocalDateTime datePublished) {
    this.datePublished = datePublished;
}

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(LocalDateTime dateCreated) {
    this.dateCreated = dateCreated;
  }
}

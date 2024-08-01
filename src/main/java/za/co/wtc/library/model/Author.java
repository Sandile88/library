package za.co.wtc.library.model;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table (name = "authoer")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    
    @Column(name = "surname")
    private String surname;

    @Column(name = "title")
    private String title;

    @Column(name = "email")
    private String email;

    @Column(name = "rating")
    private int rating;


        
    @Column(name = "date_created")
    private LocalDateTime dateCreated;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

        public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String geTitle() {
        return title;
      }
    
    public void seTitle(String title) {
        this.title = title;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDateTime getDateCreated() {
    return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }



}

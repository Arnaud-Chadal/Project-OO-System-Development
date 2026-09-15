package com.graniteam.gameview.data;
import jakarta.persistence.*;

@Entity
@Table(name = "\"user\"")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    private String name;
    private String accountCreationDate;


    public User()
    {
        name = "";
        accountCreationDate = "";
    }

    public User(String name, String accountCreationDate)
    {
        this.name = name;
        this.accountCreationDate = accountCreationDate;
    }

    public Long getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAccountCreationDate() {return accountCreationDate;}
    public void setAccountCreationDate(String accountCreationDate) {this.accountCreationDate = accountCreationDate;}
}

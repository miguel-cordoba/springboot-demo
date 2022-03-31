package mamc.module.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {


    @Id
    @GeneratedValue // this will work as UNIQUE AUTO_INCREMENT
    private Long id;
    private String name;
    private String surname;
    private String email;

    public Person(String name, String surname, String email){
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
    }

    public Person() {

    }

    public Long getId() { return id;}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSurname() { return surname;}
    public void setSurname(String surname) { this.surname = surname;}


}

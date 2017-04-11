package me.czarneta.model;

/**
 * Created by Dawid on 11.04.2017.
 */

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public Customer() {}        //Wymagane do dzialania repa

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

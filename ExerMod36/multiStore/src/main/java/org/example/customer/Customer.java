package org.example.customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import jakarta.persistence.Id;
import org.springframework.util.Assert;

@Data
@Entity
public class Customer {
    private @Id @GeneratedValue Long id;
    private String firstname, lastname;

    private Address address;

    public Customer(String firstname, String lastname) {

        Assert.hasText(firstname, "Firstname must not be null or empty!");
        Assert.hasText(lastname, "Lastname must not be null or empty!");

        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Customer(String firstname, String lastname, Address address) {

        Assert.hasText(firstname, "Firstname must not be null or empty!");
        Assert.hasText(lastname, "Lastname must not be null or empty!");
        Assert.notNull(address, "Address must not be null or empty!");

        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    protected Customer() {}


}

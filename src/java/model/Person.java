/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author richou
 */
public class Person {
    private String firstName;
    private String lastName;

    public Person() {
        this.firstName = "";
        this.lastName = "";
    }
    
    public Person(String firstName, String lastName) {
        this();
        this.firstName = (firstName == null)?(""):(firstName);
        this.lastName = (lastName == null)?(""):(lastName);
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
    
    public boolean isKnown() {
        try {
            Request request = new Request();
            for(Person p : request.getPeople()) {
                if(this.equals(p))
                    return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
    public boolean register() {
        if(isKnown())
            return false;
        try {
            Request request = new Request();
            request.registerPerson(this);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
    
    
    public static void main(String[] args) {
        Person p1 = new Person("Richou", "Degenne");
        Person p2 = new Person("Melody", "Lemaire");
        
        System.out.println(p1.isKnown());
        System.out.println(p2.isKnown());
        p2.register();
    }
}

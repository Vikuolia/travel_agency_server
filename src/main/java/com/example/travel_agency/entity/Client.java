package com.example.travel_agency.entity;

import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;


@NoArgsConstructor
@EnableAutoConfiguration
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    private UUID clientId;

    private String name;
    private String surname;
    private int age;
    private int background;
    private boolean student;
    private boolean frequentBuyer;

    @OneToMany(mappedBy = "client")
    Set<Order> orders;

    public Client(String name, String surname, int age, int background, boolean student){
        this.clientId = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.background = background;
        this.student = student;
        this.frequentBuyer = false;
    }

    @Override
    public String toString(){
        return "\n-CLIENT-\nName: " + this.name + "\nSurname: " + this.surname + "\nAge: " +
                this.age + "\nBackground: " + this.background + "\nStudent: " + this.student +
                "\nFrequent buyer: " + this.frequentBuyer;
    }
}
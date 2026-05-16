package br.com.requestmanagement.joaoproject.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    public Request(){}

    // getters
    public Long getId(){
        return id;
    }
    public LocalDate getDate(){
        return date;
    }
}

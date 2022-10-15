package com.mnr.springsecurity_docker.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int id;

    private String firstname;

    private String lastname;

    private String email;

}

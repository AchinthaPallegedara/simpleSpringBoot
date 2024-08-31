package com.company.empmgmtsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class Users {
    @Id
    private int id;
    private String username;
    private String password;

}

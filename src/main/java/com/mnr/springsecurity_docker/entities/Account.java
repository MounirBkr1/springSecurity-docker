package com.mnr.springsecurity_docker.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private String username;

    //dont show encoded password
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;

    private boolean enabled=true;
    private boolean crudentialsExpired=false;
    private boolean expired= false;
    private boolean locked =false;

    //Set : A collection that contains no duplicate elements
    @ManyToMany(fetch = FetchType.EAGER,cascade= ALL)
    @JoinTable(
            name="AccountRole",
            joinColumns= @JoinColumn(name="accountId", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="roleId", referencedColumnName="id")
    )
    private Set<Role> roles;
}

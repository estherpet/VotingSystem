package com.voterapp.votersapp.roles;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.voterapp.votersapp.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Roles {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
   private Long id;

   @Column (unique = true)
   private String name;

   @JsonIgnore
   @ManyToMany
   private List<User> userList;



}

package com.voterapp.votersapp.user;

import com.voterapp.votersapp.roles.Roles;
import jakarta.persistence.*;
import lombok.*;



import java.util.List;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
@Builder

public class User  {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    private String password;
    @Column(unique = true)
    private String email;
    private boolean  isEnabled;
    private String votersId;
    @ManyToMany (fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    private List<Roles> roles;



//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles.stream()
//                .map(r -> new SimpleGrantedAuthority(r.getName()))
//                .collect(Collectors.toList());
//
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
}

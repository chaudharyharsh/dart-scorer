package com.dart.scorer.dartscorer.entity;

import com.dart.scorer.dartscorer.enums.Role;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Columns;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    @Column(unique = true)
    private String userName;
    private String password;
    private boolean isActive;
    private String roles;

    @Transient
    @OneToOne
    private TeamMember teamMember;


}

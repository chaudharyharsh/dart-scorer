package com.dart.scorer.dartscorer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private boolean isActive;

    @Transient
    @OneToOne
    private TeamMember teamMember;


}

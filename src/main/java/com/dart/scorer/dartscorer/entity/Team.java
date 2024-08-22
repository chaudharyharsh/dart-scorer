package com.dart.scorer.dartscorer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;

    @OneToOne
    @JoinColumn(name = "captain_user_id")
    private UserProfile captainId;

    @OneToMany(mappedBy = "teamId")
    private Set<TeamMember> teamMembers;

    @OneToMany(mappedBy = "teamId")
    private Set<Round> rounds;

    @Size(max = 50)
    private String teamName;

    private Integer noOfPlayers;

    private Long teamScore;

    private boolean isWinner;

}

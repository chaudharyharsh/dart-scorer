package com.dart.scorer.dartscorer.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game gameId;

    @NotEmpty
    @OneToOne
    @JoinColumn(name = "captain_user_id")
    private UserProfile captainId;

    @OneToMany(mappedBy = "teamId")
    private Set<TeamMember> teamMembers;

    @OneToMany(mappedBy = "teamId")
    private Set<Round> rounds;

    @Size(max = 50)
    private String teamName;

    @NotEmpty
    private Integer noOfPlayers;

    @NotNull
    private Long teamScore;

    @NotNull
    private boolean isWinner;

}

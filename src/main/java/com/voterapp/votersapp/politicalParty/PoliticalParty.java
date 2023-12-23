package com.voterapp.votersapp.politicalParty;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "politicalParty")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PoliticalParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}

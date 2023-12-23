package com.voterapp.votersapp.Election;

import com.voterapp.votersapp.candidate.Candidate;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "election")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Election {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String electionName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Candidate> candidates;

}

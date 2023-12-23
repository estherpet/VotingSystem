package com.voterapp.votersapp.vote;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
public class CreateElectionResponse {
    private Long id;
    private String electionName;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}

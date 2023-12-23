package com.voterapp.votersapp.Election;


import lombok.*;

import java.time.LocalDateTime;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateElectionRequest {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}

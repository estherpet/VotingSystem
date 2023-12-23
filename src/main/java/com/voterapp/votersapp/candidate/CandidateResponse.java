package com.voterapp.votersapp.candidate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CandidateResponse {
    private Long id;
    private String email;
}

package com.voterapp.votersapp.candidate;


import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCandidateRequest {
    private String name;
}

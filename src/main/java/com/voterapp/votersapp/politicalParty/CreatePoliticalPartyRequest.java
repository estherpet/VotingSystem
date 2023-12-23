package com.voterapp.votersapp.politicalParty;


import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePoliticalPartyRequest {
    private String name;
}

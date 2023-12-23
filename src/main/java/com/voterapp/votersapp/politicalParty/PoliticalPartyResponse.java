package com.voterapp.votersapp.politicalParty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PoliticalPartyResponse {
    private Long id;
    private String name;
}

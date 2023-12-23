package com.voterapp.votersapp.politicalParty;



public class PoliticalPartyMapper {
    public PoliticalParty  toPoliticalParty(CreatePoliticalPartyRequest createPoliticalPartyRequest) {
        if (createPoliticalPartyRequest == null) {
            return new  PoliticalParty();
        }
        return PoliticalParty.builder().name(createPoliticalPartyRequest.getName()).build();
    }

    public PoliticalPartyResponse toResponse (PoliticalParty politicalParty) {
        return PoliticalPartyResponse.builder().name(politicalParty.getName()).id(politicalParty.getId()).build();
    }
}

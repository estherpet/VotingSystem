package com.voterapp.votersapp.politicalParty;


import java.util.List;

public interface PoliticalPartyService {
    Long createPoliticalParty (CreatePoliticalPartyRequest createPoliticalPartyRequest);
    List<PoliticalPartyResponse> findAll();
    PoliticalPartyResponse findById(Long id);
    public void delete(Long id);
}

package com.voterapp.votersapp.vote;

import java.util.List;

public interface ElectionService {
    Long createElection(com.voterapp.votersapp.Election.CreateElectionRequest createElectionRequest);

    Long createElection (CreateElectionRequest createElectionRequest);

    Long createVote(CreateElectionRequest createElectionRequest);

    List<CreateElectionResponse> findAll();
    CreateElectionResponse findById(Long id);
    public void delete(Long id);

}

package com.voterapp.votersapp.Election;


import java.util.List;

public interface ElectionService {
    Long createElection (CreateElectionRequest createElectionRequest);
    List<CreateElectionResponse> findAll();
    CreateElectionResponse findById(Long id);
    public void delete(Long id);

}

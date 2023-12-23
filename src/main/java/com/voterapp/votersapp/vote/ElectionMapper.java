package com.voterapp.votersapp.vote;

import com.voterapp.votersapp.Election.Election;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ElectionMapper {
    public Election toElection (CreateElectionRequest createElectionRequest) {
        if (createElectionRequest == null) {
            return new Election();
        }
        return Election.builder().electionName(createElectionRequest.getName())
                .startDate(createElectionRequest.getStartDate()).endDate(createElectionRequest.getEndDate()).build();
    }

    public CreateElectionResponse toResponse (Election election) {
        return CreateElectionResponse.builder().electionName(election.getElectionName()).id(election.getId()).build();
    }
}

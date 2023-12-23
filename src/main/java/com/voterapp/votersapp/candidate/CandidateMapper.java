package com.voterapp.votersapp.candidate;


public class CandidateMapper {
    public Candidate toCandidate(CreateCandidateRequest createCandidateRequest) {
        if (createCandidateRequest == null) {
            return new Candidate();
        }
        return Candidate.builder().email(createCandidateRequest.getName()).build();
    }

    public CandidateResponse toResponse (Candidate candidate) {
        return CandidateResponse.builder().email(candidate.getEmail()).id(candidate.getId()).build();
    }
}

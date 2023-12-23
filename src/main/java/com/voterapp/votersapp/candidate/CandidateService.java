package com.voterapp.votersapp.candidate;



import java.util.List;

public interface CandidateService {
    Long createCandidate (CreateCandidateRequest createCandidateRequest);
    List<CandidateResponse> findAll();
    CandidateResponse findById(Long id);
    public void delete(Long id);
}

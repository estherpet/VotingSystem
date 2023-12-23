package com.voterapp.votersapp.candidate;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    boolean existsCandidateByEmail(String email);
}

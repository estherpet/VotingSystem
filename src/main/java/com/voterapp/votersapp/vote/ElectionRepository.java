package com.voterapp.votersapp.vote;

import com.voterapp.votersapp.Election.Election;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, Long> {
    boolean existsElectionByElectionName(String name);
}

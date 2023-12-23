package com.voterapp.votersapp.politicalParty;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliticalPartyRepository extends JpaRepository<PoliticalParty, Long> {
    boolean existsPoliticalPartiesByName(String name);
}

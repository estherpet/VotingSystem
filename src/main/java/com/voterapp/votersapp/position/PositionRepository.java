package com.voterapp.votersapp.position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
    boolean existsPositionByName(String name);
}

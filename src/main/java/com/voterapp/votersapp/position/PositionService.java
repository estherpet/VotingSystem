package com.voterapp.votersapp.position;

import java.util.List;

public interface PositionService {
    Long createPosition (CreatePositionRequest createPositionRequest);


    List<PositionResponse> findAll();
    PositionResponse findById(Long id);
    public void delete(Long id);
}

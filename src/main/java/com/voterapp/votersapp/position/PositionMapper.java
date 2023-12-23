package com.voterapp.votersapp.position;


public class PositionMapper {
    public Position toPosition (CreatePositionRequest createPositionRequest) {
        if (createPositionRequest == null) {
            return new  Position();
        }
        return Position.builder().name(createPositionRequest.getName()).build();
    }

    public PositionResponse toResponse (Position position) {
        return PositionResponse.builder().name(position.getName()).id(position.getId()).build();
    }

}

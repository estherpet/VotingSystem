package com.voterapp.votersapp.position;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PositionResponse {
    private Long id;
    private String name;
}

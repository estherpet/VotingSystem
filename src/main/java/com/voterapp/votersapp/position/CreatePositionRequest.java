package com.voterapp.votersapp.position;


import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePositionRequest {
    private String name;
}

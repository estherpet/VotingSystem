package com.voterapp.votersapp.auth;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class AuthRegistrationResponse {
        private Long userId;
        private String username;

        public void setMessage(String message) {
        }
}

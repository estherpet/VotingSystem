package com.voterapp.votersapp.user;



import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public User toUser(UserRequest request) {
    return User.builder()
        .id(request.getId())
        .firstName(request.getFirstname())
        .lastName(request.getLastname())
        .email(request.getEmail())
        .password(request.getPassword())
        .build();
  }

  public UserResponse toResponse(User user) {
    return UserResponse.builder()
        .id(user.getId())
        .firstname(user.getFirstName())
        .lastname(user.getLastName())
        .email(user.getEmail())
        .build();
  }
}

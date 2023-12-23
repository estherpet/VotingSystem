package com.voterapp.votersapp.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

  private Long id;
  @NotNull(message = "First name is mandatory")
  private String firstname;
  @NotNull(message = "Last name is mandatory")
  private String lastname;
  @NotNull(message = "Email name is mandatory")
  @Email(message = "Email is not valid")
  private String email;
  @NotNull(message = "Email name is mandatory")
  @Size(min = 4, max = 16, message = "Password should be between 4 and 16 chars")
  private String password;

}

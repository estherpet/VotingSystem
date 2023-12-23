package com.voterapp.votersapp.auth;

import com.voterapp.votersapp.exception.UserAlreadyExistException;

public interface UserService {

    AuthRegistrationResponse register(AuthRegistrationRequest request) throws UserAlreadyExistException;
}

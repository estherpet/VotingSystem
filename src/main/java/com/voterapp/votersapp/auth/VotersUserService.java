package com.voterapp.votersapp.auth;

import com.voterapp.votersapp.exception.UserAlreadyExistException;
import com.voterapp.votersapp.mail.EmailConfig;
import com.voterapp.votersapp.mail.PasswordGenerator;
import com.voterapp.votersapp.user.User;
import com.voterapp.votersapp.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VotersUserService implements UserService{

    private final UserRepository userRepository;

    public final EmailConfig emailConfig;

    @Override
    public AuthRegistrationResponse register(AuthRegistrationRequest request) throws UserAlreadyExistException {
        Optional<User> user = userRepository.findAllByEmail(request.getEmail());
        if (user.isPresent()) {
          throw new UserAlreadyExistException("USER ALREADY EXIST");
        }
User newUser = new User();
        String password = PasswordGenerator.Utils.generateDefaultPassword(8);
        newUser.setFirstName(request.getFirstname());
        newUser.setLastName(request.getLastname());

        newUser.setEmail(request.getEmail());

        userRepository.save(newUser);

        String emailSubject = "Document Management System! User Password";
        String emailBody = "Dear " + newUser.getFirstName() + ",<br><br>"
                + "Welcome to Timmy Voter App! Your account has been created successfully.<br>"
                + "Your password is: <strong>" + password + "</strong><br><br>"
                + "Please login using this password and change it after your first login.<br><br>"
                + "Thank you,<br>The Data Management System Team";
        String receiverEmail = newUser.getEmail();
      emailConfig.sendSimpleMail(receiverEmail,emailSubject,emailBody);
//        System.out.println("i am here");
AuthRegistrationResponse response = new AuthRegistrationResponse(5L,"timmy");
response.setMessage("REGISTERED");
        return response;
    }
}

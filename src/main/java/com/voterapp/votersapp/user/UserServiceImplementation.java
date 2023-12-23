package com.voterapp.votersapp.user;


import com.voterapp.votersapp.mail.PasswordGenerator;
import com.voterapp.votersapp.repositories.UserRepository;
import com.voterapp.votersapp.user.UserRequest;
import com.voterapp.votersapp.user.UserMapper;
import com.voterapp.votersapp.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VoterService {

  private final UserRepository repository;
  private final ObjectsValidator<UserRequest> validator;
  private final UserMapper mapper;



  public Long create(UserRequest request) {
    validator.validate(request);
    var user = mapper.toUser(request);
    user.setPassword(request.getPassword());
    return repository.save(user).getId();
  }

  public List<UserResponse> findAll() {
    return repository.findAll()
        .stream()
        .map(mapper::toResponse)
        .collect(Collectors.toList());
  }

  public UserResponse findById(Long id) {
    return repository.findById(id)
        .map(mapper::toResponse)
        .orElseThrow(() -> new EntityNotFoundException("No user found with the ID:: " + id));
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }





  public String getVotersId (String email) {
    var user = repository.findAllByEmail(email);
    String votersId = user.get().getLastName() +   PasswordGenerator.Utils.generateDefaultPassword(8);
    if (user.get().getVotersId() != null) {
      user.get().setVotersId(votersId);
    }
    return user.get().getVotersId();

  }
//  public VoteResponse vote (String email, String voterId, String token) {
//
//  }




}

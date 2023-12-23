package com.voterapp.votersapp.validator;

import com.voterapp.votersapp.exception.ObjectValidationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ObjectsValidator<T> {

//  private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//  private final Validator validator = factory.getValidator();
//
//  public void validate(T objectToValidate) {
//    Set<ConstraintViolation<T>> violations =  validator.validate(objectToValidate);
//    if (!violations.isEmpty()) {
//      Set<String> errorMsg = violations
//          .stream()
//          .map(ConstraintViolation::getMessage)
//          .collect(Collectors.toSet());
//      throw new ObjectValidationException(errorMsg, objectToValidate.getClass().getSimpleName());
//    }
//  }

}

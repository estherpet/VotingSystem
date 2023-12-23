package com.voterapp.votersapp.position;
import com.voterapp.votersapp.exception.OperationNonPermittedException;
import com.voterapp.votersapp.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionServiceImplementation implements PositionService {
    private final ObjectsValidator <CreatePositionRequest> validator;
    private final PositionMapper mapper;
    private final PositionRepository positionRepository;

    @Override
    public Long createPosition(CreatePositionRequest createPositionRequest) {
        validator.validate(createPositionRequest);
        var position = mapper.toPosition(createPositionRequest);
        var positionHasAlreadyAnAccount = positionRepository.existsPositionByName(createPositionRequest.getName());
        if (positionHasAlreadyAnAccount) {
            throw new OperationNonPermittedException("The position has been registered already");
        }
        return positionRepository.save(position).getId();
    }




    public List<PositionResponse> findAll() {
        return positionRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public PositionResponse findById(Long id) {
        return positionRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("No position found with the ID:: " + id));
    }

    public void delete(Long id) {
        positionRepository.deleteById(id);
    }


}

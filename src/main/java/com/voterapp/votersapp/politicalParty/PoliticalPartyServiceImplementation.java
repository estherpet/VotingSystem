package com.voterapp.votersapp.politicalParty;

import com.voterapp.votersapp.exception.OperationNonPermittedException;
import com.voterapp.votersapp.validator.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PoliticalPartyServiceImplementation implements PoliticalPartyService{
    private final ObjectsValidator <CreatePoliticalPartyRequest> validator;
    private final PoliticalPartyMapper mapper;
    private final PoliticalPartyRepository politicalPartyRepository;

    @Override
    public Long createPoliticalParty(CreatePoliticalPartyRequest createPoliticalPartyRequest) {
        validator.validate(createPoliticalPartyRequest);
        var politicalParty = mapper.toPoliticalParty(createPoliticalPartyRequest);
        var positionHasAlreadyAnAccount = politicalPartyRepository.existsPoliticalPartiesByName(createPoliticalPartyRequest.getName());
        if (positionHasAlreadyAnAccount) {
            throw new OperationNonPermittedException("The political party has been registered already");
        }
        return politicalPartyRepository.save(politicalParty).getId();
    }




    public List<PoliticalPartyResponse> findAll() {
        return politicalPartyRepository.findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public PoliticalPartyResponse findById(Long id) {
        return politicalPartyRepository.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new EntityNotFoundException("No political party found with the ID:: " + id));
    }

    public void delete(Long id) {
        politicalPartyRepository.deleteById(id);
    }


}

package com.voterapp.votersapp.position;



import com.voterapp.votersapp.candidate.CandidateResponse;
import com.voterapp.votersapp.candidate.CandidateService;
import com.voterapp.votersapp.candidate.CreateCandidateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/candidate")
@RequiredArgsConstructor
public class CandidateController {

  private final CandidateService service;

  @PostMapping
  public Long save(@RequestBody CreateCandidateRequest createCandidateRequest) {
    return service.createCandidate(createCandidateRequest);
  }

  @GetMapping
  public ResponseEntity<List<CandidateResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{candidate-id}")
  public ResponseEntity<CandidateResponse> findById(@PathVariable("candidate-id") Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @DeleteMapping("/{candidate-id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(@PathVariable("candidate-id") Long id) {
    service.delete(id);
  }

}

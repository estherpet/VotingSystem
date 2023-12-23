package com.voterapp.votersapp.vote;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/election")
@RequiredArgsConstructor
public class ElectionController {

  private final ElectionService service;

  @PostMapping
  public Long save(@RequestBody CreateElectionRequest createElectionRequest) {
    return service.createElection(createElectionRequest);
  }

  @GetMapping
  public ResponseEntity<List<CreateElectionResponse>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @GetMapping("/{election-id}")
  public ResponseEntity<CreateElectionResponse> findById(@PathVariable("election-id") Long id) {
    return ResponseEntity.ok(service.findById(id));
  }

  @DeleteMapping("/{election-id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void delete(@PathVariable("election-id") Long id) {
    service.delete(id);
  }

}

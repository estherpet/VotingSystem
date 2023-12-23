package com.voterapp.votersapp.candidate;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
//@Tag(name = "Accounts")
public class CandidateController {
//
//  private final AccountService service;
//
//  @PostMapping
//  public Integer save(
//      @RequestBody AccountRequest account
//  ) {
//    return service.create(account);
//  }
//
//  @GetMapping
//  public ResponseEntity<List<AccountResponse>> findAll() {
//    return ResponseEntity.ok(service.findAll());
//  }
//
//  @GetMapping("/{account-id}")
//  public ResponseEntity<AccountResponse> findById(
//      @PathVariable("account-id") Integer id
//  ) {
//    return ResponseEntity.ok(service.findById(id));
//  }
//
//  @DeleteMapping("/{account-id}")
//  @ResponseStatus(HttpStatus.ACCEPTED)
//  public void delete(
//      @PathVariable("account-id") Integer id
//  ) {
//    service.delete(id);
//  }

}

package com.heroku.banks.controller;

import com.heroku.banks.model.BankBranch;
import com.heroku.banks.repository.BankBranchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/banks")
public class BankBranchController {
  @Autowired private BankBranchRepository repository;

  @GetMapping
  public List<BankBranch> getBankBranches() {
    return repository.findAll();
  }

  @GetMapping("/{ifscCode}")
  public BankBranch getBranchByIfscCode(@PathVariable("ifscCode") String ifscCode) {
    return repository.findById(ifscCode).get();
  }
}

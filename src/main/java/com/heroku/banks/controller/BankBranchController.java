package com.heroku.banks.controller;

import com.heroku.banks.Constants;
import com.heroku.banks.exception.BusinessException;
import com.heroku.banks.model.BankBranch;
import com.heroku.banks.repository.BankBranchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/banks")
public class BankBranchController {
  @Autowired private BankBranchRepository repository;

  @GetMapping
  public List<BankBranch> getBankBranches(
      @RequestParam(name = "bankName") String bankName, @RequestParam(name = "city") String city) {
    return repository.findByBankNameIgnoreCaseAndCityIgnoreCase(bankName, city);
  }

  @GetMapping("/{ifscCode}")
  public BankBranch getBranchByIfscCode(@PathVariable("ifscCode") String ifscCode) {
    return repository
        .findById(ifscCode)
        .orElseThrow(
            () ->
                new BusinessException(
                    Constants.RESOURCE_NOT_FOUND,
                    String.format("Branch identified by ifsc code %s does not exists.", ifscCode)));
  }
}

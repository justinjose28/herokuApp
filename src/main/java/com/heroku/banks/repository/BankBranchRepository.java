package com.heroku.banks.repository;

import com.heroku.banks.model.BankBranch;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBranchRepository extends JpaRepository<BankBranch, String> {

  List<BankBranch> findByBankNameIgnoreCaseAndCityIgnoreCase(String bankName, String city);
}

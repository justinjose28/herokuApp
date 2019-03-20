package com.heroku.banks.repository;

import com.heroku.banks.model.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankBranchRepository extends JpaRepository<BankBranch, String> {}

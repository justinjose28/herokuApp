package com.heroku.banks.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Table(name = "bank_branches")
@Entity
public class BankBranch {

  @Column(name = "ifsc")
  @Id
  private String ifscCode;

  @Column(name = "bank_id")
  private Long bankId;

  @Column(name = "branch")
  private String branch;

  @Column(name = "address")
  private String address;

  @Column(name = "city")
  private String city;

  @Column(name = "district")
  private String district;

  @Column(name = "state")
  private String state;

  @Column(name = "bankName")
  private String bankName;
}

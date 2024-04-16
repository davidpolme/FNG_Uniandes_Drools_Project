package com.sample;

import java.util.Date;

public class Credit {
	private String id;
	private User financialIntermediary;
	private User borrower;
	private Double amount;
	private Double interestRate;
	private Integer termInMonths;
	private String status;
	private Date startDate;
	
	
	//-----------------------------------
	//------- Constructors --------------
	//-----------------------------------
	public Credit(String id, User financialIntermediary, User borrower, Double amount, Double interestRate,
			Integer termInMonths, String status, Date startDate) {
		super();
		this.id = id;
		this.financialIntermediary = financialIntermediary;
		this.borrower = borrower;
		this.amount = amount;
		this.interestRate = interestRate;
		this.termInMonths = termInMonths;
		this.status = status;
		this.startDate = startDate;
	}
	
	
	
	//-----------------------------------
	//------ Getters and Setters --------
	//-----------------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getFinancialIntermediary() {
		return financialIntermediary;
	}
	public void setFinancialIntermediary(User financialIntermediary) {
		this.financialIntermediary = financialIntermediary;
	}
	public User getBorrower() {
		return borrower;
	}
	public void setBorrower(User borrower) {
		this.borrower = borrower;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}
	public Integer getTermInMonths() {
		return termInMonths;
	}
	public void setTermInMonths(Integer termInMonths) {
		this.termInMonths = termInMonths;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	

}

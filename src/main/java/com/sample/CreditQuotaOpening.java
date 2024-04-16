package com.sample;

import java.util.List;

public class CreditQuotaOpening {

	private Integer id;
	private String documentType; 
	private Integer CIIUCode;
	private Credit creditReference;
	private Warranty warrantyReference;
	private Debtor deptor;
	private Intermediary bank;

	
	//-----------------------------------
	//------- Constructors --------------
	//-----------------------------------
	public CreditQuotaOpening(Integer id, String documentType, Integer cIIUCode,
			Credit creditReference, Warranty warrantyReference, Debtor debtor, Intermediary bank) {
		super();
		this.id = id;
		this.documentType = documentType;
		CIIUCode = cIIUCode;
		this.creditReference = creditReference;
		this.warrantyReference = warrantyReference;
		this.bank = bank;
		this.deptor = debtor;
	}

	
	public static List<CreditQuotaOpening> createCreditQuotaOpeningsFromFileData(List<String[]> data){
		return null;
	
	}
	
	public static CreditQuotaOpening createCreditQuotaOpeningFromFileData(String data){
		return null;
		
	}
	

	//-----------------------------------
	//------ Getters and Setters --------
	//-----------------------------------
	
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDocumentType() {
		return documentType;
	}


	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}


	public Integer getCIIUCode() {
		return CIIUCode;
	}


	public void setCIIUCode(Integer cIIUCode) {
		CIIUCode = cIIUCode;
	}


	public Credit getCreditReference() {
		return creditReference;
	}


	public void setCreditReference(Credit creditReference) {
		this.creditReference = creditReference;
	}


	public Warranty getWarrantyReference() {
		return warrantyReference;
	}


	public void setWarrantyReference(Warranty warrantyReference) {
		this.warrantyReference = warrantyReference;
	}


	public Debtor getDebtor() {
		return deptor;
	}


	public void setDebtor(Debtor debtor) {
		this.deptor = debtor;
	}


	public Intermediary getBank() {
		return bank;
	}


	public void setBank(Intermediary bank) {
		this.bank = bank;
	}
	
}

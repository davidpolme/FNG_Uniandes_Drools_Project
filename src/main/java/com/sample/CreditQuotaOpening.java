package com.sample;

import java.util.List;

public class CreditQuotaOpening {

	private Integer id;
	private String documentType; 
	private Integer CIIUCode;
	private Credit creditReference;
	private Warranty warrantyReference;
	private Debtor debtor;
	private Intermediary bank;
	private Portal portal;

	
	//-----------------------------------
	//------- Constructors --------------
	//-----------------------------------
	public CreditQuotaOpening(Integer id, String documentType, Integer cIIUCode,
			Credit creditReference, Warranty warrantyReference, Debtor debtor, Intermediary bank, Portal portal) {
		super();
		this.id = id;
		this.documentType = documentType;
		CIIUCode = cIIUCode;
		this.creditReference = creditReference;
		this.warrantyReference = warrantyReference;
		this.bank = bank;
		this.debtor = debtor;
		this.portal = portal;
	}

	
	public static List<CreditQuotaOpening> createQuotaOpeningsFromData(List<String[]> data, Portal portal){
		return null;
	
	}
	
	public static CreditQuotaOpening createQuotaOpeningFromData(String data){
		return null;
		
	}
	
	public void saveCrediQuotaIntoSystem() {
		// TODO: send a message to the Portal system to save this process
		System.out.println("This credit openning has been completed successfully");
	}
	
	
	public boolean validateIntermediaryNit(){
		String bankNit = this.bank.getId().toString();
		boolean isValid1 = bankNit.length() == 10;
		if (!isValid1) {
			System.out.println("Number of characters different than 10, validate the NIT of the Financial Intermediary and update it");	
		}
		
		boolean isValid2 = Utils.isNumeric(bankNit);
		
		if (!isValid2) {
			System.out.println("Non-numeric characters exist, validate the NIT of the financial intermediary, correct the wrong character");	
		}
		
		boolean isValid3 = portal.doesIntermediaryExist(bank.getId());
		if (!isValid3) {
			System.out.println("The NIT number does not belong to the registered financial intermediaries, action validate the NIT number of the intermediary");	
		}
		
		return isValid1 && isValid2 && isValid3;
	}
	
	public boolean validateDebtorId(){
		String debtorId = this.debtor.getId();
		boolean isValid = debtorId.length() > 10 && this.debtor.getIdType() == Debtor.CC;
		if (!isValid) {
			System.out.println("Id is of type CC and number of characters is more than 10, validate the id and update it");	
		}
		
		boolean isValid2 = Utils.isNumeric(debtorId);
		
		if (!isValid2) {
			System.out.println("Non-numeric characters exist, validate the id of the user, correct the wrong character");	
		}
		
		return isValid && isValid2;
	}
	
	public boolean validateDeptorTypeId(){
		String idType = this.debtor.getIdType();
		boolean isValid = idType.equals(Debtor.CC) || idType.equals(Debtor.CE) || idType.equals(Debtor.NIT);
		
		if (!isValid) {
			System.out.println("Error in document type allowed values “NIT, CC, CE” if it contains a different value, adjust the field and execute the process again.");	
		}
		
		return isValid;
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
		return debtor;
	}


	public void setDebtor(Debtor debtor) {
		this.debtor = debtor;
	}


	public Intermediary getBank() {
		return bank;
	}


	public void setBank(Intermediary bank) {
		this.bank = bank;
	}
	
}

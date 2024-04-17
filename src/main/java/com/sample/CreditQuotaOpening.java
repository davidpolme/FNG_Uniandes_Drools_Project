package com.sample;

import java.util.List;

public class CreditQuotaOpening {

	private Integer id;
	private String documentType; 
	private String CIIUCode;
	private Credit creditReference;
	private Warranty warrantyReference;
	private Debtor debtor;
	private Intermediary bank;
	private Portal portal;

	
	//-----------------------------------
	//------- Constructors --------------
	//-----------------------------------
	public CreditQuotaOpening(Integer id, String documentType, String cIIUCode,
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

	
	public static CreditQuotaOpening[] createQuotaOpeningsFromData(List<String[]> data, Portal portal){
		//TODO: create method to read from CSV and create objects
		return null;
	
	}
	
	public static CreditQuotaOpening createQuotaOpeningFromData(String data){
		//TODO: create method to read from CSV and create objects
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
		boolean isValid = debtorId.length() <= 10 && this.debtor.getIdType() == Debtor.CC;
		if (!isValid) {
			System.out.println("Id is of type CC and number of characters is more than 10, validate the id and update it");	
		}
		
		boolean isValid2 = Utils.isNumeric(debtorId);
		
		if (!isValid2) {
			System.out.println("Non-numeric characters exist, validate the id of the user, correct the wrong character");	
		}
		
		return isValid && isValid2;
	}
	
	public boolean validateDebtorTypeId(){
		String idType = this.debtor.getIdType();
		boolean isValid = idType.equals(Debtor.CC) || idType.equals(Debtor.CE) || idType.equals(Debtor.NIT);
		
		if (!isValid) {
			System.out.println("Non-numeric characters exist, validate the id of the user, correct the wrong character");	
		}
		
		return isValid;
	}
	
	public boolean validateMinicipalityCode(){
		String code = this.debtor.getMunicipalityCode();
	
		boolean isValid = portal.doesMunicipalityExist(code);
		
		if (!isValid) {
			System.out.println("The municipality code does not exist in the registered codes");	
		}
		
		boolean isValid2 =  code.length() <= 5;
		if (!isValid2) {
			System.out.println("The municipality code exceeds 5 numerical characters, action validate the municipality code and correct the error");	
		}
		
		boolean isValid3 = Utils.isNumeric(code);
		if (!isValid3) {
			System.out.println("There are non-numeric values in the Municipality code, action validate the municipality code and correct the error.");	
		}
		boolean isValid4 = code.isEmpty();
		if (!isValid4) {
			System.out.println("The municipality code field is empty, identify the municipality code and complete the field.");	
		}

		return isValid && isValid2 && isValid3 && isValid4;
	}
	
	public boolean validateCIIUCode(){
		boolean isValid = this.CIIUCode.length() <= 4;
		if (!isValid) {
			System.out.println("CIIU code exceeds 4 digits, action validate the code correct and execute again.");	
		}
		boolean isValid2 = Utils.isNumeric(this.CIIUCode);
		if (!isValid) {
			System.out.println("Alphanumeric characters in the code, action validate the alphanumeric characters and remove them from the code.");	
		}
		
		return isValid && isValid2;
	}
	
	public boolean validateCreditReference(){
		String reference = this.creditReference.getId();
		boolean isValid = reference.length() <= 14;
		if (!isValid) {
			System.out.println("Credit reference code exceeds 14 digits, action validate the code correct and execute again.");	
		}
		boolean isValid2 = Utils.isNumeric(reference);
		if (!isValid2) {
			System.out.println("Alphanumeric characters in the Credit reference, action validate the alphanumeric characters and remove them from the code.");	
		}
		return isValid && isValid2;
		
		
	}
	
	
	public boolean validateWarrantyCode(){
		String reference = this.warrantyReference.getId();
		boolean isValid = reference.length() <= 6;
		if (!isValid) {
			System.out.println("Warranty Code exceeds 6 digits, action validate the code correct and execute again.");	
		}
		boolean isValid2 = Utils.validateWarrantyCodePattern(reference);
		if (!isValid) {
			System.out.println("Warranty Code does not match the required pattern. The first three characters must be numeric, and the last three must be letters.");	
		}
		
		return isValid && isValid2;
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


	public String getCIIUCode() {
		return CIIUCode;
	}


	public void setCIIUCode(String cIIUCode) {
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

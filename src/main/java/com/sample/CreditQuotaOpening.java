package com.sample;

public class CreditQuotaOpening {

	private Integer id;
	private Integer municipalityCode;
	private String documentType; 
	private Integer CIIUCode;
	private Credit creditReference;
	private Warranty warrantyReference;

	
	//-----------------------------------
	//------- Constructors --------------
	//-----------------------------------
	public CreditQuotaOpening(Integer id, Integer municipalityCode, String documentType, Integer cIIUCode,
			Credit creditReference, Warranty warrantyReference) {
		super();
		this.id = id;
		this.municipalityCode = municipalityCode;
		this.documentType = documentType;
		CIIUCode = cIIUCode;
		this.creditReference = creditReference;
		this.warrantyReference = warrantyReference;
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


	public Integer getMunicipalityCode() {
		return municipalityCode;
	}


	public void setMunicipalityCode(Integer municipalityCode) {
		this.municipalityCode = municipalityCode;
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
	
}

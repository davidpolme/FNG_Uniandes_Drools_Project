package com.sample;
import java.util.ArrayList;


public class Portal {
	
	private ArrayList<Intermediary> financialIntermediaries;
	private ArrayList<Integer> municipalityCodes;
	private ArrayList<Role> roles;
	
	//-----------------------------------
	//------- Constructors --------------
	//-----------------------------------
	public Portal(ArrayList<Intermediary> financialIntermediaries, ArrayList<Integer> municipalityCodes,
			ArrayList<Role> roles) {
		this.financialIntermediaries = financialIntermediaries;
		this.municipalityCodes = municipalityCodes;
		this.roles = roles;
	}
	
	
	//-----------------------------------
	//------ Getters and Setters --------
	//-----------------------------------
	public ArrayList<Intermediary> getFinancialIntermediaries() {
		return financialIntermediaries;
	}

	public void setFinancialIntermediaries(ArrayList<Intermediary> financialIntermediaries) {
		this.financialIntermediaries = financialIntermediaries;
	}

	public ArrayList<Integer> getMunicipalityCodes() {
		return municipalityCodes;
	}

	public void setMunicipalityCodes(ArrayList<Integer> municipalityCodes) {
		this.municipalityCodes = municipalityCodes;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

}

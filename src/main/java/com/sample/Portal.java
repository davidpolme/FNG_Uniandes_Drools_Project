package com.sample;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Portal {
	
	private ArrayList<Intermediary> financialIntermediaries;
	private ArrayList<String> municipalityCodes;
	private ArrayList<Role> roles;
	private HashMap<String, List<String[]>> reservations;
	private HashMap<String, List<String[]>> loadedDataFiles;
	
	//-----------------------------------
	//------- Constructors --------------
	//-----------------------------------
	public Portal(ArrayList<Intermediary> financialIntermediaries, ArrayList<String> municipalityCodes,
			ArrayList<Role> roles, ArrayList<String> reservations) {
		this.financialIntermediaries = financialIntermediaries;
		this.municipalityCodes = municipalityCodes;
		this.roles = roles;
		this.loadedDataFiles = new HashMap<>();
		this.reservations = new HashMap<>();
		
	}
	
	
    public void addDataFiles(String fileName, List<String[]> data) {
        loadedDataFiles.put(fileName, data);
    }
    
    public List<String[]> getDataFileByName(String name){
    	return loadedDataFiles.get(name);
    }
    
    public List<String[]> getReservationData(String id){
    	return reservations.get(id);
    }
    
    public boolean doesIntermediaryExist(Integer id) {
        for (Intermediary intermediary : financialIntermediaries) {
            if (intermediary.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean doesMunicipalityExist(String id) {
        for (String codes : municipalityCodes) {
            if (codes.equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean cancelReservation(String idReservation) {
        List<String[]> reservationData = getDataFileByName("reservations.csv");
        if (reservationData != null) {
            for (String[] reservation : reservationData) {
                if (reservation[0].equals(idReservation)) {
                    reservation[3] = "Cancelled";
                    return true; 
                }
            }
        }	
        
        return false; 
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

	public ArrayList<String> getMunicipalityCodes() {
		return municipalityCodes;
	}

	public void setMunicipalityCodes(ArrayList<String> municipalityCodes) {
		this.municipalityCodes = municipalityCodes;
	}

	public ArrayList<Role> getRoles() {
		return roles;
	}

	public void setRoles(ArrayList<Role> roles) {
		this.roles = roles;
	}

}

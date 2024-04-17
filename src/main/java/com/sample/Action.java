package com.sample;

import java.io.IOException;
import java.util.List;

public class Action {
	private Role.Action actionType;
	private String fileName;
	private String fileRoute;
	private String idReservation;


	public Portal portal;
	private List<String[]> data;

	//-----------------------------------
	//------- Constructors --------------
	//-----------------------------------
	public Action(Role.Action actionType, Portal portal) {
		super();
		this.actionType = actionType;
		this.portal = portal;
	}
	
	//-----------------------------------
	//------ Load file functions --------
	//-----------------------------------

	public boolean validateCSVFileType() {
		boolean csv = FileLoader.isCSVFile(fileRoute);
		
		if(!csv) {
			System.out.println("ERROR: File is not of CSV type");
		}
		
		return csv;
	}
	
	
	public boolean validateFileIsNotEmpty() {
	   	try {
			List<String[]> data = FileLoader.loadCSVFile(fileRoute);
			
			if(!data.isEmpty()) {
				this.data = data;
			}
			
			return data.isEmpty();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void loadDataToPortal() {
		portal.addDataFiles(fileName, data);
		System.out.println("Data has been added to FNG portal");
	}
	
	
	//-----------------------------------
	//--- Mass cupos creation functions --
	//-----------------------------------
	
	public boolean fileExistsInPortal() {
		boolean fileExists = portal.getDataFileByName(fileName) != null;
		if(!fileExists) {
			System.out.println("ERROR: File does not exist in the system");
		}
		
		
		return fileExists;
	}	
	
	public boolean reserveExistsInPortal() {
		boolean reserveExists = portal.getReservationData(idReservation) != null;
		if(!reserveExists) {
			System.out.println("ERROR: Reserve does not exist in the system");
		}
		return reserveExists;
	}	
	
	public void cancelReservation(String idReservation) {

	    System.out.println("Cancelando reserva con ID: " + idReservation);

	    if (portal.cancelReservation(idReservation)) {
	        System.out.println("Reserva cancelada con éxito.");
	    } else {
	        System.out.println("Error al cancelar la reserva.");
	    }
	}
	
	
	//-----------------------------------
	//------ Getters and Setters --------
	//-----------------------------------
	public Role.Action getActionType() {
		return actionType;
	}
	public void setActionType(Role.Action actionType) {
		this.actionType = actionType;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileRoute() {
		return fileRoute;
	}
	public void setFileRoute(String fileRoute) {
		this.fileRoute = fileRoute;
	}
	public List<String[]> getData() {
		return data;
	}

	public void setData(List<String[]> data) {
		this.data = data;
	}
	
	public String getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}
	
	
	

	
	
}

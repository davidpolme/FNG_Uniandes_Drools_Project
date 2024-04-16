package com.sample;

import java.io.IOException;
import java.util.List;

public class Action {
	private Role.Action actionType;
	private String fileName;
	private String fileRoute;
	private Portal portal;
	
	
	public Action(Role.Action actionType, Portal portal) {
		super();
		this.actionType = actionType;
		this.portal = portal;
	}
	
	public boolean validateFileType() {
		return FileLoader.isCSVFile(fileRoute);
	}
	
	
	public boolean validateFileIsNotEmpty() {
	   	try {
			List<String[]> data = FileLoader.loadCSVFile(fileRoute);
			
			if(!data.isEmpty()) {
				portal.addDataFiles(fileName, data);
			}
			
			return data.isEmpty();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	

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
	
	
}

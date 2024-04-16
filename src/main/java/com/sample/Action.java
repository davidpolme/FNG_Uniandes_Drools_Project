package com.sample;

public class Action {
	private Role.Action actionType;
	private String fileName;
	private String fileRoute;
	
	
	public Action(Role.Action actionType) {
		super();
		this.actionType = actionType;
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

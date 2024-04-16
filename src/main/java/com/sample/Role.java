package com.sample;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Role {
	
	public static final Integer ADMIN_ROLE_ID = 123;
	public static final Integer USER_ROLE_ID = 456;
	
	private Integer id;
	private RoleType type;
	
	public enum RoleType {
	  ADMIN, USER;
	}
	
	 public enum Action {
	        UPDATE_QUOTA, CREATE_CREDIT, DELETE_QUOTA;
	    }
	 
	// Mapping from role types to allowed actions
    private static final Map<RoleType, Set<Action>> roleActionsMap = new HashMap<>();

    static {
        // Define the allowed actions for each role type
        roleActionsMap.put(RoleType.ADMIN, EnumSet.of(Action.UPDATE_QUOTA, Action.CREATE_CREDIT, Action.DELETE_QUOTA));
        roleActionsMap.put(RoleType.USER, EnumSet.of(Action.UPDATE_QUOTA));
    }
	
	
	public Role(Integer id, RoleType type) {
		this.id = id;
		this.type = type;
	}
	
    // Method to get the allowed actions for the role type
    public Set<Action> getAllowedActions() {
        return roleActionsMap.get(type);
    }
    
    
    // Method to check if the role can perform a specific action
    public boolean canDoAction(String action) {
      try {
         // Convert the input action string to the Action enum
         Action actionEnum = Action.valueOf(action.toUpperCase());
         // Check if the action is in the allowed actions set for the role type
         return getAllowedActions().contains(actionEnum);
      } catch (IllegalArgumentException e) {
         // If the action is not a valid Action enum, return false
         return false;
      }
    }
    

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public RoleType getType() {
		return type;
	}
	
	public void setType(RoleType type) {
		this.type = type;
	}
}

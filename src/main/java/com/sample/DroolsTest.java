package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsTest {
	


    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	
        	Portal portal = createPortal(kSession);
        	createUser(kSession);
        	
        	//1 Create loading action
        	//1.1 Check action and user permissions
        	//1.2 Check file restrictions
        	Action loadAnexo5Action = new Action(Role.Action.LOAD_ANEXO_5_FILE, portal);
        	String anexo5Name = "anexo5.csv";
        	loadAnexo5Action.setFileRoute("./");
        	loadAnexo5Action.setFileName(anexo5Name);
        	

     
        	
        	//2 Create cupos creation action
        	//2.1 Check file name in Portal loaded files
        	//2.2 Insert Credit opennings and validate data for each 
        	
            
 
            
            kSession.fireAllRules();
            kSession.dispose ();
            System.out.println("Aplicación finalizada con exito !!");
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

	private static void createUser(KieSession kSession) {
		ArrayList<Integer> roleIds = new ArrayList<>();
		roleIds.add(Role.USER_ROLE_ID);
		User fngUser = new User("123", User.PERSONA_NATURAL, "Andrea Bayona", "abayona", roleIds);
		kSession.insert(fngUser);
	}

	private static Portal createPortal(KieSession kSession) {
		// Create an ArrayList to hold User objects
		ArrayList<Intermediary> intermediaries = new ArrayList<>();

		// Create 5 dummy User objects and add them to the ArrayList
		intermediaries.add(new Intermediary(123, "Banco A"));
		intermediaries.add(new Intermediary(456, "Banco B"));
		intermediaries.add(new Intermediary(789, "Banco C"));
		intermediaries.add(new Intermediary(1011, "Banco D"));
		intermediaries.add(new Intermediary(1213, "Banco E"));
		
		ArrayList<Integer> municipalityCodes = new ArrayList<>();
		municipalityCodes.addAll(Arrays.asList(5001, 5002, 5004, 5005, 5006));
		
		ArrayList<Role> roles = new ArrayList<>();
		roles.add(new Role(Role.ADMIN_ROLE_ID, Role.RoleType.ADMIN));
		roles.add(new Role(Role.USER_ROLE_ID, Role.RoleType.USER));


		Portal portal = new Portal(intermediaries, municipalityCodes, roles);
		kSession.insert(portal);
		
		return portal;
	}
}

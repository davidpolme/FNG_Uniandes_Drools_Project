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
        	
        	createPortal(kSession);
        	createUser(kSession);
        	
        	String anexo5Route = "./anexo5.csv";
        	List<String[]> data = FileLoader.loadCSVFile(anexo5Route);
        	
        	
            
 
            
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

	private static void createPortal(KieSession kSession) {
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
	}
}

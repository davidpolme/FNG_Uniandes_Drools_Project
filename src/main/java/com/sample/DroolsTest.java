package com.sample;

import java.util.ArrayList;
import java.util.Arrays;

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
        	cuposOpeningProcessTest(kSession, portal);
        	cancelReservationAction(kSession, portal);
            
 
            
            kSession.fireAllRules();
            kSession.dispose ();
            System.out.println("Aplicaci�n finalizada con exito !!");
            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

	private static void cuposOpeningProcessTest(KieSession kSession, Portal portal) {
		//1 Create cupos loading file action
		//1.1 Check action and user permissions
		//1.2 Check file restrictions
		String anexo5Name = createAnexo5LoadingAction(kSession, portal);
		
		
		//2 cupos creation action
		//2.1 Check file name in Portal loaded files
		//2.2 Insert Credit openings and validate data for each 
		createCuposCreationAction(kSession, portal, anexo5Name);
		
		//3 Insert cupon opening
//		insertCuposOpening(kSession, portal, anexo5Name);
	}

	private static void createCuposCreationAction(KieSession kSession, Portal portal, String anexo5Name) {
		Action createCuposAction = new Action(Role.Action.GENERATE_CUPOS_PORTAL, portal);
		createCuposAction.setFileName(anexo5Name);
		kSession.insert(createCuposAction);
	}
	
	private static void cancelReservationAction(KieSession kSession, Portal portal) {
		Action cancelReserve = new Action(Role.Action.CANCEL_RESERVE, portal);
		cancelReserve.cancelReservation(null);
		kSession.insert(cancelReserve);
	}

	private static String createAnexo5LoadingAction(KieSession kSession, Portal portal) {
		Action loadAnexo5Action = new Action(Role.Action.LOAD_ANEXO_5_FILE, portal);
		String anexo5Name = "anexo5.csv";
		loadAnexo5Action.setFileRoute("./");
		loadAnexo5Action.setFileName(anexo5Name);
		kSession.insert(loadAnexo5Action);
	
		return anexo5Name;
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
		
		ArrayList<String> municipalityCodes = new ArrayList<>();
		municipalityCodes.addAll(Arrays.asList("5001", "5002", "5004", "5005", "5006"));
		
		ArrayList<Role> roles = new ArrayList<>();
		ArrayList<String> reservations = new ArrayList<>();
		roles.add(new Role(Role.ADMIN_ROLE_ID, Role.RoleType.ADMIN));
		roles.add(new Role(Role.USER_ROLE_ID, Role.RoleType.USER));


		Portal portal = new Portal(intermediaries, municipalityCodes, roles, reservations);
		kSession.insert(portal);
		
		return portal;
	}
	
	
}

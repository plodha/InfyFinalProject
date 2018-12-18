package com.infy.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.model.Boat;
import com.infy.model.BoatBooking;
import com.infy.model.User;
import com.infy.service.SeaQueenBoatsService;
import com.infy.service.SeaQueenBoatsServiceImpl;
import com.infy.utility.ContextFactory;

@RestController
@CrossOrigin
@RequestMapping(value="sqbBoats")
public class SQHBSpringRESTAPI {


	//======================      BOAT API       ========================================================================

	private SeaQueenBoatsService seaQueenBoatsService;
	//********************** Fetch all available BOATS  ******************

	@RequestMapping(method=RequestMethod.GET, value="boatsAll")
	public ResponseEntity<List<Boat>> getAllBoats(){
		
		System.out.println("Inside API");
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Boat>> responseEntity=null;

		List<Boat> allBoats=new ArrayList<Boat>();
		seaQueenBoatsService = (SeaQueenBoatsService) ContextFactory.getContext().getBean(SeaQueenBoatsServiceImpl.class);
		
		try {
			allBoats=seaQueenBoatsService.getAllBoats();
			responseEntity = new ResponseEntity<>(allBoats,HttpStatus.OK);

		}


		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Boat boat = new Boat();
			boat.setMessage(errorMessage);			
			allBoats.add(boat);			
			responseEntity = new ResponseEntity<>(allBoats,HttpStatus.BAD_REQUEST);
			

		}

		return responseEntity;

	}

	//********************** Fetch Details of a particular BOAT (boatID)  *******************

	@RequestMapping(method=RequestMethod.GET, value="boatDetail/{boatID}")
	public ResponseEntity<Boat> getBoatByID(@PathVariable("boatID") String boatId){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Boat> responseEntity=null;
		Boat returnBoat = new Boat();
		seaQueenBoatsService = (SeaQueenBoatsService) ContextFactory.getContext().getBean(SeaQueenBoatsServiceImpl.class);
		try {
			returnBoat=seaQueenBoatsService.getBoatById(boatId);
			
			responseEntity = new ResponseEntity<Boat>(returnBoat,HttpStatus.OK);

		}


		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Boat boat = new Boat();
			boat.setMessage(errorMessage);
			responseEntity = new ResponseEntity<Boat>(boat,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}


	//********************** Fetch  BOATS by TYPE and LOCATION    *******************

	

	//**************************   UPDATE boat     *********************

	@RequestMapping(method=RequestMethod.PUT, value="boatUpdate")
	public ResponseEntity<Boat> updateBoat(@RequestBody Boat boatToUpdate){

		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Boat> responseEntity=null;
		Boat returnUpdatedBoat = new Boat();
		seaQueenBoatsService = (SeaQueenBoatsService) ContextFactory.getContext().getBean(SeaQueenBoatsServiceImpl.class);
		
		try {
			returnUpdatedBoat=seaQueenBoatsService.updateBoat(boatToUpdate);
			returnUpdatedBoat.setMessage(environment.getProperty("SeaQueenBoatsService.BOAT_UPDATE_SUCCESS"));
			responseEntity = new ResponseEntity<Boat>(returnUpdatedBoat,HttpStatus.OK);

		}

		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Boat boat = new Boat();
			boat.setMessage(errorMessage);
			
			responseEntity = new ResponseEntity<Boat>(returnUpdatedBoat,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}


	//**************************   ADD boat     *********************

	@RequestMapping(method=RequestMethod.POST, value="boatAdd")
	public ResponseEntity<Boat> addBoat(@RequestBody Boat boatToAdd){

		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Boat> responseEntity=null;
		Boat returnAddedBoat = new Boat();
		seaQueenBoatsService = (SeaQueenBoatsService) ContextFactory.getContext().getBean(SeaQueenBoatsServiceImpl.class);
		
		try {
			returnAddedBoat=seaQueenBoatsService.addBoat(boatToAdd);
			returnAddedBoat.setMessage(environment.getProperty("SeaQueenBoatsService.BOAT_ADD_SUCCESS"));
			responseEntity = new ResponseEntity<Boat>(returnAddedBoat,HttpStatus.OK);

		}

		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Boat boat = new Boat();
			boat.setMessage(errorMessage);
			responseEntity = new ResponseEntity<Boat>(returnAddedBoat,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}

	
	

}

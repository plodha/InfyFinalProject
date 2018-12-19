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

import com.infy.model.Computer;
import com.infy.service.ComputerService;
import com.infy.service.ComputerServiceImpl;
import com.infy.utility.ContextFactory;



@RestController
@CrossOrigin
@RequestMapping(value="Computers")
public class ComputerSpringRESTAPI {


	//======================      COMPUTER API       ========================================================================

	private ComputerService computerService;
	//********************** Fetch all available BOATS  ******************

	@RequestMapping(method=RequestMethod.GET, value="computersAll")
	public ResponseEntity<List<Computer>> getAllComputers(){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<List<Computer>> responseEntity=null;

		List<Computer> allComputers=new ArrayList<Computer>();
		computerService = (ComputerService) ContextFactory.getContext().getBean(ComputerServiceImpl.class);
		
		try {
			allComputers=computerService.getAllComputers();
			responseEntity = new ResponseEntity<>(allComputers,HttpStatus.OK);

		}


		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Computer computer = new Computer();
			computer.setMessage(errorMessage);			
			allComputers.add(computer);			
			responseEntity = new ResponseEntity<>(allComputers,HttpStatus.BAD_REQUEST);
			

		}

		return responseEntity;

	}

	//********************** Fetch Details of a particular BOAT (computerID)  *******************

	@RequestMapping(method=RequestMethod.GET, value="computerDetail/{computerID}")
	public ResponseEntity<Computer> getComputerByID(@PathVariable("computerID") String computerId){
		
		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Computer> responseEntity=null;
		Computer returnComputer = new Computer();
		computerService = (ComputerService) ContextFactory.getContext().getBean(ComputerServiceImpl.class);
		try {
			returnComputer=computerService.getComputerById(computerId);
			
			responseEntity = new ResponseEntity<Computer>(returnComputer,HttpStatus.OK);

		}


		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Computer computer = new Computer();
			computer.setMessage(errorMessage);
			responseEntity = new ResponseEntity<Computer>(computer,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}


	//********************** Fetch  BOATS by TYPE and LOCATION    *******************

	

	//**************************   UPDATE computer     *********************

	@RequestMapping(method=RequestMethod.PUT, value="computerUpdate")
	public ResponseEntity<Computer> updateComputer(@RequestBody Computer computerToUpdate){

		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Computer> responseEntity=null;
		Computer returnUpdatedComputer = new Computer();
		computerService = (ComputerService) ContextFactory.getContext().getBean(ComputerServiceImpl.class);
		
		try {
			returnUpdatedComputer=computerService.updateComputer(computerToUpdate);
			returnUpdatedComputer.setMessage(environment.getProperty("ComputerService.PCPicker.PC_UPDATE_SUCCESS"));
			responseEntity = new ResponseEntity<Computer>(returnUpdatedComputer,HttpStatus.OK);

		}

		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Computer computer = new Computer();
			computer.setMessage(errorMessage);
			
			responseEntity = new ResponseEntity<Computer>(returnUpdatedComputer,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}


	//**************************   ADD computer     *********************

	@RequestMapping(method=RequestMethod.POST, value="computerAdd")
	public ResponseEntity<Computer> addComputer(@RequestBody Computer computerToAdd){

		Environment environment= ContextFactory.getContext().getEnvironment();
		ResponseEntity<Computer> responseEntity=null;
		Computer returnAddedComputer = new Computer();
		computerService = (ComputerService) ContextFactory.getContext().getBean(ComputerServiceImpl.class);
		
		try {
			returnAddedComputer=computerService.addComputer(computerToAdd);
			returnAddedComputer.setMessage(environment.getProperty("PCPicker.PC_ADD_SUCCESS"));
			responseEntity = new ResponseEntity<Computer>(returnAddedComputer,HttpStatus.OK);

		}

		catch(Exception exception) {
			String errorMessage = environment.getProperty(exception.getMessage());
			Computer computer = new Computer();
			computer.setMessage(errorMessage);
			responseEntity = new ResponseEntity<Computer>(returnAddedComputer,HttpStatus.BAD_REQUEST);

		}

		return responseEntity;

	}

	
	

}

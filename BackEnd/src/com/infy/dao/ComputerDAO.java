package com.infy.dao;

import java.util.List;
import com.infy.model.Computer;
import com.infy.model.ComputerPurchase;
import com.infy.model.User;


public interface ComputerDAO {
	//Computers --------------public
	public List<Computer> getAllComputers() throws Exception; //acc to filter parametes in input bean
	public Computer addComputer(Computer computer) throws Exception;
	public Computer updateComputer(Computer computer) throws Exception;
	public Computer getComputerById(String computerId) throws Exception;
	

	
	
	
	// BoatBooking-----------------------
	
	public ComputerPurchase purchaseComputer(ComputerPurchase computerPurchase) throws Exception;

}

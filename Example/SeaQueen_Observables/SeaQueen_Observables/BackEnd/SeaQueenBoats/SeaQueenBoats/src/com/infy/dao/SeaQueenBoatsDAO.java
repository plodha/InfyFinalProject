package com.infy.dao;

import java.util.List;

import com.infy.model.Boat;
import com.infy.model.BoatBooking;
import com.infy.model.User;



public interface SeaQueenBoatsDAO {
	
	
	// Boats ---------------------
	
	public List<Boat> getAllBoats() throws Exception; //acc to filter parametes in input bean
	public Boat addBoat(Boat boat) throws Exception;
	public Boat updateBoat(Boat boat) throws Exception;
	public Boat deleteBoat(Boat boat) throws Exception;
	public Boat getBoatById(String boatId) throws Exception;
	

	
	
	
	// BoatBooking-----------------------
	
	public BoatBooking bookBoat(BoatBooking boatBooking) throws Exception;
	
	
	

}

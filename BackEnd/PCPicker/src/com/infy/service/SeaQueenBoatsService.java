package com.infy.service;

import java.util.List;

import com.infy.model.Boat;
import com.infy.model.BoatBooking;
import com.infy.model.User;

public interface SeaQueenBoatsService {
	
		 
		
		 public List<Boat> getAllBoats() throws Exception;
		 
		 public Boat addBoat(Boat boat) throws Exception;
		 public Boat updateBoat(Boat boat) throws Exception;
		 public Boat getBoatById(String boatId) throws Exception;
		
		 //acc to filter parametes in input bean
		
		
				
		
		
		// BoatBooking-----------------------
		
		
		/*
		public BoatBooking updateBoatBooking(BoatBooking boatBooking) throws Exception;
		public BoatBooking cancelBoatBooking(BoatBooking boatBooking) throws Exception;
		
		public List<BoatBooking> getAllBoatBookings(BoatBooking boatBooking) throws Exception;
		
		*/

}

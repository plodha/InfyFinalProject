package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.SeaQueenBoatsDAO;
import com.infy.model.Boat;
import com.infy.model.BoatBooking;
import com.infy.model.User;

@Service
@Transactional(readOnly=true)
public class SeaQueenBoatsServiceImpl implements SeaQueenBoatsService {
	
	@Autowired
	private SeaQueenBoatsDAO seaQueenBoatsDAO;

	@Override
	public List<Boat> getAllBoats() throws Exception {
		List<Boat> listOfBoats= seaQueenBoatsDAO.getAllBoats();
		if(listOfBoats.size()<=0){
			throw new Exception("SeaQueenBoatsService.NO_BOATS_AVAILABLE");
		}
		return listOfBoats;
	}

	
	
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Boat addBoat(Boat boat) throws Exception {
		Boat addedBoat=seaQueenBoatsDAO.addBoat(boat);
		if(addedBoat==null){
			throw new Exception("SeaQueenBoatsService.BOAT_NOT_ADDED");
		}
		return addedBoat;
	}

	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Boat updateBoat(Boat boat) throws Exception {
		Boat updatedBoat=seaQueenBoatsDAO.updateBoat(boat);
		if(updatedBoat==null){
			throw new Exception("SeaQueenBoatsService.BOAT_NOT_UPDATED");
		}
		return updatedBoat;
	}

	@Override
	public Boat getBoatById(String boatId) throws Exception {
		Boat boatDetail=seaQueenBoatsDAO.getBoatById(boatId);
		if(boatDetail==null){
			throw new Exception("SeaQueenBoatsService.BOAT_DOES_NOT_EXIST");
		}
		return boatDetail;
	}
}



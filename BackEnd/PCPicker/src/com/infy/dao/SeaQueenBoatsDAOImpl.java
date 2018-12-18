package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.BoatBookingEntity;
import com.infy.entity.BoatEntity;
import com.infy.entity.UserEntity;
import com.infy.model.Boat;
import com.infy.model.BoatBooking;
import com.infy.model.User;


@Repository
public class SeaQueenBoatsDAOImpl implements SeaQueenBoatsDAO {

	//**********  USERS  *********
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Boat> getAllBoats() throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Boat> allBoats = null;
		
			
			Query qry = session.createQuery("select boat from BoatEntity boat");
			
			@SuppressWarnings("unchecked")
			List<BoatEntity> allBoatsEntities = qry.list();
			
			allBoats = new ArrayList<Boat>();
			
			for (BoatEntity i : allBoatsEntities) {
				
				Boat b = new Boat();
				b.setBoatId(i.getBoatId().toString());
				b.setBoatType(i.getBoatType());
				b.setAllowedDays(i.getAllowedDays());
				b.setBasePrice(i.getBasePrice());
				b.setDescription(i.getDescription());
				b.setLocation(i.getLocation());
				b.setDiscount(i.getDiscount());
				b.setBookingStart(i.getBookingStart());
				
				allBoats.add(b);
				
			}
			
			return allBoats;
			
		
		
	}
	
	@Override
	public Boat getBoatById(String boatId) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Integer pk = Integer.parseInt(boatId);
		
			BoatEntity boatEntity= (BoatEntity) session.get(BoatEntity.class, pk);
			Boat boat= new Boat();
			if (boatEntity != null) {
				boat.setAllowedDays(boatEntity.getAllowedDays());
				boat.setBasePrice(boatEntity.getBasePrice());
				boat.setBoatId(boatId);
				boat.setBoatType(boatEntity.getBoatType());
				boat.setDescription(boatEntity.getDescription());
				boat.setLocation(boatEntity.getLocation());
				boat.setDiscount(boatEntity.getDiscount());
				boat.setBookingStart(boatEntity.getBookingStart());
				
				
				return boat;
			}
			return null;
		
	}

	@Override
	public Boat addBoat(Boat boat) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		

		BoatEntity be = new BoatEntity();
			
			be.setBoatType(boat.getBoatType());
			be.setAllowedDays(boat.getAllowedDays());
			be.setBasePrice(boat.getBasePrice());
			be.setDescription(boat.getDescription());
			be.setLocation(boat.getLocation());
			
			be.setDiscount(boat.getDiscount());
			be.setBookingStart(boat.getBookingStart());			
			boat.setBoatId(session.save(be).toString());		
		return boat;
	}

	@Override
	public Boat updateBoat(Boat boat) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Integer pk = Integer.parseInt(boat.getBoatId());
		
		BoatEntity boatEntity = (BoatEntity) session.get(
					BoatEntity.class, pk );
			
			if (boatEntity != null) {
				
			boatEntity.setAllowedDays(boat.getAllowedDays());
			boatEntity.setBasePrice(boat.getBasePrice());
			boatEntity.setBoatType(boat.getBoatType());
			boatEntity.setDescription(boat.getDescription());
			boatEntity.setLocation(boat.getLocation());
			
			boatEntity.setDiscount(boat.getDiscount());
			boatEntity.setBookingStart(boat.getBookingStart());
			
			}
		
		return boat;
	}

	@Override
	public Boat deleteBoat(Boat boat) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	//*************  BOAT--BOOKING  **************************
	
	@Override
	public BoatBooking bookBoat(BoatBooking boatBooking) throws Exception {
		
			// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
			

			BoatBookingEntity be = new BoatBookingEntity();
				
				be.setBoatId(boatBooking.getBoatId());
				be.setUserId(boatBooking.getUserId());
				
				be.setStartDate(boatBooking.getStartDate());
				be.setEndDate(boatBooking.getEndDate());
				be.setTotalCost(boatBooking.getTotalCost());
				be.setMobileNo(boatBooking.getMobileNo());
				be.setDiscount(boatBooking.getDiscount());			
			return boatBooking;
		}	
}

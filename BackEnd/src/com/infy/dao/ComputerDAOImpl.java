package com.infy.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infy.entity.ComputerPurchaseEntity;
import com.infy.entity.ComputerPurchaseEntity;
import com.infy.entity.ComputerEntity;
import com.infy.entity.ComputerEntity;
import com.infy.entity.UserEntity;
import com.infy.model.Computer;
import com.infy.model.ComputerPurchase;
import com.infy.model.Computer;
import com.infy.model.ComputerPurchase;
import com.infy.model.User;

@Repository
public class ComputerDAOImpl implements ComputerDAO {


	//**********  USERS  *********
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<Computer> getAllComputers() throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<Computer> allComputers = null;


		Query qry = session.createQuery("select computer from ComputerEntity computer");

		@SuppressWarnings("unchecked")
		List<ComputerEntity> allComputersEntities = qry.list();

		allComputers = new ArrayList<Computer>();

		for (ComputerEntity i : allComputersEntities) {

			Computer b = new Computer();
			b.setComputerId(i.getComputerId().toString());
			b.setComputerType(i.getComputerType());
			b.setAllowedDays(i.getAllowedDays());
			b.setBasePrice(i.getBasePrice());
			b.setDescription(i.getDescription());
			b.setLocation(i.getLocation());
			b.setDiscount(i.getDiscount());
			b.setPurchaseStart(i.getPurchaseStart());

			allComputers.add(b);

		}

		return allComputers;



	}

	@Override
	public Computer getComputerById(String computerId) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Integer pk = Integer.parseInt(computerId);

		ComputerEntity computerEntity= (ComputerEntity) session.get(ComputerEntity.class, pk);
		Computer computer= new Computer();
		if (computerEntity != null) {
			computer.setAllowedDays(computerEntity.getAllowedDays());
			computer.setBasePrice(computerEntity.getBasePrice());
			computer.setComputerId(ComputerId);
			computer.setComputerType(computerEntity.getComputerType());
			computer.setDescription(computerEntity.getDescription());
			computer.setLocation(computerEntity.getLocation());
			computer.setDiscount(computerEntity.getDiscount());
			computer.setPurchaseStart(computerEntity.getPurchaseStart());


			return computer;
		}
		return null;

	}

	@Override
	public Computer addComputer(Computer computer) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();


		ComputerEntity be = new ComputerEntity();

		be.setComputerType(computer.getComputerType());
		be.setAllowedDays(computer.getAllowedDays());
		be.setBasePrice(computer.getBasePrice());
		be.setDescription(computer.getDescription());
		be.setLocation(computer.getLocation());

		be.setDiscount(computer.getDiscount());
		be.setPurchaseStart(computer.getPurchaseStart());			
		computer.setComputerId(session.save(be).toString());		
		return computer;
	}

	@Override
	public Computer updateComputer(Computer computer) throws Exception {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Integer pk = Integer.parseInt(computer.getComputerId());

		ComputerEntity computerEntity = (ComputerEntity) session.get(
				ComputerEntity.class, pk );

		if (computerEntity != null) {

			computerEntity.setAllowedDays(computer.getAllowedDays());
			computerEntity.setBasePrice(computer.getBasePrice());
			computerEntity.setComputerType(computer.getComputerType());
			computerEntity.setDescription(computer.getDescription());
			computerEntity.setLocation(computer.getLocation());

			computerEntity.setDiscount(computer.getDiscount());
			computerEntity.setPurchaseStart(computer.getPurchaseStart());

		}

		return computer;
	}

	@Override
	public Computer deleteComputer(Computer computer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	//*************  BOAT--BOOKING  **************************

	@Override
	public ComputerPurchase bookComputer(ComputerPurchase computerPurchase) throws Exception {

		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();


		ComputerPurchaseEntity be = new ComputerPurchaseEntity();

		be.setComputerId(computerPurchase.getComputerId());
		be.setUserId(computerPurchase.getUserId());

		be.setStartDate(computerPurchase.getStartDate());
		be.setEndDate(computerPurchase.getEndDate());
		be.setTotalCost(computerPurchase.getTotalCost());
		be.setMobileNo(computerPurchase.getMobileNo());
		be.setDiscount(computerPurchase.getDiscount());			
		return computerPurchase;
	}	
}



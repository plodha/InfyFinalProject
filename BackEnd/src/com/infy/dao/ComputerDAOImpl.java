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
			b.setComputerPrice(i.getComputerPrice());
			

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
			
			computer.setComputerId(ComputerId);
			computer.setComputerType(computerEntity.getComputerType());
			computer.setComputerPrice(computerEntity.getComputerPrice());
			
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
		be.setComputerId(computer.getcomputerId());
		be.setComputerPrice(computer.getComputerPrice());			
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

			
			computerEntity.setComputerPrice(computer.getComputerPrice());
			computerEntity.setComputerType(computer.getComputerType());
			computerEntity.setComputerId(computer.getcomputerId());
			
			

		}

		return computer;
	}

	
	}

	//*************  BOAT--BOOKING  **************************

	@Override
	public ComputerPurchase bookComputer(ComputerPurchase computerPurchase) throws Exception {

		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();


		ComputerPurchaseEntity be = new ComputerPurchaseEntity();

		be.setComputerId(computerPurchase.getComputerId());


		be.setPurchaseDate(computerPurchase.getPurchaseDate());
				
		return computerPurchase;
	}	
}



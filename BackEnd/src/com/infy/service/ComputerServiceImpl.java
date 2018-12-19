package com.infy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.infy.dao.ComputerDAO;
import com.infy.model.Computer;
import com.infy.model.ComputerPurchase;
import com.infy.model.User;

@Service
@Transactional(readOnly=true)
public class ComputerServiceImpl {
	@Autowired
	private ComputerDAO computerDAO;

	public List<Computer> getAllComputers() throws Exception {
		List<Computer> listOfComputers= computerDAO.getAllComputers();
		if(listOfComputers.size()<=0){
			throw new Exception("PCPicker.NO_PCS_AVAILABLE");
		}
		return listOfComputers;
	}

	
	
	
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Computer addComputer(Computer computer) throws Exception {
		Computer addedComputer=computerDAO.addComputer(computer);
		if(addedComputer==null){
			throw new Exception("PCPicker.PC_NOT_ADDED");
		}
		return addedComputer;
	}

	
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Computer updateComputer(Computer computer) throws Exception {
		Computer updatedComputer=computerDAO.updateComputer(computer);
		if(updatedComputer==null){
			throw new Exception("PCPicker.PC_NOT_UPDATED");
		}
		return updatedComputer;
	}

	public Computer getComputerById(String ComputerId) throws Exception {
		Computer computerDetail=computerDAO.getComputerById(ComputerId);
		if(computerDetail==null){
			throw new Exception("PCPicker.PC_DOES_NOT_EXIST");
		}
		return computerDetail;
	}
}

package com.infy.service;

@Service
@Transactional(readOnly=true)
public class ComputerServiceImpl {
	@Autowired
	private ComputerDAO computerDAO;

	@Override
	public List<Computer> getAllComputers() throws Exception {
		List<Computer> listOfComputers= computerDAO.getAllComputers();
		if(listOfComputers.size()<=0){
			throw new Exception("ComputerService.NO_COMPUTERS_AVAILABLE");
		}
		return listOfComputers;
	}

	
	
	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Computer addComputer(Computer computer) throws Exception {
		Computer addedComputer=computerDAO.addComputer(computer);
		if(addedComputer==null){
			throw new Exception("ComputerService.COMPUTER_NOT_ADDED");
		}
		return addedComputer;
	}

	
	@Override
	@Transactional(readOnly=false, propagation  = Propagation.REQUIRES_NEW)
	public Computer updateComputer(Computer computer) throws Exception {
		Computer updatedComputer=computerDAO.updateComputer(computer);
		if(updatedComputer==null){
			throw new Exception("ComputerService.COMPUTER_NOT_UPDATED");
		}
		return updatedComputer;
	}

	@Override
	public Computer getComputerById(String ComputerId) throws Exception {
		Computer ComputerDetail=computerDAO.getComputerById(computerId);
		if(computerDetail==null){
			throw new Exception("ComputerService.COMPUTER_DOES_NOT_EXIST");
		}
		return ComputerDetail;
	}
}

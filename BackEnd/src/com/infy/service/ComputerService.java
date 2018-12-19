package com.infy.service;

public interface ComputerService {
	 public List<Computer> getAllComputers() throws Exception;
	 public Computer addComputer(Computer Computer) throws Exception;
	 public Computer updateComputer(Computer Computer) throws Exception;
	 public Computer getComputerById(String ComputerId) throws Exception;
}

package com.infy.service;

import java.util.List;

import com.infy.model.Computer;

public interface ComputerService {
	 public List<Computer> getAllComputers() throws Exception;
	 public Computer addComputer(Computer computer) throws Exception;
	 public Computer updateComputer(Computer computer) throws Exception;
	 public Computer getComputerById(String computerId) throws Exception;
}

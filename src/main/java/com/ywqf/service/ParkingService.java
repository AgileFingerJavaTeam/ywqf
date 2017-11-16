package com.ywqf.service;


import com.ywqf.dto.excution.ParkingExcution;
import com.ywqf.dto.in.ParkingDto;

public interface ParkingService {
	
	
	public ParkingExcution getFirstParkList(ParkingDto parkingDto);

}

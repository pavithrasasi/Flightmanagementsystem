package org.flightmanagementsystem.airport.service;

import java.util.List;

import org.flightmanagementsystem.airport.exception.ResourceNotFoundException;
import org.flightmanagementsystem.airport.model.Airport;
import org.flightmanagementsystem.airport.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class AirportRepositoryImpl implements AirportService{
	//Dependency injection
	@Autowired
	private AirportRepository airportRepository;
	//construct injection--->used to store the values
	
	public AirportRepositoryImpl(@Lazy AirportRepository airportRepository) {
		super();
		this.airportRepository = airportRepository;
	}
	@Override
	public Airport saveAirport(Airport airport) {
		return airportRepository.save(airport);
	}
	@Override
	public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}
	@Override
	public Airport getAirportByAirportCode(long airportCode) {
		
		return airportRepository.findById(airportCode).orElseThrow(()->
		new ResourceNotFoundException("Airport","airportcode",airportCode));
	}
	@Override
	public Airport updateAirport(Airport airport, long airportCode) {
		
     Airport   existingAirport=airportRepository.findById(airportCode).orElseThrow(()->
     new ResourceNotFoundException("Airport","airportcode",airportCode));
     existingAirport.setAirportName(airport.getAirportName());
     existingAirport.setAirportLocation(airport.getAirportLocation());
     airportRepository.save(existingAirport);
     return existingAirport;
    }
	@Override
	
	public void deleteAirport(long airportCode) {
		airportRepository.findById(airportCode).orElseThrow(()->
		new ResourceNotFoundException("Airport","airportCode",airportCode));
	}
	

}

	
	
	



package org.flightmanagementsystem.airport.service;

import java.math.BigInteger;
import java.util.List;

import org.flightmanagementsystem.airport.model.Flight;

public interface FlightService {

	Flight addFlight(Flight flight);

	Flight modifyFlight(Flight flight, BigInteger id);

	Flight viewFlight(BigInteger flightNumber);

	List <Flight>viewAllFlight();

	Flight deleteFlight(BigInteger flightNumber);



}

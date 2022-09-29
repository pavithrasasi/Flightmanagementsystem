package org.flightmanagementsystem.airport.repository;

import org.flightmanagementsystem.airport.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
	

}

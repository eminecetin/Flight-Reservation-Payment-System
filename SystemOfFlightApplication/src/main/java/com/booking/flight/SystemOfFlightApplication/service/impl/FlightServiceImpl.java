package com.booking.flight.SystemOfFlightApplication.service.impl;

import com.booking.flight.SystemOfFlightApplication.dto.FlightDto;
import com.booking.flight.SystemOfFlightApplication.repository.FlightRepository;
import com.booking.flight.SystemOfFlightApplication.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;


    public FlightServiceImpl(FlightRepository flightRepository, ModelMapper modelMapper) {
        this.flightRepository = flightRepository;
        this.modelMapper = modelMapper;

    }

    @Override
    public Long createFlight(FlightDto flightDto) {
        return null;
    }

    @Override
    public List<FlightDto> getAllFlights() {
        return null;
    }


   /*  @Override
   public List<FlightDto> getAllFlights() {
        return flightRepository.findAll()
                .stream()
                .map(flightMapper::flightToFlightDto)
                .collect(Collectors.toList());
    }*/

    @Override
    public FlightDto getFlightDetails(Long flightId) {
        return null;
    }

    @Override
    public FlightDto getFlightById(Long id) throws Exception {
        return null;
    }

    @Override
    public String updateFlight(Long id, FlightDto flightDto) throws Exception {
        return null;
    }

    @Override
    public String deleteFlight(Long id) throws Exception {
        return null;
    }
}

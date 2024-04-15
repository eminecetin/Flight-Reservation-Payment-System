package com.booking.flight.SystemOfFlightApplication.service.impl;

import com.booking.flight.SystemOfFlightApplication.dto.AirportDto;
import com.booking.flight.SystemOfFlightApplication.entity.Airport;
import com.booking.flight.SystemOfFlightApplication.repository.AirportRepository;
import com.booking.flight.SystemOfFlightApplication.service.AirportService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;

    public AirportServiceImpl(AirportRepository airportRepository, ModelMapper modelMapper) {
        this.airportRepository = airportRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String createAirport(AirportDto airportDto) {
        Airport airport = modelMapper.map(airportDto, Airport.class);
        airportRepository.save(airport);
        return "Airport created successfully";
    }

    private Airport convertAirportDtoToEntity(AirportDto airportDto) {
        Airport airport = new Airport();
        airport.setId(airportDto.getId());
        airport.setName(airportDto.getName());
        airport.setCityName(airportDto.getCityName());
        airport.setCountryName(airportDto.getCountryName());
        return airport;
    }
    private AirportDto convertAirportEntityToDto(Airport airport) {
        AirportDto airportDto = new AirportDto();
        airportDto.setId(airport.getId());
        airportDto.setName(airport.getName());
        airportDto.setCityName(airport.getCityName());
        airportDto.setCountryName(airport.getCountryName());
        // Burada AirportDto'nun diğer alanları için de benzer atamalar yapılabilir.
        return airportDto;
    }


    @Override
    public List<AirportDto> getAllAirports() {
        return airportRepository.findAll()
                .stream()
                .map(airport -> modelMapper.map(airport, AirportDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AirportDto getAirportById(Long id) throws Exception {
        Airport airport = airportRepository.findById(id)
                .orElseThrow(() -> new Exception("Airport not found with ID: " + id));
        return modelMapper.map(airport, AirportDto.class);
    }

    @Override
    public String updateAirport(Long id, AirportDto airportDto) throws Exception {
        Airport existingAirport = airportRepository.findById(id)
                .orElseThrow(() -> new Exception("Airport not found with ID: " + id));

        modelMapper.map(airportDto, existingAirport);
        airportRepository.save(existingAirport);
        return "Airport updated successfully";
    }

    @Override
    public String deleteAirport(Long id) throws Exception {
        if (!airportRepository.existsById(id)) {
            throw new Exception("Airport not found with ID: " + id);
        }
        airportRepository.deleteById(id);
        return "Airport deleted successfully";
    }
}

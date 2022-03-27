package facades;

import daos.FlightsDAO;
import pojos.AirlineCompanies;
import pojos.Countries;
import pojos.Flights;
import pojos.Users;

import java.time.LocalDateTime;
import java.util.List;

public interface BasicFacade {

    List<Flights> getAllFlights();
    Flights getFlightsById(int id) throws Exception;
    List <Flights> getFlightsByParameters(int originCountryId, int destinationCountryId, LocalDateTime dateTime) throws Exception;
    List<AirlineCompanies> getAllAirlines();
    AirlineCompanies getAirlineById(int id) throws Exception;
   List<Countries> getAllCountries();
   Countries getCountryById(int id) throws Exception;
   void createNewUser(Users user);

}

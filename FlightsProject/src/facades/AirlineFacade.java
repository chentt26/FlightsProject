package facades;

import daos.AirlineCompaniesDAO;
import daos.FlightsDAO;
import pojos.AirlineCompanies;
import pojos.Flights;
import pojos.Token;

import java.time.LocalDateTime;
import java.util.List;

public class AirlineFacade extends AnonymousFacade {
    AirlineCompaniesDAO airlineDAO = new AirlineCompaniesDAO();
    FlightsDAO flightsDAO = new FlightsDAO();
    Token token;
    //updating airline, validates ids
    public void updateAirline(AirlineCompanies airline) throws Exception {
        if (airline.id <= 0 || airline.countryId <= 0 || airline.userId <= 0)
            throw new Exception("you cant add negative value to one of the ids");
if (token.getId()!=airline.id)
    throw new Exception("you can only update this airline,youre trying to update other one. please try again");

        airlineDAO.update(airline);

    }
    //adding flights, validates ids

    public void addFlight(Flights flights) throws Exception {
        if (flights.remainingTickets < 0)
            throw new Exception("you cant add number of tickets that is smaller than 0");
        if (flights.landingTime.isBefore(LocalDateTime.now()))
            throw new Exception("you cant add a flight to past date");
        if (flights.departureTime.isBefore(LocalDateTime.now()))
            throw new Exception("you cant add a flight to past date");
        if (flights.departureTime.isBefore(flights.landingTime))
            throw new Exception("you cant add a flight with that lands before it departures");
        if ( flights.originCountryId <= 0 || flights.destinationCountryId <= 0 || flights.airLineCompanyId <= 0)
            throw new Exception("you cant add negative value to one of the ids");
        if (token.getId()!=flights.airLineCompanyId)
            throw new Exception("you can only add flights to your  airline,youre trying to add to other one. please try again");

        flightsDAO.add(flights);
    }
    //update flight,validate ids
    public void updateFLight(Flights flights) throws Exception {
        if (flights.remainingTickets < 0)
            throw new Exception("you cant add number of tickets that is smaller than 0");
        if (flights.landingTime.isBefore(LocalDateTime.now()))
            throw new Exception("you cant add a flight to past date");
        if (flights.departureTime.isBefore(LocalDateTime.now()))
            throw new Exception("you cant add a flight to past date");
        if (flights.departureTime.isBefore(flights.landingTime))
            throw new Exception("you cant add a flight with that lands before it departures");
        if (flights.id <= 0 || flights.originCountryId <= 0 || flights.destinationCountryId <= 0 || flights.airLineCompanyId <= 0)
            throw new Exception("you cant add negative value to one of the ids");
        if (token.getId()!=flights.airLineCompanyId)
            throw new Exception("you can only update flights that belongs to your  airline,youre trying to update to other one. please try again");

        flightsDAO.update(flights);
    }
//remove flights,validates ids
    public void removeFlight(Flights flights) throws Exception {
        if (token.getId()!=flights.airLineCompanyId)
            throw new Exception("you can only delete flights that belongs to your airline,youre trying to delete to other one. please try again");

        flightsDAO.remove(flights);
    }
///returns all flights that belongs to your airline
    public List<Flights> getMyFlights() {
return flightsDAO.getFlightsByAirlineId(token.getId());

    }

    public AirlineFacade(Token token) {
        this.token = token;
    }
}

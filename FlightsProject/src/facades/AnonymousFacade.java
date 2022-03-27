package facades;

import daos.*;
import pojos.*;

import java.time.LocalDateTime;
import java.util.List;

public class AnonymousFacade implements BasicFacade {
    FlightsDAO flightsDAO = new FlightsDAO();
    AirlineCompaniesDAO airlineDAO = new AirlineCompaniesDAO();
    CountriesDAO countriesDAO = new CountriesDAO();
    CustomersDAO customersDAO=new CustomersDAO();
    AdminstratorsDAO adminstratorsDAO=new AdminstratorsDAO();
    UsersDAO usersDAO=new UsersDAO();
int id;

///returns all flights
@Override
    public List<Flights> getAllFlights() {
        return flightsDAO.getAll();
    }

    ///returns flight by id
    @Override
    public Flights getFlightsById(int id) throws Exception {
        if (id <= 0)
            throw new Exception("you cant add negative value to one of the ids");

        return flightsDAO.get(id);
    }

    @Override
    public List<Flights> getFlightsByParameters(int originCountryId, int destinationCountryId, LocalDateTime dateTime) throws Exception {
        if (originCountryId <= 0 || destinationCountryId <= 0)
            throw new Exception("you cant add negative value to one of the ids");

        return flightsDAO.getFlightsByParameters(originCountryId, destinationCountryId, dateTime);
    }
    ///returns all airlines
    @Override
    public List<AirlineCompanies> getAllAirlines() {
        return airlineDAO.getAll();
    }
///returns airline by id
    @Override
    public AirlineCompanies getAirlineById(int id) throws Exception {
        if (id <= 0)
            throw new Exception("you cant add negative value to one of the ids");
        return airlineDAO.get(id);
    }
///returns all countries
    @Override
    public List<Countries> getAllCountries() {
        return countriesDAO.getAll();
    }
///return country by id
    @Override
    public Countries getCountryById(int id) throws Exception {
        if (id <= 0)
            throw new Exception("you cant add negative value to one of the ids");
        return countriesDAO.get(id);
    }
///creates new user in the db
    @Override
    public void createNewUser(Users user) {
usersDAO.add(user);
    }


    public BasicFacade login(String userName, String password) {
        String role;
        Token token;
        UsersDAO usersDAO = new UsersDAO();
        Users user = usersDAO.getUserByUsername(userName);
        if (user.password.equalsIgnoreCase(password)) {
            if (user.userRole == 1)
                role = "administrator";
            if (user.userRole == 2)
                role = "airline company";
            else
                role = "customer";
            if (user.userRole == 1) {
             id=adminstratorsDAO.getAdminByUsername(userName).id;
                token = new Token(id, user.userName, role);
                return new AdministratorFacade(token);
            }
            if (user.userRole == 2) {
                id=airlineDAO.getAirlineByUserName(userName).id;
            token = new Token(id, user.userName, role);

            return new AirlineFacade(token);}
            else{
                id=customersDAO.getCustomerByUsername(userName).id;
                token = new Token(id, user.userName, role);

            return new CustomerFacade(token);}
        } else return null;


    }
}

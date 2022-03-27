package facades;

import daos.AdminstratorsDAO;
import daos.AirlineCompaniesDAO;
import daos.CustomersDAO;
import pojos.Adminstrators;
import pojos.AirlineCompanies;
import pojos.Customers;
import pojos.Token;


import java.util.List;

public class AdministratorFacade extends  AnonymousFacade{
    CustomersDAO customersDAO=new CustomersDAO();
    AirlineCompaniesDAO airlineDAO=new AirlineCompaniesDAO();
    AdminstratorsDAO adminstratorsDAO=new AdminstratorsDAO();

  Token token;

//returns all customers
    public List<Customers> getAllCustomers(){
        return customersDAO.getAll();
    }
    ///adding airline
    public void addAirline(AirlineCompanies airline) throws Exception {
        if(airline.countryId<=0||airline.userId<=0)
            throw new Exception("you cant add negative value to one of the ids");
        airlineDAO.add(airline);
    }
    ///adding customer
    public void addCustomer(Customers customer) throws Exception {
       if(customer.userId<=0)
           throw new Exception("you cant add negative value to one of the ids");

        customersDAO.add(customer);

    }
    ///adding admin
    public void addAdministrator(Adminstrators adminstrator) throws Exception {
      if (adminstrator.userId<=0)
          throw new Exception("you cant add negative value to one of the ids");

        adminstratorsDAO.add(adminstrator);
    }
    ///removing airline
    public void removeAirline(AirlineCompanies airline){
        airlineDAO.remove(airline);
    }
    ///removing customer

    public void removeCustomer(Customers customers){
        customersDAO.remove(customers);
    }
    ///removing customer

    public void removeAdministrator(Adminstrators adminstrator){
        adminstratorsDAO.remove(adminstrator);
    }

    public AdministratorFacade(Token token) {
        this.token = token;
    }
}

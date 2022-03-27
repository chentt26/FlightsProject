package facades;

import daos.CustomersDAO;
import daos.TicketsDAO;
import pojos.Customers;
import pojos.Tickets;
import pojos.Token;

import java.util.List;

public class CustomerFacade extends AnonymousFacade{
    CustomersDAO customersDAO=new CustomersDAO();
    TicketsDAO ticketsDAO=new TicketsDAO();
     Token token;


///update customer,validates ids
    public void updateCustomer(Customers customer) throws Exception {
        if(customer.userId<=0)
            throw new Exception("you cant add negative value to one of the ids");
        if (customer.id!=token.getId())
            throw new Exception("you cant update other customer");

        customersDAO.update(customer);
    }
    ///adding ticket,validate ids
    public void addTicket(Tickets ticket) throws Exception {
      if (ticket.id<=0||ticket.flightId<=0)
          throw new Exception("you cant add negative value to one of the ids");
if (ticket.customerId!=token.getId())
    throw new Exception("you cant purchase ticket for another customer");

        ticketsDAO.add(ticket);
    }
    ///removing ticket,validate ids

    public void removeTicket(Tickets ticket) throws Exception {
        if (ticket.customerId!=token.getId())
            throw new Exception("you cant remove ticket for another customer");

        ticketsDAO.remove(ticket);
    }
    ///returns this customer tickets
    public List<Tickets> getMyTickets(){
return ticketsDAO.getTicketsByCustomer(token.getId());
    }

    public CustomerFacade(Token token) {
        this.token = token;
    }
}

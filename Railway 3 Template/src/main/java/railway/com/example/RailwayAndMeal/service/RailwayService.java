package railway.com.example.RailwayAndMeal.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.exceptions.TicketAlreadyExistsException;
import railway.com.example.RailwayAndMeal.exceptions.TicketNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RailwayService {

    public List<Ticket> list = new ArrayList<>();
    public Map<Long, Ticket> ticketMap = new HashMap<>();

    public Ticket getTicketByPnr(long pnr) {
        /**
         1. Implement the logic to first check whether the ticket with given
         pnr exist or not.

         2. If no ticket is found by the given pnr number then throw TicketNotFoundException with
         custom message.

         3. If ticket is found then we simply return it.
         **/
        Ticket ticket = ticketMap.get(pnr);
        if (ObjectUtils.isEmpty(ticket)) {
            throw new TicketNotFoundException("Ticket with PNR " + pnr + " not found.");
        }
        return ticketMap.get(pnr);
    }

    public void addTicket(Ticket ticket) {
        /**
         1. Before adding the ticket, now you need to check whether the given ticket with the same pnr
         number exists or not.

         2. If a ticket with same pnr is found then we throw TicketAlreadyExistsException with custom message.

         3. If no ticket is found then we simply add it.
         **/
        if (ticketMap.containsKey(ticket.getPnr())) {
            throw new TicketAlreadyExistsException("Already Found");
        }


        list.add(ticket);
        ticketMap.put(ticket.getPnr(), ticket);
    }

    public List<Ticket> getAllTickets() {
        return list;
    }

    public void deleteTicketByPnr(long pnr) {
        Ticket ticket = this.getTicketByPnr(pnr);

        list.remove(ticket);
        ticketMap.remove(ticket.getPnr());
    }

    public void updateTicket(Ticket ticket) {
        Ticket existing_ticket = this.getTicketByPnr(ticket.getPnr());

        list.remove(existing_ticket);
        ticketMap.remove(existing_ticket.getPnr());

        list.add(ticket);
        ticketMap.put(ticket.getPnr(), ticket);
    }
}
package railway.com.example.RailwayAndMeal.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import railway.com.example.RailwayAndMeal.Entity.Ticket;
import railway.com.example.RailwayAndMeal.exceptions.TicketBodyInvalidException;
import railway.com.example.RailwayAndMeal.service.RailwayService;

import java.util.List;

@RestController
@RequestMapping("/railway")
public class Controller {

    @Autowired
    private RailwayService railwayService;

    // POST method for adding a ticket with validation
    @PostMapping("/ticket")
    public void addTicket(@Valid @RequestBody Ticket ticket, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new TicketBodyInvalidException("Ticket details are invalid.");
        }
        railwayService.addTicket(ticket);
    }

    // GET method to retrieve all tickets
    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return railwayService.getAllTickets();
    }

    // GET method to retrieve a ticket by PNR
    @GetMapping("/ticket/{pnr}")
    public Ticket getTicketByPnr(@PathVariable long pnr) {
        return railwayService.getTicketByPnr(pnr);
    }

    // DELETE method to delete a ticket by PNR
    @DeleteMapping("/ticket/{pnr}")
    public void deleteTicket(@PathVariable long pnr) {
        railwayService.deleteTicketByPnr(pnr);
    }

    // PUT method for updating a ticket with validation
    @PutMapping("/ticket")
    public void updateTicket(@Valid @RequestBody Ticket ticket, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new TicketBodyInvalidException("Ticket details are invalid.");
        }
        railwayService.updateTicket(ticket);
    }
}

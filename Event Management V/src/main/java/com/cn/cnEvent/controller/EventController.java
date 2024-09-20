 package com.cn.cnEvent.controller;

 import com.cn.cnEvent.entity.Event;
 import com.cn.cnEvent.entity.EventScheduleDetail;
 import com.cn.cnEvent.service.EventService;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.*;
 import com.cn.cnEvent.entity.Ticket;
 import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	EventService eventService;

	@GetMapping("/{id}")
	public Event getEventById(@PathVariable Long id)
	{
		Event event=eventService.getEventById(id);
		return event;
	}

	@GetMapping("/all")
	public List<Event> getAllEvents()
	{
		return eventService.getAllEvents();
	}

	@GetMapping("/location/{location}")
	public List<Event> getAllEventsByLocation(@PathVariable String location)
	{
		return eventService.getAllEventsByLocation(location);
	}

	@GetMapping("/eventScheduleDetail/{id}")
	public EventScheduleDetail getEventScheduleDetailByEventId(@PathVariable Long id)
	{
		return eventService.getEventScheduleDetailByEventId(id);
	}
	@GetMapping("/allTickets/{id}")
	public List<Ticket> getAllTicketsOfEvent(@PathVariable Long id)
	{
		return eventService.getAllTicketsOfEvent(id);
	}

	@GetMapping("/tickets/PriceGreaterThan/{price}")
	public List<Event> getAllEventsHavingTicketPriceGreaterThan(@PathVariable Long price)
	{
		return eventService.getAllEventsHavingTicketPriceGreaterThan(price);
	}

	@PostMapping("/save")
	public String saveEvent(@RequestBody Event event) {
		return eventService.saveEvent(event);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEvent(@PathVariable Long id)
	{
		return eventService.delete(id);
	}

	@DeleteMapping("/delete/eventScheduleDetail/{id}")
	public String deleteEventScheduleDetail(@PathVariable Long id)
	{
		return eventService.deleteEventScheduleDetail(id);
	}

	@PutMapping("/update")
	public String updateEvent(@RequestBody Event updateEvent)
	{
		return eventService.update(updateEvent);
	}

}

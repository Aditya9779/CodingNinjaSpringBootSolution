package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Ticket;
import com.cn.cnEvent.exception.NotFoundException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TicketDALImpl implements TicketDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Ticket getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Ticket ticket = session.get(Ticket.class, id);
		return ticket;
	}

	@Override
	public List<Ticket> getAllTickets() {
		Session session = entityManager.unwrap(Session.class);
		List<Ticket> allTickets= session.createQuery(
				"SELECT t FROM Ticket t", Ticket.class).getResultList();
		return allTickets;
	}

	@Override
	public List<Ticket> getAllTicketsByAge(Long age){
		List<Ticket> allTickets=getAllTickets();
		List<Ticket> allTicketsByAge= new ArrayList<>();
		try {
			for (Ticket ticket : allTickets) {
				if (ticket.getPerson().getAge() < age) {
					allTicketsByAge.add(ticket);
				}
			}
		}
		catch (Exception e)
		{
			throw new NotFoundException("Person details of a ticket not found.");
		}
		return allTicketsByAge;
	}
}

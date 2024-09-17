package com.cn.cnEvent.dal;

import com.cn.cnEvent.entity.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PersonDALImpl implements PersonDAL {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public Person getById(Long id) {
		Session session = entityManager.unwrap(Session.class);
		Person person = session.get(Person.class, id);
		return person;
	}

	@Override
	public List<Person> getAllPersons() {
		Session session = entityManager.unwrap(Session.class);
		List<Person> allPersons= session.createQuery(
				"SELECT e FROM Person e", Person.class).getResultList();
		return allPersons;
	}
}

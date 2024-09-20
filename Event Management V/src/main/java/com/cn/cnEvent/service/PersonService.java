package com.cn.cnEvent.service;

import com.cn.cnEvent.dal.PersonDAL;
import com.cn.cnEvent.entity.Person;
import com.cn.cnEvent.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService {

	@Autowired
	PersonDAL personDAL;

	@Transactional
	public Person getPersonById(Long id) {
		Person person=personDAL.getById(id);
		if(person==null)
		{
			throw new NotFoundException("No person found with id:  "+id);
		}
		return person;
	}

	@Transactional
	public List<Person> getAllPersons() {
		List<Person> person = personDAL.getAllPersons();
		if(person==null)
		{
			throw new NotFoundException("No persons found.");
		}
		return person;
	}

}

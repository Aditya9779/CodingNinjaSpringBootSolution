package com.codingninjas.EVotingSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingninjas.EVotingSystem.entities.Election;
import com.codingninjas.EVotingSystem.entities.ElectionChoice;
import com.codingninjas.EVotingSystem.entities.User;
import com.codingninjas.EVotingSystem.entities.Vote;
import com.codingninjas.EVotingSystem.repositories.ElectionChoiceRepository;
import com.codingninjas.EVotingSystem.repositories.ElectionRepository;
import com.codingninjas.EVotingSystem.repositories.UserRepository;
import com.codingninjas.EVotingSystem.repositories.VoteRepository;

@Service
public class VotingService {
	
	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ElectionRepository electionRepository;
	
	@Autowired
	ElectionChoiceRepository electionChoiceRepository;
	
	public List<Vote> getAllVotes() {
		return voteRepository.findAll();
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public void addVote(Vote vote) {
		voteRepository.save(vote);
	}

	public void addElection(Election election) {
		electionRepository.save(election);
	}

	public List<Election> getAllElections() {
		return electionRepository.findAll();
	}

	public void addElectionChoice(ElectionChoice electionChoice) {
		electionChoiceRepository.save(electionChoice);		
	}

	public List<ElectionChoice> getAllElectionChoices() {
		return electionChoiceRepository.findAll();
	}

	public Election findElectionByName(String electionName) {
		return electionRepository.findByName(electionName).orElseThrow();
	}

	public User findUserByName(String userName) {
		return userRepository.findByName(userName).orElseThrow();
	}

	public ElectionChoice findElectionChoiceByNameAndElection(String electionChoiceName,Election election) {
		return electionChoiceRepository.findByNameAndElection(electionChoiceName,election).orElseThrow();
	}

	public long countTotalVotes() {
		return voteRepository.countTotalVotes();
	}

	public long getTotalNumberOfChoicesByElection(Election election) {
		return electionChoiceRepository.countByElection(election);
	}
	
	public long countVotesByElection(Election election) {
		return voteRepository.countVotesByElection(election);
	}
	
	public ElectionChoice findElectionChoiceWithMaxVotes(Election election) {
		return electionChoiceRepository.findElectionChoiceWithMaxVotes(election.getId());
	}

}

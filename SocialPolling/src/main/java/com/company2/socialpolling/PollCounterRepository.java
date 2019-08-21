package com.company2.socialpolling;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository

public interface PollCounterRepository extends CrudRepository<PollCounter, Integer>{
   
	@Query("SELECT p.counter FROM PollCounter p where p.pollId = ?1 and p.optionValue =?2") 
    int findCounterById(int pollId,int optionValue);
	
	//@Query("select * from PollCounter") 
	//List<PollCounter> fetchAll();
	@Query("SELECT p FROM PollCounter p where p.pollId = ?1") 
    List<PollCounter> findCount(int pollId);
	
	@Modifying
	@Transactional
	@Query("update PollCounter set counter=counter+1 where pollId = ?1 and optionValue =?2") 
    void incrementCounterById(int pollId,int optionValue);
	
	@Modifying
	@Transactional
	@Query("update PollCounter set counter=counter-1 where pollId = ?1 and optionValue =?2") 
    void decrementCounterById(int pollId,int optionValue);
	
	@Modifying
	@Transactional
	@Query(value="insert into PollCounter (pollId,optionValue,counter)  values(:pollId,:optionValue,:init)",nativeQuery = true) 
    void initCounterById(int pollId,int optionValue,int init);
	
	
}

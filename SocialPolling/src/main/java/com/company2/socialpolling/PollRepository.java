package com.company2.socialpolling;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollRepository extends CrudRepository<Poll, Integer>{
	
	List<Poll> findByCreatedById(int createdById);
	
	
	@Query("select p from Poll p where p.id = ?1 AND p.active= 1")
	Poll findByIdAndActive(int pollId);
}

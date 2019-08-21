package com.company2.socialpolling;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PollOptionRepository extends CrudRepository<PollOptions, Integer>{
	
	//@Query("select p.optionDesc, p.optionValue FROM PollOptions p where p.poll.pollId = :pollId")
	@Query("select p FROM PollOptions p where p.poll.pollId = :pollId")
    List<PollOptions> findByPollId(int pollId);
	
	@Transactional
	@Modifying
	@Query("delete from PollOptions p where p.poll.pollId = :pollId")
	void deleteByPollId(int pollId);
}

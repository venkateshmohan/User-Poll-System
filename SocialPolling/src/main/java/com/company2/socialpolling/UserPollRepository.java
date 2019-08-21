package com.company2.socialpolling;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPollRepository extends CrudRepository<UserPoll, Integer>{
   List<UserPoll> findByUserId(Integer userId);
}

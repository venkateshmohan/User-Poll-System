package com.company2.socialpolling;

import java.util.List;


import javax.transaction.Transactional;


import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("select u.userName,u.password from User u where u.userName =:username and u.password =:password")
    List<User> findByEmailandPassword(String username,  String password);
	
	//@Query("select u.userName from User u where u.userName =:username")
	List<User> findByUserName(String username);
	
	@Query("select u.phone_number from User u where u.phone_number =:phone_number")
	List<User> findByPhoneNumber(String phone_number);

	@Query("select u.active from User u where u.userName=?1 and u.email =?2")
	boolean findEmail(String userName,String email);
	

	@Transactional
	List<User> deleteByUserName(String userName);
//	@Query ("update User set column password=TemPass where userName=:username and temPWD=:testPass")
//	boolean updatePass(String username,String testPass);
	

	@Query("select u.tempPWD from User u where u.userName=?1")
	String findTempPWD(String userName);
	
	@Modifying
	@Transactional
	@Query("update User set active=1 where userName = ?1") 
    void updateActiveStatus(String userName);
	
	@Modifying
	@Transactional
	@Query("update User set tempPWD=?1 where userName = ?2") 
    void updateTempPWD(String tempPWD,String userName);


}

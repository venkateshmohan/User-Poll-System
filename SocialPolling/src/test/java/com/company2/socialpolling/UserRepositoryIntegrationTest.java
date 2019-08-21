package com.company2.socialpolling;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@DataJpaTest
public class UserRepositoryIntegrationTest {
	
//	User test;
//	@Autowired
//    private TestEntityManager entityManager;
// 
//    @Autowired
//    private UserRepository userRepository;
//    
//    @Before
//    public void initialize() {
//    	test = new User();
//        test.setUserName("test_user");
//        test.setPassword("test_password");
//        test.setActive(true);
//        test.setCity("test_city");
//        test.setEmail("test_email");
//        test.setFullname("test_fullname");
//        test.setPhone_number("1234567");
//        entityManager.persist(test);
//        entityManager.flush();
//    }
//    
//    @After
//    public void tearDown() {
//    	entityManager.remove(test);
//    	test = null;
//    }
//    @Test
//    public void whenFindByUserName_thenReturnUser() {
//        // given
//        // when
//        List<User> found = userRepository.findByUserName(test.getUserName());
//        // then        
//        assertEquals(found.get(0), test.getUserName());
//    }
//    
//    @Test
//    public void whenFindByEmailAndPassword_thenReturnUser() {
//        // when
//        List<User> found = userRepository.findByEmailandPassword(test.getUserName(), test.getPassword());
//        // then 
//        assertEquals(found.size(), 1);
//    }
//    
//    @Test
//    
//    public void whenAddDuplicateUser_thenReturnError() {
//    	
//    }

}

package com.company2.socialpolling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//@RunWith(SpringRunner.class)
//@WebMvcTest(UserController.class)
//@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
//@WebAppConfiguration
public class UserControllerTest {

//	 @Autowired
//	 private MockMvc mockMvc;
//	 
//	 @Autowired
//	 private WebApplicationContext webAppContext;
	 

  //  private UserController userController;
    
//    @Before
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
//    }
    
//    @Test
//    public void contextLoads() throws Exception {
//        assertThat(userController).isNotNull();
//    }
    
//    @Test
//    public void greetingShouldReturnMessageFromService() throws Exception {
//        this.mockMvc.perform(get("/user/login")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("failed")));
//    }
//    
}

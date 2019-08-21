package com.company2.socialpolling;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SocialPollingApplicationTests {

    @Autowired
    private PollController pollController;
    

    @Test
    public void contextLoads() throws Exception {
        assertThat(pollController).isNotNull();
    }
    
    
}

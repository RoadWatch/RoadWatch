package com.codeup.demo.unitTests;

import com.codeup.demo.Repos.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserUnitTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    Users userDao;

//    @Test
//    public void contextLoads() throws Exception{
//        mockMvc.perform(
//                MockMvcRequestBuilders.get("/")
//        )
//    }
}

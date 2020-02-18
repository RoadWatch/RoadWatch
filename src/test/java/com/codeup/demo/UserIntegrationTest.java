package com.codeup.demo;

import com.codeup.demo.Repos.Reports;
import com.codeup.demo.Repos.Users;
import com.codeup.demo.models.User;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RoadWatchApplication.class)
@AutoConfigureMockMvc
public class UserIntegrationTest {

    private User testUser;
    private HttpSession httpSession;

    @Autowired
    private MockMvc mvc;

    @Autowired
    Users userDao;

    @Autowired
    Reports reportsDao;

    @Before
    public void setup() throws Exception {
        testUser = userDao.findByUsername("testUser");
    }

}

package com.codeup.demo;


import com.codeup.demo.Repos.Reports;
import com.codeup.demo.Repos.Users;
import com.codeup.demo.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import javax.servlet.http.HttpSession;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    private User user;

    @Before
    public void setup() throws Exception {
        testUser = userDao.findByUsername("testUser");

        // create the test to see if user exists
        if(testUser == null){
            User newUser = new User();
            newUser.setUsername("testUser");
            newUser.setPassword(passwordEncoder.encode("pass"));
            newUser.setEmail("testUser@bexar.com");
            newUser.setFirstName("Jane");
            newUser.setLastName("Doe");
            testUser = userDao.save(newUser);
        }

        httpSession = this.mvc.perform(post("/").with(csrf())
                .param("username", "testUser")
                .param("password", "pass"))
                .andExpect(status().is(HttpStatus.FOUND.value()))
                .andExpect(redirectedUrl("/map"))
                .andReturn()
                .getRequest()
                .getSession();

        this.user = testUser;
    }

    //! SANITY TEST
    @Test
    public void contextLoads(){
        assertNotNull(mvc);
    }

    //! TEST FOR ACTIVE USER
    @Test
    public void testIfUserSessionIsActive() throws Exception {
        assertNotNull(httpSession);
    }

    //! TEST EDIT USER
//    @Test
//    public void editUser() throws Exception {
//        long id = user.getId();
//        System.out.println("ID: "+id);
//        this.mvc.perform(
//                post("/user/"+id+"/edit").with(csrf())
//                    .param("id", ""+id)
//                    .param("username", "Codeup")
//                    .param("email", "jane")
//                    .param("firstName", "Amber")
//                    .param("lastName", "Jones")
//        ) .andExpect(status().is3xxRedirection());
//
//        User updatedUser = userDao.findByUsername("Amber");
//        Assert.assertNotNull(updatedUser);
//        Assert.assertEquals("Amber", "Amber");
//
//
//    }





}

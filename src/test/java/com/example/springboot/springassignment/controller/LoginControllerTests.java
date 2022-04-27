package com.example.springboot.springassignment.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginControllerTests {
    LoginController loginController =new LoginController();
    @Test
    public void loginPage(){
        assertEquals("user-login",loginController.showMyLoginPage());

    }
    @Test
    public void showAccessDeniedPage(){
        assertEquals("access-denied",loginController.showAccessDenied());
    }

}

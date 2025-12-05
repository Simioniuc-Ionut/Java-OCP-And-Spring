package org.example.ex1.ch15.unitTests;

import org.example.sq.part2.ch9.CounterService;
import org.example.sq.part2.ch9.LoginController;
import org.example.sq.part2.ch9.LoginProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class LoginControllerUnitTests {

    @Mock
    private Model model;

    @Mock
    private LoginProcessor loginProcessor;

    @Mock
    private CounterService counterService;

    @InjectMocks
    private LoginController loginController;

    @Test
    public void loginPostLoginSucceedsTests() {
        given(loginProcessor.login())
                .willReturn(true);

        String result =
                loginController.loginPost("username","password", model);

        assertEquals("redirect:/home", result);

        verify(model)
                .addAttribute("message","You are now logged in.");
    }

    @Test
    public void loginPostLoginFailsTest() {
        given(loginProcessor.login())
                .willReturn(false);

        String result =
                loginController.loginPost("username", "password", model);

        assertEquals("login_ch9", result);

        verify(model)
                .addAttribute("message", "Login failed!");
    }
}

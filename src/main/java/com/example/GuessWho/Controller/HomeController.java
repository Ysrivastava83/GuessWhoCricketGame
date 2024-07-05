package com.example.GuessWho.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController
{
    @RequestMapping("/home")
    public String homepage()
    {
        System.out.println("In home controller");
        return "Home";
    }
}

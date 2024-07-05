package com.example.GuessWho.Controller;

import com.example.GuessWho.Model.Players;
import com.example.GuessWho.Service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/Players")
public class PlayersController
{
    @Autowired
    PlayersService playersService;
    @GetMapping("/all")
    @ResponseBody
    public List<Players> allPlayers()
    {
            System.out.println("In PlayerController");
           return playersService.allPlayers();
    }
}

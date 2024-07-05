package com.example.GuessWho.Service;

import com.example.GuessWho.DAO.PlayersDAO;
import com.example.GuessWho.Model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlayersService
{
    @Autowired
    PlayersDAO playersDAO;

    public List<Players> allPlayers()
    {
        System.out.println("In PlayerService");
        return playersDAO.findAll();
    }
}

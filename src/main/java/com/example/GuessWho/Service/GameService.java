package com.example.GuessWho.Service;

import com.example.GuessWho.DAO.GameDAO;
import com.example.GuessWho.Model.Players;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    @Autowired
    GameDAO gameDAO;
    List<Integer> list = new ArrayList<>();
    int n;
    int max = 15;
    int min = 1;

    public List<Players> playGame()
    {
        while (list.size() < 15) {
            int n = (int) (Math.random() * (max - min + 1) + min);

            if (list.contains(n))
            {
                continue;
            }
            list.add(n);
        }
        return gameDAO.findAllById(list);
    }

    public List<Players> allplayers() {
        return gameDAO.findAll();
    }

    public boolean byCountry(String option, Players pl1, Players pl2) {
        System.out.println(option + " " + pl1.getPlayer_nation());
        if (option.equals(pl1.getPlayer_nation()))
            return true;
        else
            return false;
    }

    public boolean byNature(String option, Players pl1, Players pl2) {
        System.out.println(option + " " + pl1.getPlayer_nature());
        if (option.equals(pl1.getPlayer_nature()))
            return true;
        else
            return false;
    }

    public boolean byStyle(String option, Players pl1, Players pl2) {
        System.out.println(option + " " + pl1.getPlayer_style());
        if (option.equals(pl1.getPlayer_style()))
            return true;
        else
            return false;
    }


    public boolean byHair(String option, Players pl1, Players pl2) {
        System.out.println(option + " " + pl1.getPlayer_hair());
        if (option.equals(pl1.getPlayer_hair()))
            return true;
        else
            return false;
    }


    public boolean byAge(String option, Players pl1, Players pl2) {
        System.out.println(option + " " + pl1.getPlayer_age());

        if (option.equals(("below 35"))) {
            if (pl1.getPlayer_age() < 35)
                return true;
            else
                return false;
        }
        if (option.equals(("35-40"))) {
            if (pl1.getPlayer_age() >= 35 && pl1.getPlayer_age() <= 40)
                return true;
            else
                return false;
        }
        if (option.equals(("above 40"))) {
            if (pl1.getPlayer_age() > 40)
                return true;
            else
                return false;
        }
        return false;
    }
}


package com.example.GuessWho.Service;

import com.example.GuessWho.Model.Players;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class ComputerService
{
  private  List<Players> temp;
    public  List<Players> randomSelect(List<Players> listp1, Players pl1, Players pl2)
    {
        temp=listp1;
        Random random = new Random();
        Players randomplayer=listp1.get(random.nextInt(listp1.size()));
        int randomnumber= random.nextInt(5);

        System.out.println(randomplayer);
        System.out.println(randomnumber);

        if(randomnumber==0)
        {
           if(randomplayer.getPlayer_nation().equals(pl2.getPlayer_nation()))
           {
               listp1 = temp.stream()
                       .filter(player -> player.getPlayer_nation().equals(randomplayer.getPlayer_nation()))
                       .collect(Collectors.toList());
               return listp1;
           }

        }

        if(randomnumber==1)
        {
            if(randomplayer.getPlayer_nature().equals(pl2.getPlayer_nature()))
            {
                listp1 = temp.stream()
                        .filter(player -> player.getPlayer_nature().equals(randomplayer.getPlayer_nature()))
                        .collect(Collectors.toList());
                return listp1;
            }
        }
        if(randomnumber==2)
        {
            if(randomplayer.getPlayer_style().equals(pl2.getPlayer_style()))
            {
                listp1 = temp.stream()
                        .filter(player -> player.getPlayer_style().equals(randomplayer.getPlayer_style()))
                        .collect(Collectors.toList());
                return listp1;
            }
        }
        if(randomnumber==3)
        {
            if(randomplayer.getPlayer_hair().equals(pl2.getPlayer_hair()))
            {
                listp1 = temp.stream()
                        .filter(player -> player.getPlayer_hair().equals(randomplayer.getPlayer_hair()))
                        .collect(Collectors.toList());
                return listp1;
            }
        }
        if(randomnumber==4)
        {
            if(randomplayer.getPlayer_age()<35 && pl1.getPlayer_age()<35)
            {
                listp1 = temp.stream()
                        .filter(player -> player.getPlayer_age()<35)
                        .collect(Collectors.toList());
                return listp1;
            }
            if((randomplayer.getPlayer_age()>=35 && randomplayer.getPlayer_age()<=40) && (pl1.getPlayer_age()>=35 && pl1.getPlayer_age()<=40))
            {
                listp1 = temp.stream()
                        .filter(player -> player.getPlayer_age()>35)
                        .collect(Collectors.toList());
                return listp1;
            }
            if(randomplayer.getPlayer_age()>40 && pl1.getPlayer_age()>40)
            {
                listp1 = temp.stream()
                        .filter(player -> player.getPlayer_age()>40)
                        .collect(Collectors.toList());
                return listp1;
            }
        }
        return listp1;
    }
}

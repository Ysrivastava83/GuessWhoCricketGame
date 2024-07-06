package com.example.GuessWho.Controller;

import com.example.GuessWho.Model.Players;
import com.example.GuessWho.Service.ComputerService;
import com.example.GuessWho.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/game")
public class GameController
{

    @Autowired
    GameService gameService;
    @Autowired
    ComputerService computerService;
    private List<Players> list;
    private List<Players> listp1;
    private List<Players> listp2;
    private List<Players> temp;
    private Players pl1;
    private Players pl2;
    private Players a;

    @RequestMapping("/")
    public String  playGame(Model model)
    {
        list =gameService.playGame();
        listp1=list;
        listp2=list;
        model.addAttribute("Selected",list);
        return "StartGame";
    }
    @RequestMapping("/gameon")
    public String gameOn(Model m,@RequestParam Players selectedplayer)
    {
        if (list == null || list.isEmpty())
        {
            // Handle the case where the list is not initialized or is empty
            return "redirect:/game/";
        }

        m.addAttribute("P1",listp1);
        m.addAttribute("P2",listp2);

        Random random = new Random();
        pl1 = list.get(random.nextInt(list.size()));
        pl2=selectedplayer;
        System.out.println(pl1);
        System.out.println(pl2);
       // m.addAttribute("pl1",pl1);
       // m.addAttribute("pl2",pl2);
        return "GameOn";
    }
    @RequestMapping("/byCountry")
    public String byCountry(Model m ,@RequestParam("Country") String option)
    {
        boolean ans=gameService.byCountry(option,pl1,pl2);
        System.out.println(ans);
        temp=listp2;
        if(ans==true)
        {
           listp2 = temp.stream()
                    .filter(player -> player.getPlayer_nation().equals(option))
                    .collect(Collectors.toList());
        }

        listp1=computerService.randomSelect(listp1,pl1,pl2);
        if(listp2.size()==1)
        {
            a=pl1;
            m.addAttribute("ans",a);
            return "Result2";
        }
        if(listp1.size()==1)
        {
            a=pl2;
            m.addAttribute("ans",a);
            return "Result1";
        }
        m.addAttribute("P1",listp1);
        m.addAttribute("P2",listp2);
        return "GameOn";
    }

    @RequestMapping("/byNature")
    public String byNatue(Model m ,@RequestParam("Nature") String option)
    {
        boolean ans=gameService.byNature(option,pl1,pl2);
        System.out.println(ans);
        temp=listp2;
        if(ans==true)
        {
            listp2 = temp.stream()
                    .filter(player -> player.getPlayer_nature().equals(option))
                    .collect(Collectors.toList());
        }

        listp1=computerService.randomSelect(listp1,pl1,pl2);
        if(listp2.size()==1)
        {
            a=pl1;
            m.addAttribute("ans",a);
            return "Result2";
        }
        if(listp1.size()==1)
        {
            a=pl2;
            m.addAttribute("ans",a);
            return "Result1";
        }
        m.addAttribute("P1",listp1);
        m.addAttribute("P2",listp2);
        return "GameOn";
    }

    @RequestMapping("/byStyle")
    public String byStyle(Model m ,@RequestParam("Style") String option)
    {
        boolean ans=gameService.byStyle(option,pl1,pl2);
        System.out.println(ans);
        temp=listp2;
        if(ans==true)
        {
            listp2 = temp.stream()
                    .filter(player -> player.getPlayer_style().equals(option))
                    .collect(Collectors.toList());
        }

        listp1=computerService.randomSelect(listp1,pl1,pl2);
        if(listp2.size()==1)
        {
            a=pl1;
            m.addAttribute("ans",a);
            return "Result2";
        }
        if(listp1.size()==1)
        {
            a=pl2;
            m.addAttribute("ans",a);
            return "Result1";
        }
        m.addAttribute("P1",listp1);
        m.addAttribute("P2",listp2);
        return "GameOn";
    }

    @RequestMapping("/byHair")
    public String byHair(Model m ,@RequestParam("Hair") String option)
    {
        boolean ans=gameService.byHair(option,pl1,pl2);
        System.out.println(ans);
        temp=listp2;
        if(ans==true)
        {
            listp2 = temp.stream()
                    .filter(player -> player.getPlayer_hair().equals(option))
                    .collect(Collectors.toList());
        }

        listp1=computerService.randomSelect(listp1,pl1,pl2);
        if(listp2.size()==1)
        {
            a=pl1;
            m.addAttribute("ans",a);
            return "Result2";
        }
        if(listp1.size()==1)
        {
            a=pl2;
            m.addAttribute("ans",a);
            return "Result1";
        }
        m.addAttribute("P1",listp1);
        m.addAttribute("P2",listp2);
        return "GameOn";
    }
    @RequestMapping("/byAge")
    public String byAge(Model m ,@RequestParam("Age") String option)
    {
        boolean ans=gameService.byAge(option,pl1,pl2);
        System.out.println(ans);
        temp=listp2;
        if(ans==true && option.equals("below 35"))
        {
            listp2 = temp.stream()
                    .filter(player -> player.getPlayer_age()<35)
                    .collect(Collectors.toList());
        }
        if(ans==true && option.equals("35-40"))
        {
            listp2 = temp.stream()
                    .filter(player -> player.getPlayer_age()>=35 && player.getPlayer_age()<=40)
                    .collect(Collectors.toList());
        }
        if(ans==true && option.equals("above 40"))
        {
            listp2 = temp.stream()
                    .filter(player -> player.getPlayer_age()>40)
                    .collect(Collectors.toList());
        }

        listp1=computerService.randomSelect(listp1,pl1,pl2);
        if(listp2.size()==1)
        {
            a=pl1;
            m.addAttribute("ans",a);
            return "Result2";
        }
        if(listp1.size()==1)
        {
            a=pl2;
            m.addAttribute("ans",a);
            return "Result1";
        }
        m.addAttribute("P1",listp1);
        m.addAttribute("P2",listp2);
        return "GameOn";
    }
//    @RequestMapping("/all")
//    public String  allPlayers(Model model)
//    {
//        List<Players> list=gameService.allplayers();
//        model.addAttribute("GamePlayer",list);
//        return "Game";
//    }
}

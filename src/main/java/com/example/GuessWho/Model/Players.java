package com.example.GuessWho.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Players
{
    @Id
    private int player_id;
    private String player_name;
    private String player_nation;
    private String player_nature;
    private String player_style;
    private String player_hair;
    private int player_age;
}

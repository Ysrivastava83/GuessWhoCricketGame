package com.example.GuessWho.DAO;

import com.example.GuessWho.Model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayersDAO extends JpaRepository<Players, Integer>
{
}

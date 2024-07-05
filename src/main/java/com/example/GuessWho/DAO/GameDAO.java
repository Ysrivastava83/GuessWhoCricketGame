package com.example.GuessWho.DAO;

import com.example.GuessWho.Model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameDAO extends JpaRepository<Players, Integer>
{
}

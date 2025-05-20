package com.kevinrehem.dslist.services;

import com.kevinrehem.dslist.dto.GameMinDTO;
import com.kevinrehem.dslist.entities.Game;
import com.kevinrehem.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        List<GameMinDTO> min_games = new ArrayList<>();
        for(Game it:result){
            min_games.add(new GameMinDTO(it));
        }
        return min_games;
    }
}

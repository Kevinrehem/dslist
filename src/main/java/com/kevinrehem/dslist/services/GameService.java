package com.kevinrehem.dslist.services;

import com.kevinrehem.dslist.dto.GameDTO;
import com.kevinrehem.dslist.dto.GameMinDTO;
import com.kevinrehem.dslist.entities.Game;
import com.kevinrehem.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findByID(Long gameID){
       return new GameDTO(gameRepository.findById(gameID).get());
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream().map(x-> new GameMinDTO(x)).toList();
    }


}

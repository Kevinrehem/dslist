package com.kevinrehem.dslist.controller;

import com.kevinrehem.dslist.dto.GameDTO;
import com.kevinrehem.dslist.dto.GameMinDTO;
import com.kevinrehem.dslist.entities.Game;
import com.kevinrehem.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findByID(@PathVariable Long id){ //Sem essa annotation dá internal server error tentando o get da API
        return gameService.findByID(id);
    }

    @GetMapping
    public List<GameMinDTO> findAll(){
        return gameService.findAll();
    }

}

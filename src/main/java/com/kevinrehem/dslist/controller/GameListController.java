package com.kevinrehem.dslist.controller;

import com.kevinrehem.dslist.dto.GameListDTO;
import com.kevinrehem.dslist.dto.GameMinDTO;
import com.kevinrehem.dslist.dto.ReplacementDTO;
import com.kevinrehem.dslist.services.GameListService;
import com.kevinrehem.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameListDTO findByID(@PathVariable Long id){
        return gameListService.findByID(id);
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/swapper")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}

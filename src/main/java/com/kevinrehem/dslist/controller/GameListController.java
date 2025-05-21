package com.kevinrehem.dslist.controller;

import com.kevinrehem.dslist.dto.GameListDTO;
import com.kevinrehem.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping(value = "/{id}")
    public GameListDTO findByID(@PathVariable Long id){
        return gameListService.findByID(id);
    }

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

}

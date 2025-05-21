package com.kevinrehem.dslist.services;

import com.kevinrehem.dslist.dto.GameListDTO;
import com.kevinrehem.dslist.entities.GameList;
import com.kevinrehem.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public GameListDTO findByID(Long id){
        return new GameListDTO(gameListRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        return gameListRepository.findAll().stream().map(x->new GameListDTO(x)).toList();
    }


}

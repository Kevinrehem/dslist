package com.kevinrehem.dslist.services;

import com.kevinrehem.dslist.dto.GameListDTO;
import com.kevinrehem.dslist.entities.GameList;
import com.kevinrehem.dslist.projections.GameMinProjection;
import com.kevinrehem.dslist.repositories.GameListRepository;
import com.kevinrehem.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameListDTO findByID(Long id){
        return new GameListDTO(gameListRepository.findById(id).get());
    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        return gameListRepository.findAll().stream().map(x->new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex:destinationIndex;
        int max = sourceIndex > destinationIndex ? sourceIndex:destinationIndex;

        for(int i=min; i<=max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }


}

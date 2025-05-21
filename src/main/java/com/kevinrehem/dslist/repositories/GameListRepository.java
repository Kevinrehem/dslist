package com.kevinrehem.dslist.repositories;

import com.kevinrehem.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}

package com.kevinrehem.dslist.repositories;

import com.kevinrehem.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}

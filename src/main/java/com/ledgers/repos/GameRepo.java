package com.ledgers.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ledgers.domain.Game;

public interface GameRepo extends CrudRepository<Game, Long> {
	public List<Game> findByCasinoId(Long id);
}

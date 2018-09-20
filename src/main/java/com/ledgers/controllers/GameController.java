package com.ledgers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ledgers.repos.GameRepo;
import com.ledgers.domain.Game;

@RestController
public class GameController {

	@Autowired
	GameRepo repo ;
	
	@RequestMapping(value="/games/{casinoId}", method=RequestMethod.GET)
	public List<Game> getGamesForCasino(@PathVariable("casinoId") Long casinoId){
		return repo.findByCasinoId(casinoId); 
	}
	
	@RequestMapping(value="/games/", method=RequestMethod.POST)
	public Long createNewGame(@RequestBody Game game) {
		System.out.println(game);
		game = repo.save(game) ;
		return game.getId() ;
	}
	
}

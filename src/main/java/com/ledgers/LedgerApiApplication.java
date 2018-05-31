package com.ledgers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ledgers.domain.Casino;
import com.ledgers.domain.Game;
import com.ledgers.domain.Table;
import com.ledgers.domain.Balance;

import com.ledgers.repos.CasinoRepo;
import com.ledgers.repos.GameRepo;
import com.ledgers.repos.TableRepo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class LedgerApiApplication {

	private static final Logger log = LoggerFactory.getLogger(LedgerApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LedgerApiApplication.class, args);
	}
	

// Add Game repo
	@Bean
	public CommandLineRunner demo(CasinoRepo repository, TableRepo tableRepo, GameRepo gameRepo) {
		return (args) -> {
			Casino flexHome = new Casino("Flex Home Casino", -73.961825f, 40.712002f, new BigDecimal(100), "FH");
			repository.save(flexHome) ;
			BigDecimal tablePodium = new BigDecimal(100.00f) ;
			
			ArrayList<Game> games = new ArrayList<Game>();
			Game game = new Game(flexHome.getId(), "Blackjack", "FHC1000");
			gameRepo.save(game) ;		
			games.add(game) ;
			
			game = new Game(flexHome.getId(), "Poker", "FHC1001");
			gameRepo.save(game) ;		
			games.add(game) ;
			
			HashMap<String,BigDecimal> balances = new HashMap<String,BigDecimal>() ;
			balances.put(new String("game:"+ games.get(0).getId()), new BigDecimal(50));
			balances.put(new String("game:"+ games.get(1).getId()), new BigDecimal(50));
			
			Table table = new Table(flexHome.getId(), 1, games, tablePodium, true, 0, balances);
//			ArrayList<Balance> newBalances = new ArrayList<Balance>();
//			Balance balance = new Balance();
//			balance.
//			newBalances.add(new Balance()) ;
//			table.setNewBalances(newBalances);
			tableRepo.save(table);
			System.out.println(table.toString());

			ArrayList<Game> games2 = new ArrayList<Game>();
			
			game = new Game(flexHome.getId(), "Roulette", "FHC1002");
			gameRepo.save(game) ;		
			games2.add(game) ;
			
			game = new Game(flexHome.getId(), "Baccarat", "FHC1003");
			gameRepo.save(game) ;		
			games2.add(game) ;
			
			balances = new HashMap<String,BigDecimal>() ;
			balances.put(new String("game:"+ games2.get(0).getId()), new BigDecimal(50));
			balances.put(new String("game:"+ games2.get(1).getId()), new BigDecimal(50));
			Table table2 = new Table(flexHome.getId(), 2, games2, tablePodium, true, 0, balances);
			tableRepo.save(table2);
			
			game = new Game(flexHome.getId(),"Three Card Poker", "FHC1004") ;
			gameRepo.save(game);

			game = new Game(flexHome.getId(),"Pai Gow", "FHC1005") ;
			gameRepo.save(game);
			
			
//			ArrayList<Game> games3 = new ArrayList<Game>();
//			games3.add(new Game(flexHome.getId(), "Roulette", "FHC1002")) ;
//			games3.add(new Game(flexHome.getId(), "Baccarat", "FHC1003")) ;
//			games3.add(new Game(flexHome.getId(), "Three Card Poker", "FHC1004")) ;
//			games3.add(new Game(flexHome.getId(), "Pai Gow", "FHC1005")) ;
//			
//			Table table3 = new Table(flexHome.getId(), games3.size(), games3, tablePodium, true, 0);
//			tableRepo.save(table3);
		};
	}
}

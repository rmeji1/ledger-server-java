package com.ledgers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

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

@EnableResourceServer
@SpringBootApplication
public class LedgerApiApplication {

	private static final Logger log = LoggerFactory.getLogger(LedgerApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LedgerApiApplication.class, args);
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
	    return new StandardServletMultipartResolver();
	}

	
//
//    @EnableGlobalMethodSecurity(prePostEnabled = true)
//    protected static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
//        @Override
//        protected MethodSecurityExpressionHandler createExpressionHandler() {
//            return new OAuth2MethodSecurityExpressionHandler();
//        }
//    }
//
//    @Configuration
//    @Order(0)
//    static class ResourceSecurityConfigurer extends ResourceServerConfigurerAdapter {
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            http.authorizeRequests()
//                    .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
//                    .anyRequest().authenticated();
//        }
//}
	
	
	
	
	
	
// Add Game repo
	@Bean
	public CommandLineRunner demo(CasinoRepo repository, TableRepo tableRepo, GameRepo gameRepo) {
		return (args) -> {
			//Casino(String casinoCode, String name, float longitude, float latitude, String casinoImageURL,
			//		BigDecimal podium)
			
			Casino flexHome = new Casino("FH","Flex Home Casino", 
					-73.961830f, 
					20.712000f, 
					"http://arctecinc.com/wp-content/uploads/2015/08/Casino-M8trix-1-MAIN-PHOTO.jpg",
					new BigDecimal(0));
			
			repository.save(flexHome) ;
			HashMap<String,BigDecimal> balances = new HashMap<String,BigDecimal>() ;
			ArrayList<Game> games = new ArrayList<Game>();

			
			// Create games, save new game, add to list of games, great start balance for game
			Game game = new Game(flexHome.getId(), "Blackjack", "FHC1000");
			gameRepo.save(game) ;
			games.add(game) ;
			balances.put(game.getGega(), new BigDecimal(50));
			
			// Create games, save new game, add to list of games, great start balance for game
			game = new Game(flexHome.getId(), "Poker", "FHC1001");
			gameRepo.save(game) ;	
			games.add(game) ;
			balances.put(game.getGega(), new BigDecimal(100));

			// TablePodium should equal 100.
			BigDecimal tablePodium = new BigDecimal(0) ;
			for (BigDecimal balance : balances.values()) {
				System.out.println("Balance: " + balance);
				tablePodium = tablePodium.add(balance);
			}
			
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

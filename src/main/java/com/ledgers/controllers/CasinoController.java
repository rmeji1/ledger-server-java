package com.ledgers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ledgers.domain.Casino;
import com.ledgers.repos.CasinoRepo;

@RestController
public class CasinoController {
	
	@Autowired 
	CasinoRepo repo ;
	
	@RequestMapping(value="/caisno/find/{long}/{lat}", method = RequestMethod.GET)
	public Casino findCasinoUserIn(@RequestParam("long") float longitude, @RequestParam("lat") float lat) {
		float[] results = new float[1];
//		repo.findAll()
		
		return null ;
	}
	
	
	@RequestMapping(value ="/casino", method = RequestMethod.POST)
	public Long saveCasino(@RequestBody Casino casino) {
		System.out.println(casino.getName());
		repo.save(casino);
		return casino.getId();
	}
	
	@RequestMapping(value = "/casinos" , method = RequestMethod.GET)
    public Iterable<Casino> listOfCasinos(){
    		return repo.findAll();
    }
	
	@RequestMapping(value="/casinos/count", method = RequestMethod.GET)
	public long findNumberOfCasinos() {
		return repo.count();
	}

}

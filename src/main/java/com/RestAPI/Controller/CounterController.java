package com.RestAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.RestAPI.Model.Counter;
import com.RestAPI.Service.CounterService;

@RestController
public class CounterController {
	
	@Autowired
	private CounterService counterServ;
	
	@RequestMapping(value="/update", method = RequestMethod.PUT, headers="Accept=application/json")
	 public ResponseEntity<Void> update(Counter count){
	  counterServ.update(count);
	  HttpHeaders headers = new HttpHeaders();
	  return new ResponseEntity<Void>(headers, HttpStatus.OK);
	 }

}

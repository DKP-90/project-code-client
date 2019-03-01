package com.help.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.help.demo.model.Response;
import com.help.demo.service.Download_service;
import com.help.demo.service.Media_service;


@RestController
public class Main_controller {
	

	@Autowired
	Response res;
	@Autowired
	Download_service ds;
	@Autowired
	Media_service ms;
	
	    @RequestMapping(value = "/download",method = RequestMethod.GET)
	    public ResponseEntity<Response> getPageLinks(@RequestParam("id") int id) {

	    	res= ds.download(ms.fetchlogicById(id));
	    
	        return ResponseEntity.ok().body(res);
	    }



}

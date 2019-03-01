package com.help.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.help.demo.controller.model.repository.media_repo;
import com.help.demo.model.Media;




@Service
public class Media_implementation implements Media_service {

	@Autowired
	media_repo media_obj;

	@Override
	public Media fetchlogicById(int id) {
		Optional<Media> media_return= media_obj.findById(id);
	     if(media_return.isPresent()){
	         return media_return.get();
	     }
	     return null;
	}
	

}

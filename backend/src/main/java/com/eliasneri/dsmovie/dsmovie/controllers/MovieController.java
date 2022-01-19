package com.eliasneri.dsmovie.dsmovie.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eliasneri.dsmovie.dsmovie.dto.MovieDTO;
import com.eliasneri.dsmovie.dsmovie.services.MovieService;

@Controller
@RequestMapping(value = "/movies")
public class MovieController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> findAll(Pageable pageable){
		Page<MovieDTO> result = service.findAll(pageable);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<MovieDTO> findById(@PathVariable Long id){
		MovieDTO result = service.findById(id);
		return ResponseEntity.ok(result);
	}
	
	
	
	

}

package com.eliasneri.dsmovie.dsmovie.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eliasneri.dsmovie.dsmovie.dto.MovieDTO;
import com.eliasneri.dsmovie.dsmovie.entities.Movie;
import com.eliasneri.dsmovie.dsmovie.repositories.MovieRepository;

@Service
public class MovieService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private MovieRepository repository;
	
	
	@Transactional (readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable) {
		Page<Movie> result = repository.findAll(pageable);
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x));
		return page;
		
	}
	
	

}

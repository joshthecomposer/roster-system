package com.jw.rosteronetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jw.rosteronetomany.models.Dorm;
import com.jw.rosteronetomany.repositories.DormRepository;

@Service
public class DormService {
	private final DormRepository dRepo;
	
	public DormService(DormRepository dRepo) {
		this.dRepo=dRepo;
	}
	
	public List<Dorm> findAll() {
		return dRepo.findAll();
	}
	
	public Dorm save(Dorm d) {
		return dRepo.save(d);
	}
	
	public Dorm findById(Long id) {
		Optional<Dorm> o = dRepo.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	public void deleteById(Long id) {
		dRepo.deleteById(id);
	}
}

package com.jw.rosteronetomany.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jw.rosteronetomany.models.Student;
import com.jw.rosteronetomany.repositories.StudentRepository;

@Service
public class StudentService {
	private final StudentRepository sRepo;
	
	public StudentService(StudentRepository sRepo) {
		this.sRepo=sRepo;
	}
	
	public List<Student> findAll() {
		return sRepo.findAll();
	}
	
	public Student save(Student s) {
		return sRepo.save(s);
	}
	
	public void deleteById(Long id) {
		sRepo.deleteById(id);
	}
	
}

package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
public class AlienController {
	
	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@PostMapping("/alien")
	public Alien add(@RequestBody Alien a) {
		
		repo.save(a);
		return a;
	}
//	
//	@RequestMapping("/getAlien")
//	public ModelAndView get(@RequestParam int aid ) { //get data and mapped it with client side
//		
//		ModelAndView mv  = new ModelAndView("show.jsp");
//		Alien a = repo.findById(aid).orElse(new Alien());
//		mv.addObject(a);
//		return mv;
//	}
	
	@DeleteMapping(path="/alien/{id}")
	public String delete(@PathVariable("id") int id) {
		
	Alien a = repo.getOne(id);	
	repo.delete(a);
	String	message ="Successful"; 
		return message;
	}
	@PutMapping(path="/alien")
	public Alien update(@RequestBody Alien a) {
		
		repo.save(a);
		return a;
	}
//	
	
	@RequestMapping(path="/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	@GetMapping("/alien/{id}")
	public Optional<Alien> getAlien(@PathVariable("id") int aid) {
		return repo.findById(aid);
	}
}

package br.com.fiap.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.bean.Curso;
import br.com.fiap.dao.CursoDAO;

@RestController
public class CursoController {
	
	@Autowired
	private CursoDAO cursoDAO;
	
	@RequestMapping(value = "/cursos")
	  public ResponseEntity<ArrayList<Curso>> list() {
	    return new ResponseEntity<ArrayList<Curso>>((ArrayList<Curso>) cursoDAO.list(), HttpStatus.OK);
	  }
	

	@GetMapping("/curso/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Long id) {

		Curso curso = cursoDAO.find(id);
		if (curso == null) {
			return new ResponseEntity<>("Curso não existe com id: " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}

	@PostMapping(value = "/curso")
	public ResponseEntity<?> save(@RequestBody Curso curso) {

		cursoDAO.save(curso);

		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}

	@DeleteMapping("/curso/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {

		if (null == cursoDAO.remove(id)) {
			return new ResponseEntity<>("Curso não existe com id: " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Curso>(HttpStatus.OK);

	}

	@PutMapping("/curso/{id}")
	public ResponseEntity<?> merge(@PathVariable Long id, @RequestBody Curso curso) {

		curso = cursoDAO.merge(id, curso);

		if (null == curso) {
			return new ResponseEntity<>("Curso não existe com id: " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Curso>(curso, HttpStatus.OK);
	}
	
}

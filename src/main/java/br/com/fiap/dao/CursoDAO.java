package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.fiap.bean.Curso;

@Component
public class CursoDAO {

	private static List<Curso> cursos;
	{
		
		cursos = new ArrayList<Curso>();
		
		cursos.add(new Curso(1L, "MicroServices", "Jhonatan Rojas"));
		cursos.add(new Curso(2L, "DevOps", "Julio da Silva"));
		cursos.add(new Curso(3L, "Arquitetura de Software", "Matias dos Santos"));
				
	}
	
	/**
	 * 
	 * @return lista de cursos
	 */
	public List<Curso> list(){
		return cursos;
	}
	
	/**
	 * Retorna o objeto Curso.
	 * 
	 * @param id
	 * @return Curso
	 */
	public Curso find(Long id) {
		for (Curso curso : cursos) {
			if(curso.getId() == id) {
				return curso;
			}
		}
		return null;
	}
	
	/**
	 * Salva o objeto Curso.
	 * 
	 * @param c
	 * @return Curso
	 */
	public Curso save(Curso c) {
		c.setId(cursos.size()+1);
		cursos.add(c);
		return c;
	}
	
	/**
	 * Remove o objeto Curso.
	 * 
	 * @param id
	 * @return Curso
	 */
	public Curso remove(Long id) {
		for (Curso curso : cursos) {
			if(curso.getId() == id) {
				cursos.remove(curso);
				return curso;
			}
		}
		return null;
	}
	
	/**
	 * Atualizar o objeto Curso.
	 * 
	 * @param id
	 * @return Curso
	 */
	public Curso merge(Long id, Curso c) {
		for (Curso curso : cursos) {
			if(curso.getId() == id) {
				c.setId(curso.getId());
				cursos.remove(curso);
				cursos.add(c); 
				return curso;
			}
		}
		return null;
		
	}
	
	
	
}

package br.com.fiap.bean;


public class Curso {
	private long id;
	private String nome;
	private String nomeProfessor;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}
	
	public Curso(long id, String nome, String nomeProfessor) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeProfessor = nomeProfessor;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	
	
}

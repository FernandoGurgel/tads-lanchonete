package br.tads.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cod;
	private String nome;
	private String email;
	private String senha;

	public Usuario() {}
	
	public Usuario(int cod, String nome, String email, String senha) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Usuario(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

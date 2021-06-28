package br.upf.ads.rondasgp8.model;

import java.io.Serializable;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Pessoa implements Serializable {  // 2) implementar Serializable
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 1) atributos encapsulados = private 
	@Id
	private Integer id;
	private String nome;
	private String loginapp;
	private String senha;
	
	@Lob
	private byte[] foto;
	
	
	// 3) Construtor sem argumentos
	public Pessoa() {
		super();
	}
	
	public Pessoa(Integer id, String nome, String loginapp, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.loginapp = loginapp;
		this.senha = senha;
		
	}
	
	public Pessoa(Integer id) {
		super();
		this.id = id;
	}

	public Pessoa(String nome) {
		super();
		this.nome = nome;
		
	}

	// 4) Possuir métodos get e set públicos para atributos
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginApp() {
		return loginapp;
	}

	public void setLoginApp(String loginapp) {
		this.loginapp = loginapp;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	// 6) Substituições equals, hashCode e toString	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public String getFotoBase64() {
		if (foto != null)
		   return new String(Base64.getEncoder().encode(foto));
		else
		   return "";
	}
	
	
}

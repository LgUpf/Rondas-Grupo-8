package br.upf.ads.rondasgp8.model;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Base64;
import java.util.Date;
import java.lang.Float;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Entity implementation class for Entity: Ocorrencia
 *
 */
@Entity

public class Ocorrencia implements Serializable {

	   
	/**
	 * 
	 */

	@Id
	private Integer id;
	private String titulo;
	private String descricao;
	private float latitude;
	private float longitude;
	@Temporal(TemporalType.DATE)
	private Date dataHora;
	@Lob
	private byte[] foto;

	private static final long serialVersionUID = 1L;
	public Ocorrencia() {
		super();
	}   	
	

	public Ocorrencia(Integer id, String titulo, String descricao, Date dataHora, float latitude, float longitude) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.latitude = latitude;
		this.longitude = longitude;
		this.dataHora = dataHora;
	}
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getLatitude() {
		return latitude;
	}


	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}


	public float getLongitude() {
		return longitude;
	}


	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}


	public Date getDataHora() {
		return dataHora;
	}


	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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
package br.upf.ads.rondasgp8.model;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Date;
import java.lang.Float;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Localizacao
 *
 */
@Entity

public class Localizacao implements Serializable {

	@Id
	private Integer id;
	private float latitude;
	private float longitude;
	@Temporal(TemporalType.DATE)
	private Date horaData;
	
	private static final long serialVersionUID = 1L;

	public Localizacao() {
		super();
	}   	
	public Localizacao(Integer id, Date horaData, float latitude, float longitude) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.horaData = horaData;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public Date getHoraData() {
		return horaData;
	}
	public void setHoraData(Date horaData) {
		this.horaData = horaData;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

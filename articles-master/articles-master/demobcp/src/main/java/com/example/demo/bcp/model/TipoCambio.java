package com.example.demo.bcp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoCambio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double monto;
	private String monedaori;
	private String monedades;
	private double tipocam;
	private Double respuesta;

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getMonedaori() {
		return monedaori;
	}

	public void setMonedaori(String monedaori) {
		this.monedaori = monedaori;
	}

	public String getMonedades() {
		return monedades;
	}

	public void setMonedades(String monedades) {
		this.monedades = monedades;
	}

	public Double getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Double respuesta) {
		this.respuesta = respuesta;
	}

	public double getTipocam() {
		return tipocam;
	}

	public void setTipocam(double tipocam) {
		this.tipocam = tipocam;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TipoCambio [id=" + id + ", monto=" + monto + ", monedaori=" + monedaori + ", monedades=" + monedades
				+ ", tipocam=" + tipocam + ", respuesta=" + respuesta + "]";
	}

}

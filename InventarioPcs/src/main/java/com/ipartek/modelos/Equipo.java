package com.ipartek.modelos;

import java.util.Objects;

public class Equipo {
	
	private Long id;
	private String numero_serie;
	private String nombre;
	private String modelo;
	private String procesador;
	private String ram;
	private String disco;
	private String capacidad_disco;
	private String aula;
	
	
	
	public Equipo(Long id, String numero_serie, String nombre, String modelo, String procesador,String ram, String disco, String capacidad_disco, String aula) {
		setId(id);
		setNumero_serie(numero_serie);
		setNombre (nombre);
		setModelo(modelo);
		setProcesador(procesador);
		setRam(ram);
		setDisco(disco);
		setCapacidad_disco(capacidad_disco);
		setAula(aula);
	}
	public Equipo() {}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero_serie() {
		return numero_serie;
	}
	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getProcesador() {
		return procesador;
	}
	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getDisco() {
		return disco;
	}
	public void setDisco(String disco) {
		this.disco = disco;
	}
	public String getCapacidad_disco() {
		return capacidad_disco;
	}
	public void setCapacidad_disco(String capacidad_disco) {
		this.capacidad_disco = capacidad_disco;
	}
	public String getAula() {
		return aula;
	}
	public void setAula(String aula) {
		this.aula = aula;
	}
	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", numero_serie=" + numero_serie + ", modelo="
				+ modelo + ", procesador=" + procesador + ", ram=" + ram + ", disco=" + disco + ", capacidad_disco="
				+ capacidad_disco + ", aula=" + aula + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(aula, capacidad_disco, disco, id, modelo, nombre, numero_serie, procesador, ram);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(capacidad_disco, other.capacidad_disco)
				&& Objects.equals(disco, other.disco) && Objects.equals(id, other.id)
				&& Objects.equals(modelo, other.modelo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(numero_serie, other.numero_serie) && Objects.equals(procesador, other.procesador)
				&& Objects.equals(ram, other.ram);
	}
	
}
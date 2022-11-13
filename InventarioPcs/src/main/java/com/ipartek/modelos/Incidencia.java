package com.ipartek.modelos;

import java.util.Objects;

public class Incidencia {
	private Long id;
	private String nombre_equipo; 
	private String descripcion; 
	private String aula;
	private String inicio;
	private String fin;
	private String reportado_por; 
	private String estado; 
	private String resuelto_por;
	 

	public Incidencia(Long id, String nombre_equipo, String descripcion, String aula, String inicio, String fin,
			String reportado_por, String estado, String resuelto_por) {
		setId(id);
		setNombre_equipo(nombre_equipo);
		setDescripcion(descripcion);
		setAula(aula);
		setInicio(inicio);
		setFin(fin);
		setReportado_por(reportado_por);
		setEstado(estado);
		setResuelto_por(resuelto_por);
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_equipo() {
		return nombre_equipo;
	}

	public void setNombre_equipo(String nombre_equipo) {
		this.nombre_equipo = nombre_equipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getReportado_por() {
		return reportado_por;
	}

	public void setReportado_por(String reportado_por) {
		this.reportado_por = reportado_por;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getResuelto_por() {
		return resuelto_por;
	}

	public void setResuelto_por(String resuelto_por) {
		this.resuelto_por = resuelto_por;
	}

	@Override
	public String toString() {
		return "Incidencia [id=" + id + ", nombre_equipo=" + nombre_equipo + ", descripcion=" + descripcion + ", aula="
				+ aula + ", inicio=" + inicio + ", fin=" + fin + ", reportado_por=" + reportado_por + ", estado="
				+ estado + ", resuelto_por=" + resuelto_por + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aula, descripcion, estado, fin, id, inicio, nombre_equipo, reportado_por, resuelto_por);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Incidencia other = (Incidencia) obj;
		return Objects.equals(aula, other.aula) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(estado, other.estado) && Objects.equals(fin, other.fin)
				&& Objects.equals(id, other.id) && Objects.equals(inicio, other.inicio)
				&& Objects.equals(nombre_equipo, other.nombre_equipo)
				&& Objects.equals(reportado_por, other.reportado_por)
				&& Objects.equals(resuelto_por, other.resuelto_por);
	}	
	
}

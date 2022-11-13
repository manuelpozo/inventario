package com.ipartek.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.dao.DB_Help;
import com.ipartek.modelos.Incidencia;


@WebServlet("/incidenciainsertar")
public class IncidenciaInsertarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Help db = new DB_Help();
		request.setAttribute("listanombresequipos", db.obtenerTodos());
		
		request.getRequestDispatcher("WEB-INF/vistas/incidenciainsertar.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nombre_equipo = request.getParameter("nombre_equipo");
		String descripcion = request.getParameter("descripcion");
		String aula = request.getParameter("aula");
		String reportado_por = request.getParameter("reportado_por");
		String resuelto_por = request.getParameter("resuelto_por");
		
		
		String inicio="";
		String fin ="";
		String estado ="";
		Long idLong=null;
		Incidencia incidencia = new Incidencia(idLong,nombre_equipo,descripcion,aula,inicio,fin,reportado_por,estado,resuelto_por);
		
		 String texto=null;
		DB_Help db = new DB_Help();
		db.insertar(incidencia);
		
		texto = "Se ha añadido correctamente la incidencia con id " + incidencia.getId() + " del equipo " + incidencia.getNombre_equipo();
		request.setAttribute("texto", texto);
		request.getRequestDispatcher("incidenciastodas").forward(request, response);
	}

}

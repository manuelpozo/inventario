package com.ipartek.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.dao.DB_Help;
import com.ipartek.modelos.Incidencia;


@WebServlet("/incidenciaadmin")
public class IncidenciaAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		
		Long idLong =null;
		
		if(id != null) {
			idLong = Long.parseLong(id);
		}
		
		request.setAttribute("op", op);
		DB_Help db = new DB_Help();
		request.setAttribute("incidencia", db.incidenciaPorId(idLong));
		request.setAttribute("listanombresequipos", db.obtenerTodos());
		request.getRequestDispatcher("WEB-INF/vistas/incidenciasadmin.jsp").forward(request, response);
			
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String nombre_equipo = request.getParameter("nombre_equipo");
		String descripcion = request.getParameter("descripcion");
		String aula = request.getParameter("aula");
		String inicio = request.getParameter("inicio");
		String fin = request.getParameter("fin");
		String reportado_por = request.getParameter("reportado_por");
		String estado = request.getParameter("estado");
		String resuelto_por = request.getParameter("resuelto_por");
		
		if (fin != null && fin.trim().length()<1) {
			fin = null;
		}
		
		Long idLong = null;
		
		if(id != null && id.trim().length() > 0) {
			idLong = Long.parseLong(id);
		}
		
		Incidencia incidencia = null;
		
		if(!op.equals("borrar")) {
			incidencia = new Incidencia(idLong, nombre_equipo, descripcion, aula, inicio, fin, reportado_por, estado, resuelto_por);
			
		}
		String texto=null;
		switch(op) {
		
		case "borrar":
			DB_Help db = new DB_Help();
			db.borrarincidencia(idLong);
			texto= "Se ha borrado correctamente la incidencia con id "+ idLong; 
			break;
		case "editar":
			DB_Help db1 = new DB_Help();
			db1.editarIncidencia(incidencia);
			texto= "Se ha modificado correctamente la incidencia con id "+ idLong +" del equipo " +incidencia.getNombre_equipo();
			break;
		
		default:
			throw new RuntimeException("Opcion no esperada: " + op);
		}
		request.setAttribute("texto", texto);
		request.getRequestDispatcher("incidenciastodas").forward(request, response);
	}

}

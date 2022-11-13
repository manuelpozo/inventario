package com.ipartek.controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.dao.DB_Help;
import com.ipartek.modelos.Equipo;


@WebServlet("/equiposadmin")
public class EquiposAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		Long idLong =null;
		
		if(id != null) {
			idLong = Long.parseLong(id);
		}
		
		request.setAttribute("op", op);
		switch(op) {
		case "borrar":
		case "editar":
			DB_Help db = new DB_Help();
			request.setAttribute("equipo", db.equipoPorId(idLong));
		case "agregar":
			request.getRequestDispatcher("WEB-INF/vistas/equiposadmin.jsp").forward(request, response);
			break;
		default:
			throw new RuntimeException("Opcion no esperada: " + op);
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = request.getParameter("op");
		String id = request.getParameter("id");
		String numero_serie = request.getParameter("numero_serie");
		String nombre = request.getParameter("nombre");
		String modelo = request.getParameter("modelo");
		String procesador = request.getParameter("procesador");
		String ram = request.getParameter("ram");
		String disco = request.getParameter("disco");
		String capacidad_disco = request.getParameter("capacidad_disco");
		String aula = request.getParameter("aula");
		
		Long idLong = null;
		
		if(id != null && id.trim().length() > 0) {
			idLong = Long.parseLong(id);
		}
		
		Equipo equipo = null;
		
		if(!op.equals("borrar")) {
			equipo = new Equipo(idLong, numero_serie, nombre, modelo, procesador, ram, disco, capacidad_disco,aula);
			
		}
		String texto = null;
		
		switch(op) {
		
		case "borrar":
			DB_Help db = new DB_Help();
			db.borrarequipo(idLong);
			texto = "Se ha borrado correctamente el equipo con id " +idLong; 
			break;
		case "editar":
			DB_Help db1 = new DB_Help();
			db1.modificar(equipo);
			texto = "Se ha modificado correctamente el equipo con id " + equipo.getId() + " y nombre " + equipo.getNombre();
			break;
		case "agregar":
			DB_Help db2 = new DB_Help();
			db2.insertar(equipo);
			texto = "Se ha añadido correctamente el equipo con id " + equipo.getId() + " y nombre " + equipo.getNombre();
			break;
		default:
			throw new RuntimeException("Opcion no esperada: " + op);
		}
		request.setAttribute("texto", texto);
		request.getRequestDispatcher("equipostodos").forward(request, response);
	}

}

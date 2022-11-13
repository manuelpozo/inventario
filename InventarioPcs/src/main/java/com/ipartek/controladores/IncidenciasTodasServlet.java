package com.ipartek.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ipartek.dao.DB_Help;
import com.ipartek.modelos.Incidencia;


@WebServlet("/incidenciastodas")
public class IncidenciasTodasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public IncidenciasTodasServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Help db =  new DB_Help();
		Connection con =db.conectar();
		
		ArrayList <Incidencia> listaincidencias =db.incidenciasTodas();
		request.setAttribute("listaincidencias", listaincidencias);
		request.getRequestDispatcher("WEB-INF/vistas/incidenciaslista.jsp").forward(request, response);
		db.desconectar(con);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

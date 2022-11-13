package com.ipartek.controladores;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


import com.ipartek.dao.DB_Help;
import com.ipartek.modelos.Equipo;


@WebServlet("/equipostodos")
public class EquiposTodosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EquiposTodosServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Help db =  new DB_Help();
		Connection con =db.conectar();
		
		ArrayList <Equipo> listaequipos =db.obtenerTodos();
		request.setAttribute("listaequipos", listaequipos);
		request.getRequestDispatcher("WEB-INF/vistas/equiposlista.jsp").forward(request, response);
		db.desconectar(con);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

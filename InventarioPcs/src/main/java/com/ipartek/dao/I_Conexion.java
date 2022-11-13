package com.ipartek.dao;

import java.sql.Connection;
import java.util.ArrayList;


import com.ipartek.modelos.Equipo;

import com.ipartek.modelos.Incidencia;

public interface I_Conexion {
	String USER="root";
	String PASS="admin";
	String DB="inventario_pcs";
	String DRIVER="com.mysql.cj.jdbc.Driver";
	String CONEXION = "jdbc:mysql://localhost:3306/" + DB + "?useSSL=false&noAccessToProcedureBodies=true";
	
	//String SELECT_EQUIPOS_TODOS= "call equipo_buscar_todos()";
	//String SELECT_EQUIPO_ID = "call equipo_buscar_id(?)";
	//String INSERT_EQUIPO = "call equipo_insertar(poner las?)";
	//String UPDATE_EQUIPO= "call equipo_editar(poner las?)";
	//String DELETE_EQUIPO = "call equipo_borrar(?)";
	
	String SELECT_EQUIPOS_TODOS= "SELECT id, numero_serie, nombre, modelo, procesador, ram, disco, capacidad_disco, aula FROM equipos";
	String SELECT_EQUIPO_ID = SELECT_EQUIPOS_TODOS + " WHERE id = ?";
	String INSERT_EQUIPO = "INSERT INTO equipos (numero_serie, nombre, modelo, procesador, ram, disco, capacidad_disco, aula) VALUES (?,?,?,?,?,?,?,?)";
	String UPDATE_EQUIPO= "UPDATE equipos SET numero_serie=?, nombre =?, modelo=?, procesador=?, ram=?, disco=?, capacidad_disco=?, aula=? WHERE id=?";
	String DELETE_EQUIPO = "DELETE FROM equipos WHERE id=?";
	String SELECT_EQUIPO_NOMBRES =" SELECT nombre FROM equipos";
	
	String SELECT_INCIDENCIAS_TODAS= "SELECT id, nombre_equipo, descripcion, aula, inicio, fin, reportado_por, estado, resuelto_por FROM incidencias";
	String SELECT_INCIDENCIA_ID = SELECT_INCIDENCIAS_TODAS + " WHERE id = ?";
	String INSERT_INCIDENCIA = "INSERT INTO incidencias (nombre_equipo, descripcion, aula, inicio, reportado_por, resuelto_por ) VALUES (?,?,?,?,?,?)";
	String UPDATE_INCIDENCIA= "UPDATE incidencias SET nombre_equipo=?, descripcion=?, aula=?, inicio=?, fin=?, reportado_por=?, estado=?, resuelto_por=? WHERE id=?";
	String DELETE_INCIDENCIA = "DELETE FROM incidencias WHERE id=?";
	
	
	Connection conectar();
	void desconectar(Connection con);
	Equipo equipoPorId(Long id);
	ArrayList<Equipo> obtenerTodos();
	Equipo insertar(Equipo equipo);
	Equipo modificar(Equipo equipo);
	void borrarequipo(Long id);
	
	Incidencia incidenciaPorId(Long id);
	ArrayList<Incidencia> incidenciasTodas();
	Incidencia insertar(Incidencia incidencia);
	Incidencia editarIncidencia(Incidencia incidencia);
	void borrarincidencia(Long id);
	
	
}

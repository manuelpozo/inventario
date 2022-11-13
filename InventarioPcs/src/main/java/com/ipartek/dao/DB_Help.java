package com.ipartek.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;


import com.ipartek.modelos.Equipo;

import com.ipartek.modelos.Incidencia;



public class DB_Help implements I_Conexion{
	
	@Override
	public Connection conectar() {
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONEXION, USER, PASS);
		} catch (ClassNotFoundException e) {
			;
			System.out.println("accesodatos.conectar(): NO SE ENCONTRO EL mysql-connector-java.jar");
			return null;
		} catch (SQLException e) {

			System.out.println("accesodatos.conectar(): NO SE PUDO CONECTAR A LA BD");
			System.out.println("REVISA EL USUARIO, CONTRASEÑA Y EL NOMBRE Y CONEXION A LA BD");
			return null;
		} catch (Exception e) {

			System.out.println("accesodatos.conectar(): ERROR DESCONOCIDO");
			return null;
		}
		System.out.println("accesodatos.conectar(): CONEXION ESTABLECIDA");
		return con;
	}

	@Override
	public void desconectar(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la desconexion", e);
	}
	}

	@Override
	public ArrayList<Equipo> obtenerTodos() {
		try (Connection con = conectar();
				PreparedStatement ps = con.prepareStatement(SELECT_EQUIPOS_TODOS);
				ResultSet rs = ps.executeQuery()) {

			ArrayList<Equipo> equiposlista = new ArrayList<>();

			while (rs.next()) {
				equiposlista.add(new Equipo(rs.getLong("id"), rs.getString("numero_serie"),
						rs.getString("nombre"),rs.getString("modelo"),rs.getString("procesador"),
						rs.getString("ram"),rs.getString("disco"),rs.getString("capacidad_disco"), rs.getString("aula")));
				
			}
			desconectar(con);
			System.out.println(equiposlista);
			return equiposlista;
		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todos los equipos", e);
		}
	}
	@Override
	public  Equipo equipoPorId(Long id) {
		try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(SELECT_EQUIPO_ID);) {
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			Equipo equipo = null;

			if (rs.next()) {
				equipo = new Equipo(rs.getLong("id"), rs.getString("numero_serie"),
						rs.getString("nombre"),rs.getString("modelo"),rs.getString("procesador"),
						rs.getString("ram"),rs.getString("disco"),rs.getString("capacidad_disco"), rs.getString("aula"));;
			}
			desconectar(con);
			return equipo;
			
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de obtener equipo por id ha fallado", e);
		}
	}
		

	@Override
	public Equipo insertar(Equipo equipo) {
		try ( Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(INSERT_EQUIPO, Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, equipo.getNumero_serie());
			ps.setString(2, equipo.getNombre());
			ps.setString(3, equipo.getModelo());
			ps.setString(4, equipo.getProcesador());
			ps.setString(5, equipo.getRam());
			ps.setString(6, equipo.getDisco());
			ps.setString(7, equipo.getCapacidad_disco());
			ps.setString(8, equipo.getAula());
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			rs.next();

			equipo.setId(rs.getLong(1));
			desconectar(con);
			return equipo;
			
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de insertar equipo ha fallado", e);
		}
	}
	

	@Override
	public Equipo modificar(Equipo equipo) {
		try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(UPDATE_EQUIPO);) {
			
			ps.setString(1, equipo.getNumero_serie());
			ps.setString(2, equipo.getNombre());
			ps.setString(3, equipo.getModelo());
			ps.setString(4, equipo.getProcesador());
			ps.setString(5, equipo.getRam());
			ps.setString(6, equipo.getDisco());
			ps.setString(7, equipo.getCapacidad_disco());
			ps.setString(8, equipo.getAula());
			ps.setLong(9, equipo.getId());
			ps.executeUpdate();
			desconectar(con);
			return equipo;
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de modificar equipo ha fallado", e);
		}
	}
	
	
	
	@Override
	public void borrarequipo(Long id) {
		try (Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(DELETE_EQUIPO);) {
			ps.setLong(1, id);

			ps.executeUpdate();
			desconectar(con);
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de borrar equipo ha fallado", e);
		}
		
	}
	
	
	@Override
	public ArrayList<Incidencia> incidenciasTodas() {
		
			try (Connection con = conectar();
					
					
					PreparedStatement ps = con.prepareStatement(SELECT_INCIDENCIAS_TODAS);
					ResultSet rs = ps.executeQuery()) {

				ArrayList<Incidencia> listaincidencias = new ArrayList<>();

				while (rs.next()) {
					listaincidencias.add(new Incidencia(rs.getLong("id"), rs.getString("nombre_equipo"),
							rs.getString("descripcion"),rs.getString("aula"),rs.getString("inicio"),rs.getString("fin"),
							rs.getString("reportado_por"),rs.getString("estado"),rs.getString("resuelto_por")));
					
				}
				desconectar(con);
				System.out.println(listaincidencias);
				return listaincidencias;
			} catch (Exception e) {
				throw new AccesoDatosException("No se han podido obtener todos las incidencias", e);
			}
		}
	@Override
	public  Incidencia incidenciaPorId(Long id) {
		try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(SELECT_INCIDENCIA_ID);) {
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();

			Incidencia incidencia = null;

			if (rs.next()) {
				incidencia = new Incidencia(rs.getLong("id"), rs.getString("nombre_equipo"),
						rs.getString("descripcion"),rs.getString("aula"),rs.getString("inicio"),
						rs.getString("fin"),rs.getString("reportado_por"),rs.getString("estado"), rs.getString("resuelto_por"));;
			}
			desconectar(con);
			return incidencia;
			
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de obtener incidencia por id ha fallado", e);
		}
	}	
	@Override
	public Incidencia insertar(Incidencia incidencia) {
		String fecha = LocalDate.now().toString();
		
		try ( Connection con = conectar();
			
			PreparedStatement ps = con.prepareStatement(INSERT_INCIDENCIA, Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, incidencia.getNombre_equipo());
			ps.setString(2, incidencia.getDescripcion());
			ps.setString(3, incidencia.getAula());
			ps.setString(4, fecha);
			ps.setString(5, incidencia.getReportado_por());
			ps.setString(6, incidencia.getResuelto_por());
			
			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			rs.next();

			incidencia.setId(rs.getLong(1));
			desconectar(con);
			return incidencia;
			
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de insertar incidencia ha fallado", e);
		}
	}

	@Override
	public Incidencia editarIncidencia(Incidencia incidencia) {
		try (Connection con = conectar(); PreparedStatement ps = con.prepareStatement(UPDATE_INCIDENCIA);) {
			
			ps.setString(1, incidencia.getNombre_equipo());
			ps.setString(2, incidencia.getDescripcion());
			ps.setString(3, incidencia.getAula());
			ps.setString(4, incidencia.getInicio());
			ps.setString(5, incidencia.getFin());
			ps.setString(6, incidencia.getReportado_por());
			ps.setString(7, incidencia.getEstado());
			ps.setString(8, incidencia.getResuelto_por());
			ps.setLong(9, incidencia.getId());
			
			ps.executeUpdate();
			desconectar(con);
			return incidencia;
		} catch (Exception e) {
			throw new AccesoDatosException("La operacon de modificar incidencia ha fallado", e);
		}
	}
	@Override
	public void borrarincidencia(Long id) {
		try (Connection con = conectar();
			PreparedStatement ps = con.prepareStatement(DELETE_INCIDENCIA);) {
			ps.setLong(1, id);
			
			ps.executeUpdate();
			desconectar(con);
		} catch (Exception e) {
			throw new AccesoDatosException("La operacion de borrar incidencia ha fallado", e);
		}
		
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Control.ConexionBD;
import Modelo.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jahaziel
 */
public class ConsultasMaterial extends ConexionBD {

	public ArrayList<Material> obtenerListaMateriales() {
		ArrayList<Material> materiales = new ArrayList();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = conectar();

		/*
		**************************Agrega Libros********************************
		 */
		String sql = "SELECT * FROM material WHERE isbn IS NOT NULL";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				int id = Integer.parseInt(rs.getString("id"));
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				int anio = Integer.parseInt(rs.getString("anio"));
				String areaConocimiento = rs.getString("area_conocimiento");
				int numeroEjemplares = Integer.parseInt(rs.getString("numero_ejemplares"));
				String isbn = rs.getString("isbn");

				Material libro = new Libro(id, titulo, autor, anio, areaConocimiento, numeroEjemplares, isbn);
				materiales.add(libro);
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta SELECT de Libro.");
		}
		/*
		*******************************Agrega Revistas***********************
		 */
		sql = "SELECT * FROM MATERIAL WHERE volumen IS NOT NULL AND numero IS NOT NULL";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				int id = Integer.parseInt(rs.getString("id"));
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				int anio = Integer.parseInt(rs.getString("anio"));
				String areaConocimiento = rs.getString("area_conocimiento");
				int numeroEjemplares = Integer.parseInt(rs.getString("numero_ejemplares"));
				int volumen = Integer.parseInt(rs.getString("volumen"));
				int numero = Integer.parseInt(rs.getString("numero"));

				Material revista = new Revista(volumen, numero, id, titulo, autor, anio, areaConocimiento, numeroEjemplares);
				materiales.add(revista);
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta SELECT de Revista.");
			e.printStackTrace();
		}

		/*
		*********************************Agrega enlaces*************************
		 */
		sql = "SELECT * FROM material WHERE pagina_descarga IS NOT NULL AND clave_temporal IS NOT NULL";
		try {
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {

				int id = Integer.parseInt(rs.getString("id"));
				String titulo = rs.getString("titulo");
				String autor = rs.getString("autor");
				int anio = Integer.parseInt(rs.getString("anio"));
				String areaConocimiento = rs.getString("area_conocimiento");
				int numeroEjemplares = Integer.parseInt(rs.getString("numero_ejemplares"));
				String paginaDescarga = rs.getString("pagina_descarga");
				int claveTemporal = Integer.parseInt(rs.getString("clave_temporal"));

				Material me = new MaterialElectronico(paginaDescarga, claveTemporal, id, titulo, autor, anio, areaConocimiento, numeroEjemplares);
				materiales.add(me);
			}
			return materiales;
		} catch (SQLException e) {
			System.out.println("Error en la consulta SELECT de Material Electrónico.");
			e.printStackTrace();
		}
		return null;
	}

}

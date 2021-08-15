/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto5app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import reto5app.model.vo.Requerimiento_2;
import reto5app.util.JDBCUtilities;

public class RequerimientoDao_2 {

    public ArrayList<Requerimiento_2> requerimiento2() throws SQLException{

        ArrayList<Requerimiento_2> respuesta = new ArrayList<Requerimiento_2>();

        // Conexion a la base de datos sqlite
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT p.Fecha_Inicio, p.Ciudad, p.Constructora, " +
                              "l.Nombre || ' ' || l.Segundo_Apellido AS 'nombreLider', " +
                              "t.Codigo_Tipo, t.Estrato " +
                              "FROM Proyecto p INNER JOIN Lider l ON p.ID_Lider = l.ID_Lider " +
                              "INNER JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo " + 
                              "WHERE p.Fecha_Inicio >= '2021-01-01' " +
                              "AND p.Fecha_Inicio <= '2021-05-30' " +
                              "AND p.Ciudad = 'Armenia' ";
                            

            PreparedStatement statement = conexion.prepareStatement(consulta);
            // Almacenados los datos de la consulta.
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Requerimiento_2 requerimiento_2 = new Requerimiento_2(
                        resultSet.getString("Fecha_Inicio"),
                        resultSet.getString("Ciudad"),
                        resultSet.getString("Constructora"),
                        resultSet.getString("nombreLider"),
                        resultSet.getInt("Codigo_Tipo"),
                        resultSet.getInt("Estrato")
                );

                respuesta.add(requerimiento_2);

            }
            
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error en la consulta SQL Requerimiento_2 ->" + e);
        } finally {
            conexion.close();
        }

        return respuesta;
    }
    
    
    public ArrayList<Requerimiento_2> requerimiento2(String fIni, String fFin, String ciu) throws SQLException{

        ArrayList<Requerimiento_2> respuesta = new ArrayList<>();

        // Conexion a la base de datos sqlite
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT p.Fecha_Inicio, p.Ciudad, p.Constructora, " +
                              "l.Nombre || ' ' || l.Segundo_Apellido AS 'nombreLider', " +
                              "t.Codigo_Tipo, t.Estrato " +
                              "FROM Proyecto p INNER JOIN Lider l ON p.ID_Lider = l.ID_Lider " +
                              "INNER JOIN Tipo t ON p.ID_Tipo = t.ID_Tipo " + 
                              "WHERE p.Fecha_Inicio >= '" +fIni+ "' " +
                              "AND p.Fecha_Inicio <= '" +fFin+ "' " +
                              "AND p.Ciudad = '" +ciu+ "' ";
                            

            PreparedStatement statement = conexion.prepareStatement(consulta);
            // Almacenados los datos de la consulta.
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Requerimiento_2 requerimiento_2 = new Requerimiento_2(
                        resultSet.getString("Fecha_Inicio"),
                        resultSet.getString("Ciudad"),
                        resultSet.getString("Constructora"),
                        resultSet.getString("nombreLider"),
                        resultSet.getInt("Codigo_Tipo"),
                        resultSet.getInt("Estrato")
                );

                respuesta.add(requerimiento_2);

            }
            
            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error en la consulta SQL Requerimiento_2 ->" + e);
        } finally {
            conexion.close();
        }

        return respuesta;
    }
    
    
    
    
}
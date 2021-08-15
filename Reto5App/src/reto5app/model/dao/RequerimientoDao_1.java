package reto5app.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import reto5app.model.vo.Requerimiento_1;
import reto5app.util.JDBCUtilities;

public class RequerimientoDao_1 {

    public ArrayList<Requerimiento_1> requerimiento1() throws SQLException{

        // Objeto de tipo lista para cargar los datos de la consulta Requerimiento_1
        ArrayList<Requerimiento_1> respuesta = new ArrayList<Requerimiento_1>();

        // Obtener la conexion de la clase JDBCUtilities.
        Connection conexion = JDBCUtilities.getConnection();

        try {
            String consulta = "SELECT c.Fecha, c.ID_Compra, c.Proveedor, c.Pagado " +
                              "FROM Compra c " +
                              "ORDER BY c.ID_Compra DESC LIMIT 20";

            PreparedStatement statement = conexion.prepareStatement(consulta);
            ResultSet resultSet = statement.executeQuery();

            //Recorrer los registro de la consulta especificos.
            while(resultSet.next()){
                Requerimiento_1 requerimiento_1 = new Requerimiento_1();
                requerimiento_1.setFechaCompra(resultSet.getString("Fecha"));
                requerimiento_1.setCodCompra(resultSet.getInt("ID_Compra"));
                requerimiento_1.setNombreProveedor(resultSet.getString("Proveedor"));
                requerimiento_1.setPagado(resultSet.getString("Pagado"));

                // Se agrega cada registro como un objeto del ArrayList que contiene los registros.
                respuesta.add(requerimiento_1);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e){
            System.err.println("Error de consulta SQL Requerimiento_1 ->" + e);
        } finally{
            if(conexion != null){
                conexion.close();
            }
        }

        return respuesta;
    }
    
}
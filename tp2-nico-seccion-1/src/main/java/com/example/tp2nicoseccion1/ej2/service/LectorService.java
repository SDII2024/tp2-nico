package com.example.tp2nicoseccion1.ej2.service;

import org.springframework.stereotype.Service;
import org.webservicesoap.lector.Lector;
import org.webservicesoap.lector.LectorResponse;

import java.sql.*;
import java.util.logging.Logger;


@Service
public class LectorService {

    String url = "jdbc:sqlite:codigo.db";
    static Logger logger = Logger.getLogger(LectorService.class.getName());

    public LectorService(){
        crearTablaBD();
        insertarProducto(111111111,"Carne",3000);
        insertarProducto(123456789,"Agua",1500);
        insertarProducto(987654321,"Pan",1000);
    }
    public LectorResponse consulta(Lector request){
        LectorResponse LectorResponse = new LectorResponse();
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("SELECT prod,precio FROM productos WHERE nro = ?")) {
            pstmt.setInt(1, request.getCodigo());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                LectorResponse.setProducto(rs.getString("prod"));
                LectorResponse.setPrecio(String.valueOf(rs.getInt("precio")));
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
        return LectorResponse;
    }

    public void crearTablaBD(){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS productos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nro INT NOT NULL,"
                + "prod TEXT NOT NULL,"
                + "precio INT NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            logger.info("Tabla usuarios creada exitosamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    public void insertarProducto(int nro,String prod,int precio) {
        String insertUserSQL = "INSERT INTO productos (nro, prod, precio) VALUES (?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertUserSQL)) {

            // Insertar código en la base de datos
            pstmt.setInt(1, nro);
            pstmt.setString(2, prod);
            pstmt.setInt(3, precio);
            pstmt.executeUpdate();
            logger.info("Codigo insertado correctamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }
}

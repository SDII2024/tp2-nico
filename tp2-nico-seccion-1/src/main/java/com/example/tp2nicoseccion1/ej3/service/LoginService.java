package com.example.tp2nicoseccion1.ej3.service;

import org.springframework.stereotype.Service;
import org.webservicesoap.login.Login;
import org.webservicesoap.login.LoginResponse;

import java.sql.*;
import java.util.logging.Logger;

@Service
public class LoginService {

    String url = "jdbc:sqlite:login.db";
    static Logger logger = Logger.getLogger(LoginService.class.getName());
    public LoginService(){
        crearTablaBD();
        insertarUsuario("usuario1", "contrasena1");
        insertarUsuario("usuario2", "contrasena2");
        insertarUsuario("usuario3", "contrasena3");
    }

    public LoginResponse validar(Login request){
        LoginResponse LoginResponse = new LoginResponse();
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM usuarios WHERE nombre = ? AND contrasena = ?")) {
            pstmt.setString(1, request.getUsuario());
            pstmt.setString(2, request.getPassword());
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                LoginResponse.setStatus(true);
            }
        } catch (SQLException e) {
            logger.info(e.getMessage());
            LoginResponse.setStatus(false);
        }
        return LoginResponse;
    }

    public void crearTablaBD(){
        String createTableSQL = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "contrasena TEXT NOT NULL"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            logger.info("Tabla usuarios creada exitosamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }

    public void insertarUsuario(String nombre, String contrasena) {
        String insertUserSQL = "INSERT INTO usuarios (nombre, contrasena) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(insertUserSQL)) {

            // Insertar usuario y contraseña en la base de datos
            pstmt.setString(1, nombre);
            pstmt.setString(2, contrasena);
            pstmt.executeUpdate();
            logger.info("Usuario insertado correctamente");
        } catch (SQLException e) {
            logger.info(e.getMessage());
        }
    }
}

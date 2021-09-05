package utils;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

import org.json.simple.*;
import org.json.simple.parser.*;

public class ConexionDB {
    
    public static Connection getConexion(){
        JSONParser parser = new JSONParser();
        Connection conn = null;
        try {
            String credentiales = System.getProperty("user.dir") + "/src/utils/credenciales.json";
            JSONObject json = (JSONObject)parser.parse(new FileReader(credentiales));
            
            String ip = (String)json.get("ip");
            String puerto = (String)json.get("puerto");
            String usuario = (String)json.get("usuario");
            String contraseña = (String)json.get("contraseña");
            String url = "jdbc:mysql://"+ip+":"+puerto+"/todo_lo_bueno";

            conn = DriverManager.getConnection(url, usuario, contraseña);

            if (conn != null) {
                System.out.println("conectado");
            }
            
        } catch (Exception e) {
        }

        return conn;
    } 
    public static void main(String[] args) {
        getConexion();
    }
}
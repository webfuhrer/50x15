/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg50x15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mañanas
 */
class AccesoBD {
    static String usuario="root";
    static String password="";
    static String url="jdbc:mysql://localhost:3306/bd_concurso";

    public static void crearTabla()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
        String query_crea_t_preguntas="CREATE TABLE  if not exists t_preguntas "
                + "( enunciado varchar(50), resp_a varchar(20),"
                + " resp_b varchar(20), resp_c varchar(20),"
                + " resp_d varchar(20), resp_correcta varchar(20) )";
        String query_crea_ranking="create table  if not exists ranking\n" +
"(\n" +
"    nombre varchar(15),\n" +
"    puntuacion int(3)\n" +
"    )";
        Properties info=new Properties();
                info.setProperty("user", usuario);
                info.setProperty("password",password);
                try {
                    Connection conexion=DriverManager.getConnection(url, info);
                    Statement stmt=conexion.createStatement();
                    stmt.executeUpdate(query_crea_t_preguntas);
                    stmt.executeUpdate(query_crea_ranking);
                    stmt.close();
                    conexion.close();
                } catch (SQLException ex) {
                    Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
                }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static void insertarPregunta(Pregunta p) {
        String sql="INSERT INTO t_preguntas VALUES(\""+p.getEnunciado()+"\","
                + " \""+p.getResp_a()+"\", \""+p.getResp_b()+"\", "
                + "\""+p.getResp_c()+"\", \""+p.getResp_d()+"\", \""+p.getResp_correcta()+"\");";
        try {
            Connection conexion=DriverManager.getConnection(url, usuario, password);
            Statement stmt=conexion.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

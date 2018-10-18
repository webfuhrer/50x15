/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg50x15;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static ArrayList<Pregunta> recuperarPreguntas() {
        ArrayList<Pregunta> lista_preguntas=new ArrayList();
        try {
            Connection conexion=DriverManager.getConnection(url, usuario, password);
            Statement stmt=conexion.createStatement();
            String query="SELECT * FROM t_preguntas";
            ResultSet rs=stmt.executeQuery(query);
            
            while(rs.next())
            {
                String enunciado=rs.getString("enunciado");
                String resp_a=rs.getString("resp_a");
                String resp_b=rs.getString("resp_b");
                String resp_c=rs.getString("resp_c");
                String resp_d=rs.getString("resp_d");
                String resp_correcta=rs.getString("resp_correcta");
                Pregunta p=new Pregunta(enunciado, resp_a, resp_b, resp_c, resp_d, resp_correcta);
                lista_preguntas.add(p);
                
            }
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista_preguntas;
    }

    static void grabarRanking(Ranking r) {
       String sql="INSERT INTO ranking VALUES('"+r.getNombre()+"', '"+r.getAciertos()+"')";
        System.out.println(sql);
        
        try {
            Connection conexion=DriverManager.getConnection(url, usuario, password);
            Statement stmt=conexion.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static ArrayList<Ranking> recuperarRanking() {
        ArrayList<Ranking> lista_puntuaciones=new ArrayList();
        try {
            Connection conexion=DriverManager.getConnection(url, usuario, password);
            Statement stmt=conexion.createStatement();
            String query="SELECT * FROM ranking ORDER BY puntuacion DESC";
            ResultSet rs=stmt.executeQuery(query);
            
            while(rs.next())
            {
                String nombre=rs.getString("nombre");
                int puntuacion=rs.getInt("puntuacion");
                Ranking r=new Ranking(nombre, puntuacion);
                lista_puntuaciones.add(r);
                
            }
            stmt.close();
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
     return lista_puntuaciones;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg50x15;

import java.util.ArrayList;

/**
 *
 * @author Mañanas
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String nombre=EntradaSalida.pedirNombre();
        int opcion=EntradaSalida.pedirMenu();
        AccesoBD.crearTabla();
      while(opcion!=4)
        {
            switch(opcion)
            {
                case 1:
                    //Insertar pregunta
                    Pregunta p=EntradaSalida.pedirDatosPregunta();
                    AccesoBD.insertarPregunta(p);
                    break;
                case 2:
                    //Jugar
                    int aciertos=0;
                    
                    ArrayList<Pregunta> lista_preguntas=AccesoBD.recuperarPreguntas();
                    for (int i=0; i<lista_preguntas.size(); i++)
                    {
                        Pregunta pregunta=lista_preguntas.get(i);
                        String repuesta_usur=EntradaSalida.hacerPregunta(pregunta);
                        if(repuesta_usur.equalsIgnoreCase(pregunta.getResp_correcta()))
                        {
                            
                            aciertos++;
                        }
                    }
                   Ranking r=new Ranking(nombre, aciertos);
                   AccesoBD.grabarRanking(r);
                    break;
                case 3:
                    //Ver ranking
                    ArrayList<Ranking> lista_puntuaciones=AccesoBD.recuperarRanking();
                    EntradaSalida.mostrarRanking(lista_puntuaciones);
                    break;
                    
            }
            opcion=EntradaSalida.pedirMenu();
        }
       
        
    }
    
}

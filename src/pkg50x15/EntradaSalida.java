/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg50x15;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mañanas
 */
class EntradaSalida {
static Scanner sc=new Scanner(System.in);
    static int pedirMenu() {
        System.out.println("1-Insertar pregunta");
        System.out.println("2-Jugar");
        System.out.println("3-Ver renking");
        System.out.println("4-SALIR");
        int opcion=sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    static String pedirNombre() {
        System.out.println("Introduzca su nombre");
        String nombre=sc.nextLine();
        return nombre;
    }

    static Pregunta pedirDatosPregunta() {
        System.out.println("Enunciado:");
        String enunciado=sc.nextLine();
        System.out.println("Opción a:");
        String op_a=sc.nextLine();
        System.out.println("Opción b:");
        String op_b=sc.nextLine();
        System.out.println("Opción c:");
        String op_c=sc.nextLine();
        System.out.println("Opción d:");
        String op_d=sc.nextLine();
        System.out.println("Respuesta correcta:");
        String resp_correcta=sc.nextLine();
        Pregunta p=new Pregunta(enunciado, op_a, op_b, op_c, op_d, resp_correcta);
        return p;
    }

    static String hacerPregunta(Pregunta pregunta) {
        System.out.println(pregunta.getEnunciado());
        System.out.println("a)"+pregunta.getResp_a());
        System.out.println("b)"+pregunta.getResp_b());
        System.out.println("c)"+pregunta.getResp_c());
        System.out.println("d)"+pregunta.getResp_d());
        String respuesta_usur=sc.nextLine();
        return respuesta_usur;
    }

    public static void mostrarRanking(ArrayList<Ranking> lista) {
        //¿Donde esta el ranking?
         System.out.println("**********\t\t**********");
            System.out.println("NOMBRE\t\tPUNTOS");
            System.out.println("**********\t\t**********");
        for(int i=0; i<lista.size(); i++)
        {  
            System.out.println(lista.get(i).getNombre()+"\t\t"+lista.get(i).getAciertos());
        }
    }
    
}

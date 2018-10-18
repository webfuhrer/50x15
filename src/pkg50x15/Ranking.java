/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg50x15;

/**
 *
 * @author Mañanas
 */
class Ranking {
private String nombre;
private int aciertos;
    Ranking(String nombre, int aciertos) {
        this.nombre=nombre;
        this.aciertos=aciertos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }
    
}

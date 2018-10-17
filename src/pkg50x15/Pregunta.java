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
public class Pregunta {
    private String enunciado, resp_a, resp_b, resp_c, resp_d, resp_correcta;

    public Pregunta(String enunciado, String resp_a, String resp_b, String resp_c, String resp_d, String resp_correcta) {
        this.enunciado = enunciado;
        this.resp_a = resp_a;
        this.resp_b = resp_b;
        this.resp_c = resp_c;
        this.resp_d = resp_d;
        this.resp_correcta = resp_correcta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getResp_a() {
        return resp_a;
    }

    public String getResp_b() {
        return resp_b;
    }

    public String getResp_c() {
        return resp_c;
    }

    public String getResp_d() {
        return resp_d;
    }

    public String getResp_correcta() {
        return resp_correcta;
    }
    
    
}

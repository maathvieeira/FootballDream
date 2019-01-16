package br.com.generationz.footballdream;

import java.util.Date;

public class Game {

    int id;
    String time1;
    String time2;
    String estadio;
    String data;
    String idCampeonato;
    String idCanal;
    String canal2;
    String canal3;

    public Game(int id, String time1, String time2, String estadio, String data, String idCampeonato, String idCanal, String canal2, String canal3) {
        this.id = id;
        this.time1 = time1;
        this.time2 = time2;
        this.estadio = estadio;
        this.data = data;
        this.idCampeonato = idCampeonato;
        this.idCanal = idCanal;
        this.canal2 = canal2;
        this.canal3 = canal3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdCampeonato() {
        return idCampeonato;
    }

    public void setIdCampeonato(String idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    public String getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(String idCanal) {
        this.idCanal = idCanal;
    }

    public String getCanal2() {
        return canal2;
    }

    public void setCanal2(String canal2) {
        this.canal2 = canal2;
    }

    public String getCanal3() {
        return canal3;
    }

    public void setCanal3(String canal3) {
        this.canal3 = canal3;
    }
}

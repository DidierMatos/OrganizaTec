package com.example.kys.organizatec;

import java.io.Serializable;

/**
 * Created by didie on 14/03/2018.
 */

public class ClsInfoLogin implements Serializable{

    private Integer id;
    private String unidad;
    private String carrera;
    private String semestre;
    private String grupo;

    public ClsInfoLogin(Integer id, String unidad, String carrera, String semestre, String grupo) {
        this.id = id;
        this.unidad = unidad;
        this.carrera = carrera;
        this.semestre = semestre;
        this.grupo = grupo;
    }

    public ClsInfoLogin(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}

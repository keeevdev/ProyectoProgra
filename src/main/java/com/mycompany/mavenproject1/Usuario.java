/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author Kevin
 */
public class Usuario {
    private String nombre;
    private String apellidos;
    private String usuario;
    private String password;
    private boolean estadoActivo;
    private String correo;

    // Constructor
    public Usuario(String nombre, String apellidos, String usuario, String password, boolean estadoActivo, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
        this.estadoActivo = estadoActivo;
        this.correo = correo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEstadoActivo() {
        return estadoActivo;
    }

    public String getCorreo() {
        return correo;
    }
}

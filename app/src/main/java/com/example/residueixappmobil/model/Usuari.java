package com.example.residueixappmobil.model;

import java.io.Serializable;

/**
 * Classe Usuari que conté totes les carcterístiques de l'usuari loginat.
 *
 * @author Daniel Garcia Ruiz
 */
public class Usuari implements Serializable {

    // Atributs
    /**
     * Id de l'usuari
     */
    private int id;
    /**
     * tipus d'usuari
     */
    private int tipus;
    /**
     * email / usari
     */
    private String email;
    /**
     * paraula clau de l'usuari
     */
    private String password;
    /**
     * nom de l'usuari
     */
    private String nom;
    /**
     * Cognom 1 de l'usari
     */
    private String cognom1;
    /**
     * Cognom 2 de l'usuari
     */
    private String cognom2;
    /**
     * Telèfon de l'usuari
     */
    private String telefon;
    /**
     * Token per aquest usuari
     */
    private String token;

    /**
     * Crea una nova instància de la classe usuari
     *
     * @param id       (int) id usari
     * @param tipus    (int) tipus usuari
     * @param email    (String) email usuari
     * @param password (String) password usuari
     * @param nom      (String) nom usuari
     * @param cognom1  (String) cognom1 usuari
     * @param cognom2  (String) cognom2 usuari
     * @param telefon  (String) telefon usuari
     */
    public Usuari(int id, int tipus, String email, String password, String nom, String cognom1, String cognom2, String telefon, String token) {

        this.id = id;
        this.tipus = tipus;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.telefon = telefon;
        this.token = token;

    }

    public Usuari() {
        this.id = 0;
        this.tipus = 0;
        this.email = "";
        this.password = "";
        this.nom = "";
        this.cognom1 = "0";
        this.cognom2 = "";
        this.telefon = "";
        this.token = "";
    }


    // Getters

    /**
     * Retorna id de l'usuari
     *
     * @return id usuari (int)
     */
    public int getId() {
        return this.id;
    }

    /**
     * Retorna el tipus d'uuari.
     *
     * @return tipus usuari. (int)
     */
    public int getTipus() {
        return this.tipus;
    }

    /**
     * Retorna el email de l'usuari. (usuari propiament)
     *
     * @return email usuari. (String)
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Retorna el password de l'usuari.
     *
     * @return password usuari. (String)
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Retorna el nom de l'usuari.
     *
     * @return nom del usari. (String)
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Retorna el cognom 1 de l'usuari.
     *
     * @return cognom usuari (String)
     */
    public String getCognom1() {
        return this.cognom1;
    }

    /**
     * Retorna el cognom2 de l'usuari.
     *
     * @return cognom2 usuari (String)
     */
    public String getCognom2() {
        return this.cognom2;
    }

    /**
     * Retorna el telèfon de l'usuari.
     *
     * @return telèfon usuari (String)
     */
    public String getTelefon() {
        return this.telefon;
    }

    /**
     * Retorna el token de l'usuari.
     *
     * @return token usuari (String)
     */
    public String getToken() {
        return this.token;
    }

    // Setters

    /**
     * Modifica el id de l'usuari.
     *
     * @param nouId (int)
     */
    public void setId(int nouId) {
        this.id = nouId;
    }

    /**
     * Modifica el tipus de l'usuari.
     *
     * @param nouTipus (int)
     */
    public void setTipus(int nouTipus) {
        this.tipus = nouTipus;
    }

    /**
     * Modifica el email de l'usuari.
     *
     * @param nouEmail (String)
     */
    public void setEmail(String nouEmail) {
        this.email = nouEmail;
    }

    /**
     * Modifica el password de l'usuari.
     *
     * @param nouPassword (String)
     */
    public void setPassword(String nouPassword) {
        this.password = nouPassword;
    }

    /**
     * Modifica el nom de l'usuari.
     *
     * @param nouNom (String)
     */
    public void setNom(String nouNom) {
        this.nom = nouNom;
    }

    /**
     * Modifica el cognom1 de l'usuari.
     *
     * @param nouCognom1 (String)
     */
    public void setCognom1(String nouCognom1) {
        this.cognom1 = nouCognom1;
    }

    /**
     * Modifica el cognom2 de l'usuari.
     *
     * @param nouCognom2 (String)
     */
    public void setCognom2(String nouCognom2) {
        this.cognom2 = nouCognom2;
    }

    /**
     * Modifica el telèfon de l'usuari.
     *
     * @param nouTelefon (String)
     */
    public void setTelefon(String nouTelefon) {
        this.telefon = nouTelefon;
    }

    /**
     * Modifica el token de l'usuari.
     *
     * @param nouToken (String)
     */
    public void setToken(String nouToken) {
        this.token = nouToken;
    }


}
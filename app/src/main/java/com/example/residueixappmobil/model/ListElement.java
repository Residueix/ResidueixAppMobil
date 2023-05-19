package com.example.residueixappmobil.model;
/**
 * Classe model ListElement que representa cada un dels elements d'un ReciclerView amb les seves caracteristiques individuals
 *
 * @author Albert Montes Miracle
 */
public class ListElement {
    String nom;
    String descripcio;
    double valor;
    int tipus;

    public ListElement(String nom, String descripcio, double valor, int tipus) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.valor = valor;
        this.tipus = tipus;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTipus() {
        return tipus;
    }

    public void setTipus(int tipus) {
        this.tipus = tipus;
    }
}

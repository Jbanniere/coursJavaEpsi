package fr.epsi.jdbc.entites;

import fr.epsi.jdbc.dal.FournisseurDAO;

public class Fournisseur {
    private int id;
    private String nom;
    public Fournisseur(){
    }
    public Fournisseur(Integer id){
        this.id = id;
    }
    public Fournisseur(String nom) {
        this.nom = nom;
    }
    public Fournisseur(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fournisseur{");
        sb.append("id=").append(id);
        sb.append(", nom='").append(nom).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

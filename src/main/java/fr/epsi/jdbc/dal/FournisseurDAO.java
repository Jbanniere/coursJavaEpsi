package fr.epsi.jdbc.dal;

import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface FournisseurDAO {
    void insert(Fournisseur fournisseurACreer) throws Exception; // on aurait pu mettre SQLException mais on met une classe plus large pour covurir plus d'erreurs
    int update(String ancienNom, String nouveauNom) throws Exception;
    boolean delete(Fournisseur fournisseurASupprimer) throws Exception;
    List<Fournisseur> extraire() throws Exception;
}

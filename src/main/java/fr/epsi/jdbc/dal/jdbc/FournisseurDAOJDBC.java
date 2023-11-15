package fr.epsi.jdbc.dal.jdbc;

import fr.epsi.jdbc.dal.FournisseurDAO;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.TestConnexionJdbc.*;

public class FournisseurDAOJDBC implements FournisseurDAO {
    private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES(?)";
    private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = ? WHERE NOM = ?";
    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = ?";
    @Override
    public void insert(Fournisseur fournisseurACreer) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP); PreparedStatement insertFo = conn.prepareStatement(INSERT_QUERY)) {
            insertFo.setString(1, fournisseurACreer.getNom());
            insertFo.executeUpdate();
        }
    }
    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP) ; PreparedStatement updateFo = conn.prepareStatement(UPDATE_QUERY)) {
            updateFo.setString(1,nouveauNom);
            updateFo.setString(2, ancienNom);
            int nb = updateFo.executeUpdate();
            return nb;
        }
    }
    @Override
    public boolean delete(Fournisseur fournisseurASupprimer) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP) ; PreparedStatement deleteFo = conn.prepareStatement(DELETE_QUERY)) {
            deleteFo.setString(1,fournisseurASupprimer.getNom());
            int nb = deleteFo.executeUpdate();
            return nb > 0;
        }
    }
    @Override
    public List<Fournisseur> extraire() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP);
             PreparedStatement selectFo = conn.prepareStatement("SELECT * FROM FOURNISSEUR");
             ResultSet curseur = selectFo.executeQuery()) {

            List<Fournisseur> fournisseurList = new ArrayList<>();

            while(curseur.next()) {
                fournisseurList.add(new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM")));
            }
            return fournisseurList;
        }
    }
}

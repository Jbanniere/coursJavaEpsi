package fr.epsi.jdbc.dal.jdbc;

import fr.epsi.jdbc.dal.FournisseurDAO;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.TestConnexionJdbc.*;

public class FournisseurDAOJDBC implements FournisseurDAO {
    private static final String INSERT_QUERY = "INSERT INTO FOURNISSEUR (NOM) VALUES('%s')"; // %s pour les String / %d
    private static final String UPDATE_QUERY = "UPDATE FOURNISSEUR SET NOM = '%s' WHERE NOM = '%s'";
    private static final String DELETE_QUERY = "DELETE FROM FOURNISSEUR WHERE NOM = '%S'";
    @Override
    public void insert(Fournisseur fournisseurACreer) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP); Statement monStatement = connection.createStatement()) {
            monStatement.executeUpdate(String.format(INSERT_QUERY, fournisseurACreer.getNom())); // va remplacer les %s par la chaîne fournisseurACreer.getNom()
        }
    }
    @Override
    public int update(String ancienNom, String nouveauNom) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP) ; Statement monStatement = connection.createStatement()) {
            int nb = monStatement.executeUpdate(String.format(UPDATE_QUERY, nouveauNom, ancienNom));
            return nb;
        }
    }
    @Override
    public boolean delete(Fournisseur fournisseurASupprimer) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP) ; Statement monStatement = connection.createStatement()) {
            int nb = monStatement.executeUpdate(String.format(DELETE_QUERY, fournisseurASupprimer.getNom()));
            return nb > 0;
        }
    }
    @Override
    public List<Fournisseur> extraire() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_MDP);
             Statement monStatement = connection.createStatement();
             ResultSet curseur = monStatement.executeQuery("SELECT * FROM FOURNISSEUR")) {

            List<Fournisseur> fournisseurList = new ArrayList<>();

            while(curseur.next()) {
                fournisseurList.add(new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM")));
            }
            return fournisseurList;
        }
    }


}

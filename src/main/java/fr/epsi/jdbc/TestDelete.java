package fr.epsi.jdbc;
import fr.epsi.jdbc.dal.FournisseurDAO;
import fr.epsi.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.example.TestConnexionJdbc.*;


public class TestDelete {
    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurDAOJDBC();
        try {
            dao.delete(new Fournisseur("EPSI-2"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

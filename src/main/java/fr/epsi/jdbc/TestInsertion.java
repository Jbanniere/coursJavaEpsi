package fr.epsi.jdbc;
import fr.epsi.jdbc.dal.FournisseurDAO;
import fr.epsi.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.epsi.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static org.example.TestConnexionJdbc.*;

public class TestInsertion {
    public static void main(String[] args){
        FournisseurDAO dao = new FournisseurDAOJDBC();
        try {
            dao.insert(new Fournisseur("L'EPSI")); // avec cette méthode, les noms avec ' peuvent être inséré
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

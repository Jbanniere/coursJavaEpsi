package fr.epsi.jdbc;
import fr.epsi.jdbc.dal.FournisseurDAO;
import fr.epsi.jdbc.dal.jdbc.FournisseurDAOJDBC;
import fr.epsi.jdbc.entites.Fournisseur;
import java.util.*;

import java.sql.*;

import static org.example.TestConnexionJdbc.*;

public class TestSelect {
    public static void main(String[] args) {
        FournisseurDAO dao = new FournisseurDAOJDBC();
        try {
            List<Fournisseur> fournisseurList = dao.extraire();
            fournisseurList.forEach(System.out::println);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            /*for(Fournisseur fournisseur : fournisseurList) {
                System.out.println(fournisseur);
            }*/
            //fournisseurList.forEach(System.out::println); --> identique au foreach du dessus
        }
}

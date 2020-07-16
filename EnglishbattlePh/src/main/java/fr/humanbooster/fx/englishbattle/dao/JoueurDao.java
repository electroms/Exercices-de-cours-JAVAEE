package fr.humanbooster.fx.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Joueur;

public interface JoueurDao {
    Joueur create(Joueur joueur) throws SQLException;

    Joueur findOne(Long id) throws SQLException;

    Joueur findOne(String mail, String mdp) throws SQLException;

    List<Joueur> findAll() throws SQLException;

    Joueur update(Joueur joueur) throws SQLException;

    boolean delete(Long id) throws SQLException;
}

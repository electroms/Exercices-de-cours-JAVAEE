package fr.humanbooster.fx.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Partie;

public interface PartieDao {

    Partie create(Partie partie) throws SQLException;

    Partie findOne(Long id) throws SQLException;

    List<Partie> findAll() throws SQLException;

    boolean delete(Long id) throws SQLException;

}

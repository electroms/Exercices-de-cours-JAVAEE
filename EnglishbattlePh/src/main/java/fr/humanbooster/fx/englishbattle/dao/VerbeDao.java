package fr.humanbooster.fx.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Verbe;

public interface VerbeDao {

    Verbe create(Verbe verbe) throws SQLException;

    List<Verbe> findAll() throws SQLException;
    
    Verbe findAleatoire() throws SQLException;

    Verbe findOne(Long idVerbe) throws SQLException;
    
    Verbe update(Verbe verbe) throws SQLException;

    boolean delete(Long idVerbe) throws SQLException;

}

package fr.humanbooster.fx.englishbattle.dao;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Ville;

public interface VilleDao {
    
    Ville create(Ville ville) throws SQLException;
    
    Ville findOne (Long id) throws SQLException;
    
    List<Ville> findAll () throws SQLException;
    
    Ville update(Ville ville)throws SQLException;
    
    boolean delete(Long id)throws SQLException;
    
    

}
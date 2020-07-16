package fr.humanbooster.ph.autoroute.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.ph.autoroute.business.Tarif;
import fr.humanbooster.ph.autoroute.dao.ClasseDao;
import fr.humanbooster.ph.autoroute.dao.ConnexionBdd;
import fr.humanbooster.ph.autoroute.dao.PeageDao;
import fr.humanbooster.ph.autoroute.dao.Requetes;
import fr.humanbooster.ph.autoroute.dao.TarifDao;

public class TarifDaoImpl implements TarifDao {

	//La DAO a besoin d'une connexion à la base
	private Connection connexion;
	private ClasseDao classeDao;
	private PeageDao peageDao;
	
	public TarifDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
			classeDao = new ClasseDaoImpl();
			peageDao = new PeageDaoImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Tarif create(Tarif tarif) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_TARIF, Statement.RETURN_GENERATED_KEYS);
		ps.setFloat(1, tarif.getMontant());
		ps.setTimestamp(2, new Timestamp(tarif.getDateEffet().getTime()));
		ps.setLong(3, tarif.getClasse().getId());
		ps.setLong(4, tarif.getPeageEntree().getId());
		ps.setLong(5, tarif.getPeageSortie().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		tarif.setId(rs.getLong(1));
		return tarif;
	}

	@Override
	public Tarif findOne(Long id) throws SQLException {
		Tarif tarif = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.TARIF_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			//On utilise le patron DAO qui consiste  faire appel à un objet DAO dans une classe DAO
			tarif = new Tarif(rs.getLong("id"), rs.getLong("id"), rs.getDate("dateEffet"), 
						classeDao.findOne(rs.getLong("classe_id")), peageDao.findOne(rs.getLong("peage_entree_id")), 
							peageDao.findOne(rs.getLong("peage_entree_id")));
		}
		return tarif;
	}
	
	@Override
	public List<Tarif> findAll() throws SQLException { 
		List<Tarif> tarifs = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_TARIFS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Tarif tarif = new Tarif();
			tarif = new Tarif();
			tarif.setId(rs.getLong("id"));
			tarif.setMontant(rs.getFloat("montant"));
			tarif.setDateEffet(rs.getDate("dateEffet"));
			//On utilise le patron DAOqui consiste  faire appel à un objet DAO dans une classe DAO
			tarif.setClasse(classeDao.findOne(rs.getLong("classe_id")));
			tarif.setPeageEntree(peageDao.findOne(rs.getLong("peage_entree_id")));
			tarif.setPeageSortie(peageDao.findOne(rs.getLong("peage_entree_id")));
			tarifs.add(tarif);
		}
		return tarifs;
	}

	@Override
	public List<Tarif> findAllByIdPeageDepart(Long idPeage) throws SQLException { 
		List<Tarif> tarifs = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUS_LES_TARIFS_BY_ID);
		ps.setLong(1, idPeage);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Tarif tarif = new Tarif();
			tarif = new Tarif();
			tarif.setId(rs.getLong("id"));
			tarif.setMontant(rs.getFloat("montant"));
			tarif.setDateEffet(rs.getDate("dateEffet"));
			//On utilise le patron DAOqui consiste  faire appel à un objet DAO dans une classe DAO
			tarif.setClasse(classeDao.findOne(rs.getLong("classe_id")));
			tarif.setPeageEntree(peageDao.findOne(rs.getLong("peage_entree_id")));
			tarif.setPeageSortie(peageDao.findOne(rs.getLong("peage_entree_id")));
			tarifs.add(tarif);
		}
		return tarifs;
	}
	
	@Override
	public Tarif update(Tarif tarif) throws SQLException{
		PreparedStatement ps = connexion.prepareStatement(Requetes.MAJ_TARIF);		
		ps.setFloat(1, tarif.getMontant());
		ps.setLong(2, tarif.getId());
		ps.executeUpdate();	
		return tarif;
	}
	
	@Override
	public boolean delete(Long id) throws SQLException {
		if (findOne(id)==null) return false;
		PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_TARIF);
		ps.setLong(1, id);
		ps.executeUpdate();			
		return true;
	}

	protected void finalize() throws Throwable {
		connexion.close();
	}
}

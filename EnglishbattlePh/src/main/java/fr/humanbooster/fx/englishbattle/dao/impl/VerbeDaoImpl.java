package fr.humanbooster.fx.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.dao.ConnexionBdd;
import fr.humanbooster.fx.englishbattle.dao.Requetes;
import fr.humanbooster.fx.englishbattle.dao.VerbeDao;

public class VerbeDaoImpl implements VerbeDao {

	private Connection connection;

	public VerbeDaoImpl() {
		try {
			this.connection = ConnexionBdd.getConnection();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Verbe create(Verbe verbe) throws SQLException {

		java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.AJOUT_VERBE,
				Statement.RETURN_GENERATED_KEYS);
		// on remplace le premier ? par la baseVerbale
		ps.setString(1, verbe.getBaseVerbale());

		// on remplace le 2eme ? par le preterit
		ps.setString(3, verbe.getPreterit());

		// on remplace le 3eme ? par le participePasse
		ps.setString(2, verbe.getParticipePasse());

		// on remplace le 4eme ? par la taduction
		ps.setString(4, verbe.getTraduction());

		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();

		// on definit l'id du verbe avec ce que mySQL a choisi comme id pour
		// l'enregistrement
		verbe.setId(rs.getLong(1));
		return verbe;
	}

	@Override
	public List<Verbe> findAll() throws SQLException {

		List<Verbe> verbes = new ArrayList<>();
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(Requetes.TOUS_LES_VERBES);
		while (rs.next()) {
			Verbe verbe = new Verbe();
			verbe.setId(rs.getLong(1));
			verbe.setBaseVerbale(rs.getString(2));
			verbe.setPreterit(rs.getString(4));
			verbe.setParticipePasse(rs.getString(3));
			verbe.setTraduction(rs.getString(5));
			verbes.add(verbe);
		}
		return verbes;

	}

	public Verbe findAleatoire() throws SQLException {
		Verbe verbe = null;
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(Requetes.TOUS_LES_VERBES_ALEATOIRE);
		if (rs.next()) {
			verbe = new Verbe();
			verbe.setId(rs.getLong(1));
			verbe.setBaseVerbale(rs.getString(2));
			verbe.setPreterit(rs.getString(4));
			verbe.setParticipePasse(rs.getString(3));
			verbe.setTraduction(rs.getString(5));

		}
		return verbe;

	}

	@Override
	public Verbe findOne(Long idVerbe) throws SQLException {

		PreparedStatement ps = connection.prepareStatement(Requetes.VERBE_PAR_ID);
		ps.setLong(1, idVerbe);
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			Verbe verbe = new Verbe();
			verbe.setId(rs.getLong(1));
			verbe.setBaseVerbale(rs.getString(2));
			verbe.setPreterit(rs.getString(4));
			verbe.setParticipePasse(rs.getString(3));
			verbe.setTraduction(rs.getString(5));

			return verbe;
		}
		return null;
	}

	@Override
	public Verbe update(Verbe verbe) throws SQLException {

		if (findOne(verbe.getId()) != null) {
			java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.MODIFICATION_VERBE);
			ps.setString(1, verbe.getBaseVerbale());
			ps.setString(2, verbe.getParticipePasse());
			ps.setString(3, verbe.getPreterit());
			ps.setString(4, verbe.getTraduction());
			ps.setLong(5, verbe.getId());
			ps.executeUpdate();			
		}
		return null;
	}

	@Override
	public boolean delete(Long idVerbe) throws SQLException {

		if (findOne(idVerbe) != null) {
			java.sql.PreparedStatement ps = connection.prepareStatement(Requetes.SUPPRESSION_VERBE);
			ps.setLong(1, idVerbe);
			ps.executeUpdate();
			return true;
		}
		return false;
	}

}

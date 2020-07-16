package fr.humanbooster.fx.englishbattle.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import fr.humanbooster.fx.englishbattle.business.Verbe;
import fr.humanbooster.fx.englishbattle.dao.VerbeDao;
import fr.humanbooster.fx.englishbattle.dao.impl.VerbeDaoImpl;
import fr.humanbooster.fx.englishbattle.service.VerbeService;

public class VerbeServiceImpl implements VerbeService {

	private VerbeDao verbeDao = new VerbeDaoImpl();

	@Override
	public Verbe ajouterVerbe(String baseVerbal, String preterit, String participePasse, String traduction) {
		Verbe verbe = new Verbe(baseVerbal, preterit, participePasse, traduction);
		try {
			return verbeDao.create(verbe);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return verbe;
	}

	@Override
	public void ajouterVerbesInitiaux() {
		try {
			if (verbeDao.findAll().isEmpty()) {
				importerVerbes();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Verbe> recupererVerbes() {
		try {
			return verbeDao.findAll();
		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Verbe recupererVerbe(Long id) {

		try {
			return verbeDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Verbe recupererVerbeAleatoire() {
		try {
			return verbeDao.findAleatoire();

		} catch (SQLException e) {
			System.out.println(e);
			return null;
		}

	}

	@Override
	public void importerVerbes() {
		URL url = null;
		CSVParser parser = null;
		try {
			url = new URL("https://www.clelia.fr/Battle/englishbattle161.csv");
			final Reader reader = new BufferedReader(new InputStreamReader(url.openStream()));
			parser = new CSVParser(reader, CSVFormat.EXCEL);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		for (final CSVRecord record : parser) {
			String baseVerbale = record.get(1);
			String preterit = record.get(3);
			String participePasse = record.get(2);
			String traduction = record.get(4);

			ajouterVerbe(baseVerbale, preterit, participePasse, traduction);

		}
	}

	@Override
	public boolean supprimerVerbe(Long id) {
		try {
			verbeDao.delete(id);
			return true;
		} catch (SQLException e) {
			System.out.println(e);
			return false;
		}
	}

}
package fr.humanbooster.fx.englishbattle.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.dao.ConnexionBdd;
import fr.humanbooster.fx.englishbattle.dao.PartieDao;
import fr.humanbooster.fx.englishbattle.dao.QuestionDao;
import fr.humanbooster.fx.englishbattle.dao.Requetes;
import fr.humanbooster.fx.englishbattle.dao.VerbeDao;

public class QuestionDaoImpl implements QuestionDao {
	private Connection connexion;
	private PartieDao partieDao;
	private VerbeDao verbeDao;

	public QuestionDaoImpl() {
		try {
			connexion = ConnexionBdd.getConnection();
			partieDao = new PartieDaoImpl();
			verbeDao = new VerbeDaoImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Question create(Question question) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.AJOUT_QUESTION, Statement.RETURN_GENERATED_KEYS);
		ps.setLong(1, question.getPartie().getId());
		ps.setLong(2, question.getVerbe().getId());
		ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		rs.next();
		question.setId(rs.getLong(1));
		return question;
	}

	@Override
	public Question findOne(Long id) throws SQLException {
		Question question = null;
		PreparedStatement ps = connexion.prepareStatement(Requetes.QUESTION_PAR_ID);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			question = new Question(partieDao.findOne(rs.getLong("partie_id")),
					verbeDao.findOne(rs.getLong("verbe_id")));
		}
		return question;
	}

	@Override
	public List<Question> findAll() throws SQLException {
		List<Question> questions = new ArrayList<>();
		PreparedStatement ps = connexion.prepareStatement(Requetes.TOUTES_LES_QUESTIONS);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Question question = new Question();
			question.setId(rs.getLong("id"));
			question.setDateEnvoi(rs.getDate("dateEnvoi"));
			question.setDateReponse(rs.getDate("dateReponse"));
			question.setReponseParticipePasse(rs.getString("reponseParticipePasse"));
			question.setReponsePreterit(rs.getString("reponsePreterit"));
			question.setPartie(partieDao.findOne(rs.getLong("partie_id")));
			question.setVerbe(verbeDao.findOne(rs.getLong("verbe_id")));

			questions.add(question);

		}

		return questions;
	}

	@Override
	public boolean delete(Long id) throws SQLException {
		if (findOne(id) == null)
			return false;
		PreparedStatement ps = connexion.prepareStatement(Requetes.SUPPRESSION_QUESTION);
		ps.setLong(1, id);
		ps.executeUpdate();
		return true;
	}

	@Override
	public Question update(Question question) throws SQLException {
		PreparedStatement ps = connexion.prepareStatement(Requetes.MODIFICATION_QUESTION);
		ps.setString(1, question.getReponseParticipePasse());
		ps.setString(2, question.getReponsePreterit());
		ps.setLong(3, question.getId());
		ps.executeUpdate();
		return question;
	}

}

package fr.humanbooster.fx.englishbattle.service.impl;

import java.sql.SQLException;
import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Question;
import fr.humanbooster.fx.englishbattle.dao.QuestionDao;
import fr.humanbooster.fx.englishbattle.dao.impl.QuestionDaoImpl;
import fr.humanbooster.fx.englishbattle.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

	private QuestionDao questionDao = new QuestionDaoImpl();

	@Override
	public Question ajouterQuestion(Question question) {
		try {
			return questionDao.create(question);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Question recupererQuestion(Long id) {
		try {
			return questionDao.findOne(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Question> recupererQuestions() {
		try {
			return questionDao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Question majQuestion(String reponseParticipePasse, String reponsePreterit, Long id) {
		Question questionTemp = recupererQuestion(id);
		questionTemp.setId(id);
		questionTemp.setReponseParticipePasse(reponseParticipePasse);
		questionTemp.setReponsePreterit(reponsePreterit);

		try {
			return questionDao.update(questionTemp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean supprimerQuestion(Long id) {
		try {
			return questionDao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}

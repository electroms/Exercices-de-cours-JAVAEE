package fr.humanbooster.fx.englishbattle.service;

import java.util.List;

import fr.humanbooster.fx.englishbattle.business.Question;


public interface QuestionService {

	Question ajouterQuestion(Question question);

    Question recupererQuestion(Long id);

    List<Question> recupererQuestions();

    Question majQuestion(String reponseParticipePasse, String reponsePreterit, Long id);

    boolean supprimerQuestion(Long id);
}

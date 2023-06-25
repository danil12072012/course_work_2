package pro.sky.course_work_2.service;

import java.util.Collection;

import pro.sky.course_work_2.exception.QuestionNotFoundException;
import pro.sky.course_work_2.exception.QuestionsAreEmptyException;
import pro.sky.course_work_2.model.Question;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question) throws QuestionNotFoundException;

    Collection<Question> getAll();

    Question getRandomQuestion() throws QuestionsAreEmptyException;
}

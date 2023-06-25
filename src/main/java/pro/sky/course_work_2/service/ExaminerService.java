package pro.sky.course_work_2.service;

import java.util.Collection;

import pro.sky.course_work_2.exception.QuestionsAreEmptyException;
import pro.sky.course_work_2.model.Question;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws QuestionsAreEmptyException;
}

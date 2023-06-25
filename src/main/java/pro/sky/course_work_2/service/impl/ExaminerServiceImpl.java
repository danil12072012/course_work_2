package pro.sky.course_work_2.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.course_work_2.exception.IncorrectAmountOfQuestions;
import pro.sky.course_work_2.exception.QuestionsAreEmptyException;
import pro.sky.course_work_2.model.Question;
import pro.sky.course_work_2.service.ExaminerService;
import pro.sky.course_work_2.service.QuestionService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) throws QuestionsAreEmptyException {
        if (amount <= 0 || amount > questionService.getAll().size()) {
            throw new IncorrectAmountOfQuestions();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}

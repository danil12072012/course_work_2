package pro.sky.course_work_2.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pro.sky.course_work_2.exception.QuestionsAreEmptyException;
import pro.sky.course_work_2.model.Question;
import pro.sky.course_work_2.service.ExaminerService;
@RestController
public class ExamController {
    private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) throws QuestionsAreEmptyException {
        return examinerService.getQuestions(amount);
    }

}

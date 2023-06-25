package pro.sky.course_work_2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.course_work_2.exception.QuestionAlreadyExistsException;
import pro.sky.course_work_2.exception.QuestionNotFoundException;
import pro.sky.course_work_2.exception.QuestionsAreEmptyException;
import pro.sky.course_work_2.service.QuestionService;
import pro.sky.course_work_2.service.impl.JavaQuestionService;
import pro.sky.course_work_2.model.Question;


import java.util.HashSet;



public class JavaQuestionServiceTest {

    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void beforeEach () {
        questionService.add(new Question("Q1", "A1"));
        questionService.add(new Question("Q2", "A2"));
        questionService.add(new Question("Q3", "A3"));
    }

    @AfterEach
    public void afterEach() throws QuestionNotFoundException {
        for (Question question : new HashSet<>(questionService.getAll())) {
            questionService.remove(question);
        }
    }
    @Test
    public void add1Test() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q4", "A4");
        assertThat(questionService.add(question))
                .isEqualTo(question)
                .isIn(questionService.getAll());

    }
    @Test
    public void add2Test() {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q4", "A4");

        assertThat(questionService.add("Q4", "A4"))
                .isEqualTo(question)
                .isIn(questionService.getAll());

    }
    @Test
    public void add1NegativeTest() {
        Question question = new Question("Q1", "A1");

        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(() -> questionService.add(question));
    }
    @Test
    public void add2NegativeTest() {

        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(() -> questionService.add("Q1", "A1"));
    }
    @Test
    public void removeTest() throws QuestionNotFoundException {
        int beforeCount = questionService.getAll().size();
        Question question = new Question("Q2", "A2");
        assertThat(questionService.remove(question))
                .isEqualTo(question)
                .isNotIn(questionService.getAll());

    }
    @Test
    public void removeNegativeTest()  {
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> questionService.remove(new Question("Q5", "A5")));

    }
    @Test
    public void getAllTest() {
        assertThat(questionService.getAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        new Question("Q1", "A1"),
                        new Question("Q2", "A2"),
                        new Question("Q3", "A3")
                );
    }

}


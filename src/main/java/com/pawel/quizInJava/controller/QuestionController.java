package com.pawel.quizInJava.controller;

import com.pawel.quizInJava.entity.QuestionEntity;
import com.pawel.quizInJava.service.QuestionService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@Controller
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("")
    public ModelAndView getQuestion(Model model) {
        ModelAndView mav = new ModelAndView();

        // get random question from database
        QuestionEntity question = questionService.getRandomQuestion();

        String questionText = question.getQuestionText();
        String optionA = question.getOptionA();
        String optionB = question.getOptionB();
        String optionC = question.getOptionC();
        String optionD = question.getOptionD();
        String correctAnswer = question.getCorrectAnswer();

        // put question in model
        mav.addObject("questionText", questionText);
        mav.addObject("optionA", optionA);
        mav.addObject("optionB", optionB);
        mav.addObject("optionC", optionC);
        mav.addObject("optionD", optionD);
        mav.addObject("correctAnswer", correctAnswer);
        mav.setViewName("question");

        return mav;
        // page url http://localhost:8080/question
    }

}

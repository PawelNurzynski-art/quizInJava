package com.pawel.quizInJava.controller;

import com.pawel.quizInJava.entity.QuestionEntity;
import com.pawel.quizInJava.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("")
    public QuestionEntity getQuestion() {
        return questionService.getRandomQuestion();
    }

    @PostMapping("/{id}")
    public boolean checkAnswer(@RequestParam UUID questionId, @RequestParam String answer) {
        Optional<QuestionEntity> question = questionService.getQuestionById(questionId);
        return question.getCorrectAnswer().equals(answer);
    }

}

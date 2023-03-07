package com.pawel.quizInJava.service;

import com.pawel.quizInJava.entity.QuestionEntity;
import com.pawel.quizInJava.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final Set<UUID> askedQuestions = new HashSet<>();

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionEntity getRandomQuestion() {
        QuestionEntity question;
        do {
            question = questionRepository.findRandomQuestion();
        } while (!askedQuestions.add(question.getId()) && askedQuestions.size() < questionRepository.count());
        return question;
    }
}

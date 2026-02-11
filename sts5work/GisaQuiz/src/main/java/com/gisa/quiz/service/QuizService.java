package com.gisa.quiz.service;

import com.gisa.quiz.domain.Quiz;
import com.gisa.quiz.repository.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;

    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public Optional<Quiz> getRandomQuiz() {
        return quizRepository.findRandomQuiz();
    }

    public Optional<Quiz> getQuizById(Long id) {
        return quizRepository.findById(id);
    }
}

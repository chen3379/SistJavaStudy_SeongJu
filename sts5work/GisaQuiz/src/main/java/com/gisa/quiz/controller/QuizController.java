package com.gisa.quiz.controller;

import com.gisa.quiz.domain.Quiz;
import com.gisa.quiz.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/quiz";
    }

    @GetMapping("/quiz")
    public String showRandomQuiz(Model model) {
        Optional<Quiz> quizOptional = quizService.getRandomQuiz();
        if (quizOptional.isPresent()) {
            model.addAttribute("quiz", quizOptional.get());
            // Splitting options for radio buttons
            String[] options = quizOptional.get().getOptions().split("; ");
            model.addAttribute("options", options);
            return "quiz";
        } else {
            model.addAttribute("message", "출제할 문제가 없습니다.");
            return "result"; // Or a dedicated error page
        }
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam Long quizId, @RequestParam String answer, Model model) {
        Optional<Quiz> quizOptional = quizService.getQuizById(quizId);
        if (quizOptional.isPresent()) {
            Quiz quiz = quizOptional.get();
            boolean isCorrect = quiz.getAnswer().equalsIgnoreCase(answer.trim());
            model.addAttribute("quiz", quiz);
            model.addAttribute("isCorrect", isCorrect);
            model.addAttribute("userAnswer", answer);
            return "result";
        } else {
            model.addAttribute("message", "퀴즈 정보를 찾을 수 없습니다.");
            return "result";
        }
    }
}

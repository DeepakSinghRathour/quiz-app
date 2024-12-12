package com.quiz.app.quiz.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.entity.Questions;
import com.quiz.app.quiz.repository.QuizRepository;
import com.quiz.app.quiz.service.QuizService;

@RestController
public class QuizController {

	private QuizService quizService;

	private QuizRepository quizRepository;

	public QuizController(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	@GetMapping("/play-game")
	public Object playGame() {
		int score = 0;

		for (int i = 1; i <= 10; i++) {
			System.out.print(quizRepository.findById(i).get().getQuestionNo() + " :");
			System.out.println(quizRepository.findById(i).get().getQuestion() + " ?");
			System.out.println(quizRepository.findById(i).get().getOption1());
			System.out.println(quizRepository.findById(i).get().getOption2());
			System.out.println(quizRepository.findById(i).get().getOption3());
			System.out.println(quizRepository.findById(i).get().getOption4());

			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			
			if (input.equalsIgnoreCase(quizRepository.findById(i).get().getRightOption())) {
				score++;
			}
		}
		System.out.println("Congratulation Your Score is : "+ score);
		return null;
	}

	@GetMapping("/get-questions")
	public List<Questions> getQuestions() {
		return (List<Questions>) quizRepository.findAll();
	}

	@PostMapping("/set-questions")
	public ResponseEntity<List<Questions>> setQuestions() {
		List<Questions> questionsList = new ArrayList<>();

		Questions question1 = new Questions(1, "What is Java", "Programming Language", "Non Programming Language",
				"Both Language", "None of the above", "Programming Language");
		Questions question2 = new Questions(2, "What is Int", "Data Type", "Non Data Type", "Both Language",
				"None of the above", "Data Type");
		Questions question3 = new Questions(3, "What is Python", "Programming Language", "Non Programming Language",
				"Both Language", "None of the above", "Programming Language");
		Questions question4 = new Questions(4, "What is SQL", "Query Language", "Non Query Language", "Both Language",
				"None of the above", "Query Language");
		Questions question5 = new Questions(5, "What is AWS", "Cloud", "Non Cloud", "Both Language",
				"None of the above", "Cloud");
		Questions question6 = new Questions(6, "What is Azure", "Cloud", "Non Cloud", "Both Language",
				"None of the above", "Cloud");
		Questions question7 = new Questions(7, "What is GCP", "Cloud", "Non Cloud", "Both Language",
				"None of the above", "Cloud");
		Questions question8 = new Questions(8, "Which programming language is not support OOPS concept", "C++", "C",
				"Java", "Python", "C");
		Questions question9 = new Questions(9, "Which programming language support's OOPS concept", "Java", "Python",
				"Both", "None of the above", "Both");
		Questions question10 = new Questions(10, "Why java is not 100% Object Oriented", "Due to primitive data type",
				"Java is 100% Object Oriented", "Both", "None of the above", "Due to primitive data type");

		questionsList.add(question1);
		questionsList.add(question2);
		questionsList.add(question3);
		questionsList.add(question4);
		questionsList.add(question5);
		questionsList.add(question6);
		questionsList.add(question7);
		questionsList.add(question8);
		questionsList.add(question9);
		questionsList.add(question10);

		quizRepository.saveAll(questionsList);

		return new ResponseEntity<>(questionsList, HttpStatus.CREATED);
	}

}

package com.quiz.app.quiz.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.app.entity.Questions;
import com.quiz.app.quiz.repository.QuizRepository;;

@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public List<Questions> getQuestions() {
		return (List<Questions>) quizRepository.findAll();
	}

	@Override
	public Object playGame() {
		int score = 0;
		
		for(int i=1; i<=10; i++) {
			System.out.print(quizRepository.findById(i).get().getQuestionNo()+" :");
			System.out.println(quizRepository.findById(i).get().getQuestion()+" ?");
			System.out.println(quizRepository.findById(i).get().getOption1());
			System.out.println(quizRepository.findById(i).get().getOption2());
			System.out.println(quizRepository.findById(i).get().getOption3());
			System.out.println(quizRepository.findById(i).get().getOption4());
			
			Scanner sc = new Scanner(System.in);
			String input = sc.next();
			
			System.out.println("Enter A, B, C or D");
			
			if(input.equalsIgnoreCase(quizRepository.findById(i).get().getRightOption())) {
				score++;
			}
		}
		
		return quizRepository.findAll();
	}

}

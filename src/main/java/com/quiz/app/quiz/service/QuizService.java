package com.quiz.app.quiz.service;

import java.util.List;

import com.quiz.app.entity.Questions;

public interface QuizService {
	
	public List<Questions> getQuestions();
	
	public Object playGame();
}

package com.quiz.app.quiz.repository;

import org.springframework.data.repository.CrudRepository;
import com.quiz.app.entity.Questions;

public interface QuizRepository extends CrudRepository<Questions, Integer> {

}

package com.peer.missionpeerflow.repository;

import com.peer.missionpeerflow.entity.Question;
import com.peer.missionpeerflow.util.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    public List<Question> findAllByCategory(Category category);
}

package com.peer.missionpeerflow.repository;

import com.peer.missionpeerflow.entity.Question;
import com.peer.missionpeerflow.util.Category;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Optional<Question> findByQuestionId(Long questionId);

	Page<Question> findByCategory(Pageable pageable, Category category);

	Page<Question> findByTitleContainingOrderByQuestionIdDesc(Pageable pageable, String title);

	Page<Question> findByTitleContainingOrderByViewDesc(Pageable pageable, String title);

	Page<Question> findByTitleContainingOrderByRecommendDesc(Pageable pageable, String title);

	Page<Question> findByTitleContainingOrderByCreatedAtDesc(Pageable pageable, String title);
}

package grouping.grouping_project.repository;

import grouping.grouping_project.domain.Comment;
import grouping.grouping_project.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional <Comment> findById(String id);
}

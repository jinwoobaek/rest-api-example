package study.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.restapi.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}

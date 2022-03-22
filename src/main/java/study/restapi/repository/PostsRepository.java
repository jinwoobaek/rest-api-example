package study.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.restapi.domain.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}

package study.restapi.web.dto;

import lombok.Getter;
import study.restapi.domain.Posts;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();;
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}

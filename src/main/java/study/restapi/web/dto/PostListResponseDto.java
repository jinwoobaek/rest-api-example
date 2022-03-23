package study.restapi.web.dto;

import lombok.Getter;
import study.restapi.domain.Post;

@Getter
public class PostListResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostListResponseDto(Post entity) {
        this.id = entity.getId();;
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}

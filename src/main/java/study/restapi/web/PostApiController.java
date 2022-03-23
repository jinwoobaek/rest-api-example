package study.restapi.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.restapi.service.PostService;
import study.restapi.web.dto.PostListResponseDto;
import study.restapi.web.dto.PostResponseDto;
import study.restapi.web.dto.PostSaveRequestDto;
import study.restapi.web.dto.PostUpdateRequestDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping("/api/v1/posts")
    public List<PostListResponseDto> findAll() {
        return postService.findAll();
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postService.delete(id);
        return id;
    }
}


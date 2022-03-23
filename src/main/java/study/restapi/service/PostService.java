package study.restapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.restapi.domain.Post;
import study.restapi.repository.PostRepository;
import study.restapi.web.dto.PostListResponseDto;
import study.restapi.web.dto.PostResponseDto;
import study.restapi.web.dto.PostSaveRequestDto;
import study.restapi.web.dto.PostUpdateRequestDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        Post entity = getOrElseThrow(id);
        return new PostResponseDto(entity);
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Post post = getOrElseThrow(id);
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAll() {
        return postRepository.findAll().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Post post = getOrElseThrow(id);
        postRepository.delete(post);
    }

    private Post getOrElseThrow(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
    }
}

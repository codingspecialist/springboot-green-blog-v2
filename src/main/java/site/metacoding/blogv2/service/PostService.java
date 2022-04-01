package site.metacoding.blogv2.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.post.PostRepository;

// 웹브라우저 -> 컨트롤러 -> 서비스 -> 레포지토리 -> 영속성컨텍스트 -> 디비

@RequiredArgsConstructor
@Service // 컴포넌트 스캔시에 IoC 컨테이너에 등록됨 // 트랜잭션 관리하는 오브젝트임. 기능 모임
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void 글삭제하기(Integer id) {
        postRepository.deleteById(id);
    }

    public Post 글상세보기(Integer id) {
        Optional<Post> postOp = postRepository.findById(id);

        if (postOp.isPresent()) {
            return postOp.get();
        } else {
            throw new RuntimeException("해당 게시글을 찾을 수 없습니다");
        }
    }

    public Page<Post> 게시글목록(Integer page) {
        PageRequest pq = PageRequest.of(page, 3, Sort.by(Direction.DESC, "id"));
        return postRepository.findAll(pq);
    }

    @Transactional
    public void 글쓰기(Post post) {
        postRepository.save(post);
    }
}

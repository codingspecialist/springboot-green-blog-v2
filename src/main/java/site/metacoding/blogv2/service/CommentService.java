package site.metacoding.blogv2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.blogv2.domain.comment.Comment;
import site.metacoding.blogv2.domain.comment.CommentRepository;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.post.PostRepository;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    // 서비스 DI 하면 안됨

    @Transactional
    public void 댓글쓰기(Comment comment, Integer postId) {

        Optional<Post> postOp = postRepository.findById(postId);

        if (postOp.isPresent()) {
            Post postEntity = postOp.get();
            comment.setPost(postEntity);
        } else {
            throw new RuntimeException("없는 게시글에 댓글을 작성할 수 없습니다");
        }

        commentRepository.save(comment);
    }
}

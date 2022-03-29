package site.metacoding.blogv2.web.api.dto.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class WriteDto {
    private String title;
    private String content;

    // 세션 객체를 받아야 함. 그래서 Dto를 User 오브젝트로 변경해야 save(user)가 가능!!
    public Post toEntity(User principal) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setUser(principal);
        post.setPageCount(0); // 여기서 초기값 해주는게 나을듯!!
        return post;
    }
}

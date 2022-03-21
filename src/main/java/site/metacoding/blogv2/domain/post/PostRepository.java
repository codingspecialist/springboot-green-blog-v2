package site.metacoding.blogv2.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;

// Repository는 interface로 만들어야 한다.
// 내부에 @Repository 가 구현되어 있어서 생략 가능하다.
public interface PostRepository extends JpaRepository<Post, Integer> {

}

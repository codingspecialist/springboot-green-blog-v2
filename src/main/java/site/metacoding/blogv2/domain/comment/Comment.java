package site.metacoding.blogv2.domain.comment;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.blogv2.domain.post.Post;
import site.metacoding.blogv2.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Comment { // Post 1 1, Comment N 1
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String content;

    @JoinColumn(name = "postId")
    @ManyToOne
    private Post post;

    @JoinColumn(name = "userId")
    @ManyToOne
    private User user;

    @CreatedDate // insert
    private LocalDateTime createDate;
}

package org.practice.hibernate.oneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "Comments")
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commentId")
    private long commentId;
    @Column(name="createdBy")
    private String createdBy;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="postId")
    private Post post;

}

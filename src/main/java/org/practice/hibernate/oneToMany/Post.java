package org.practice.hibernate.oneToMany;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.List;

@Entity
@Table(name = "Post")
@Getter
@Setter
@ToString
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="postId")
    private long postId;
    @Column(name="type")
    private String type;
    @Column(name="postedBy")
    private String postedBy;
    @OneToMany(mappedBy="post",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Comment> comments;
}

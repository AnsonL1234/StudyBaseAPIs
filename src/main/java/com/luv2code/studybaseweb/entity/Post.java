package com.luv2code.studybaseweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "Post_Id")
    private Long Post_Id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "poster_image")
    private String poster_image;

    @Column(name = "status")
    private PostStatus status;

    @Column(name = "like")
    private int like;

    @Column(name = "dislike")
    private int dislike;

    @Column(name = "create_at")
    private Timestamp create_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @ManyToOne(
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH
                    }
    )
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH
                    }
    )
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH
                    }
    )
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @OneToMany(
            mappedBy = "post",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private PostSection postSection;
}

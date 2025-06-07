package com.luv2code.studybaseweb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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
    private String status;

    @Column(name = "likes")
    private int like;

    @Column(name = "dislike")
    private int dislike;

    @Column(name = "create_at")
    private LocalDateTime create_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

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
    @JsonManagedReference
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
    @JsonManagedReference
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
    @JsonManagedReference
    private Subcategory subcategory;

    @OneToMany(
            mappedBy = "post",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    private List<PostSection> postSection;

    @OneToMany(
            mappedBy = "post",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    private List<Comment> comment;
}

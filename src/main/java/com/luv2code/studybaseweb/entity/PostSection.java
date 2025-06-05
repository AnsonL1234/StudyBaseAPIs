package com.luv2code.studybaseweb.entity;

import com.luv2code.studybaseweb.entity.enums.PostSectionType;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "postsection")
public class PostSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "section_id")
    private int section_id;

    @Column(name = "type")
    private PostSectionType type;

    @Column(name = "content")
    private String content;

    @Column(name = "position")
    private int position;

    @ManyToOne(
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH
                    }
    )
    @JoinColumn(name = "post_id")
    private Post post;
}

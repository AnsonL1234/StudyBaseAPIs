package com.luv2code.studybaseweb.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "subcategory")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

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

    @OneToMany(
            mappedBy = "subcategory",
            fetch = FetchType.LAZY,
            cascade =
                    {
                            CascadeType.DETACH,
                            CascadeType.MERGE,
                            CascadeType.PERSIST,
                            CascadeType.REFRESH
                    }
    )
    private List<Post> post;
}

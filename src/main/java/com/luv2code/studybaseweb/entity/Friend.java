package com.luv2code.studybaseweb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "friend")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @Column(name = "request_at")
    private LocalDateTime request_at;

    @ManyToOne(
            cascade =
                    {
                            CascadeType.MERGE,
                            CascadeType.REFRESH
                    }
    )
    @JoinColumn(name = "user_id")
    @JsonManagedReference
    private User user;

    @ManyToOne(
            cascade =
                    {
                            CascadeType.MERGE,
                            CascadeType.REFRESH
                    }
    )
    @JoinColumn(name = "friend_id")
    @JsonManagedReference
    private User friend;
}

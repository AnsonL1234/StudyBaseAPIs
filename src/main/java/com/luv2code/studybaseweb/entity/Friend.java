package com.luv2code.studybaseweb.entity;

import com.luv2code.studybaseweb.entity.enums.FriendStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "friedn")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private FriendStatus status;

    @Column(name = "request_at")
    private Timestamp request_at;

    @ManyToOne(
            cascade =
                    {
                            CascadeType.MERGE,
                            CascadeType.REFRESH
                    }
    )
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(
            cascade =
                    {
                            CascadeType.MERGE,
                            CascadeType.REFRESH
                    }
    )
    @JoinColumn(name = "friend_id")
    private User friend;
}

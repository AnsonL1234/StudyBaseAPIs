package com.luv2code.studybaseweb.entity;

import com.luv2code.studybaseweb.entity.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "User_Id")
    private String User_Id;

    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private UserStatus userStatus;

    @Column(name = "create_at")
    private Timestamp create_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id")
    private UserDetail userDetail;

    @OneToMany(
            mappedBy = "author",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Post> post;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Comment> comment;

    @OneToMany(mappedBy = "user")
    private List<Friend> sentFriendRequests;

    @OneToMany(mappedBy = "friend")
    private List<Friend> receiveFriendRequest;
}

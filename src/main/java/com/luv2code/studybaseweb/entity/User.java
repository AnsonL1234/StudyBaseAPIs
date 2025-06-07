package com.luv2code.studybaseweb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private String userStatus;

    @Column(name = "create_at")
    private LocalDateTime create_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_detail_id")
    @JsonManagedReference
    private UserDetail userDetail;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    private List<Role> role;

    @OneToMany(
            mappedBy = "author",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    private List<Post> post;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonBackReference
    private List<Comment> comment;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Friend> sentFriendRequests;

    @OneToMany(mappedBy = "friend")
    @JsonBackReference
    private List<Friend> receiveFriendRequest;

    @OneToMany(mappedBy = "sender")
    @JsonBackReference
    private List<Notification> sendNotification;

    @OneToMany(mappedBy = "receiver")
    @JsonBackReference
    private List<Notification> receiveNotification;
}

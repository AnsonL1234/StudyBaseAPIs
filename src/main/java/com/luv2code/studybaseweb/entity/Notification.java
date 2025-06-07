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
@Table(name = "notification")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private int notification_id;

    @Column(name = "content")
    private String content;

    @Column(name = "status")
    private String notificationStatus;

    @Column(name = "create_at")
    private LocalDateTime create_at;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST
            }
    )
    @JoinColumn(name = "sender_id", nullable = false)
    @JsonManagedReference
    private User sender;

    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST
            }
    )
    @JoinColumn(name = "receiver_id",nullable = false)
    @JsonManagedReference
    private User receiver;
}

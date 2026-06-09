package com.yash.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(unique = true)
    private String userName;
	@Column(unique = true)
    private String eMail;
    private String password;
    private String bio;
    @CreationTimestamp
    private LocalDate createdAt;
    
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<Post>();
    
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "follower")
    private Set<Follow> follower;
    
    @OneToMany(mappedBy = "following")
    private Set<Follow> following;
    
    @OneToMany(mappedBy = "user")
    private Set<Like> likes;
    
}

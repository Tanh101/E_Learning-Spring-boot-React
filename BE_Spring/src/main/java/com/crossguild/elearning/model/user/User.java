package com.crossguild.elearning.model.user;

import com.crossguild.elearning.model.Card.Card;
import com.crossguild.elearning.model.Card.Page;
import com.crossguild.elearning.model.quiz.Quiz;
import com.crossguild.elearning.model.quiz.QuizResult;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "username", "email"
        })
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is mandatory")
    @Size(min = 3, max = 50, message = "Full name must greater than 3 characters and lower than 50 characters")
    private String fullName;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 50, message = "Username must greater than 3 characters and lower than 50 characters")
    private String username;

    @NaturalId
    @NotBlank(message = "email is mandatory")
    @Size(max = 50, message = "Lengths of email must be lower than 50 characters")
    @Email(message = "Doesn't matches email format")
    private String email;

    @JsonIgnore
    @NotBlank(message = "password is mandatory")
    @Size(min = 6, max = 100, message = "Username must greater than 6 characters and lower than 100 characters")
    private String password;

    @Lob
    private String avatar;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    Set<Role> roles = new HashSet<>();

    public User(@NotBlank @Size(min = 3, max = 50) String fullName,
                @NotBlank @Size(min = 3, max = 50) String username,
                @NotBlank @Size(max = 50) @Email String email,
                @NotBlank @Size(min = 6, max = 100) String encode,
                String avatar) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = encode;
        this.avatar = avatar;
    }

//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonIgnore
//    private List<Question> questions;

    @OneToMany(mappedBy = "user")
    Set<QuizResult> quizResults;

    @OneToMany(mappedBy = "user")
    Set<Quiz> quizs;

    @OneToMany(mappedBy = "user")
    Set<Card> cards;
}
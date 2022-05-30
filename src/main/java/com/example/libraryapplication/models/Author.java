package com.example.libraryapplication.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @Column(columnDefinition = "TEXT")
    private String firstName;
    @Column(columnDefinition = "TEXT")
    private String lastName;
    @Column(nullable = false)
    @ManyToMany(mappedBy = "author")
    private List<Books> books;
}

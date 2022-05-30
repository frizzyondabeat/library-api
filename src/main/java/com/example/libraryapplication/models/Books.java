package com.example.libraryapplication.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        schema = "db1",
        uniqueConstraints = @UniqueConstraint(
                name = "book_title_unique",
                columnNames = "bookTitle"
        )
)
@Getter
@Setter
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long bookId;
    @Column(columnDefinition = "TEXT")
    private String bookTitle;
    @Column(nullable = false)
    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.DETACH,
            mappedBy = "books"
    )
    private List<Genre> genres;
    @Column(nullable = false)
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "book_author_mapping",
            joinColumns = @JoinColumn(
                    name = "book_id",
                    referencedColumnName = "bookId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "author_id",
                    referencedColumnName = "authorId"
            )
    )
    private List<Author> author;
}

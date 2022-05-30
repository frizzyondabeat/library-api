package com.example.libraryapplication.models;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    private String genreTitle;
    @ManyToOne
    @JoinColumn(
            name = "book_id",
            referencedColumnName = "bookId"
    )
    private Books books;

}

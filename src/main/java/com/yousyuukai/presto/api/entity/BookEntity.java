package com.yousyuukai.presto.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book_infos")
public class BookEntity {
    @Id
    @Column(name = "book_id")
    private String bookId;

    @Column(name = "book_name")
    private String bookName;
}

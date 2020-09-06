package com.aws.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aws.service.dto.Book;

@EnableJpaRepositories
public interface BookRepository extends JpaRepository<Book,Integer> {

}

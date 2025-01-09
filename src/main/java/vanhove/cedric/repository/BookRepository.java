package vanhove.cedric.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import vanhove.cedric.models.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Long>{
	
	List<BookModel> findByAuthor(String author);
	List<BookModel> findByTitle(String title);
	List<BookModel> findByIsbn(String isbn);
	List<BookModel> findByStatus(String status);

	
}
package vanhove.cedric.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vanhove.cedric.dto.BookDto;
import vanhove.cedric.service.BookService;

@RestController
@RequestMapping("cedric")
public class CedricController {
	@Autowired
	private BookService bookService;

	@GetMapping()
	public List<BookDto> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("{id}")
	public BookDto getOneBook(@PathVariable() Long id) {
		return bookService.getOneBook(id);
	}

	@PostMapping()
	public BookDto createBook(@RequestBody BookDto bookDto) {
		return bookService.createBook(bookDto);
	}

	@PutMapping("{id}")
	public BookDto updateBook(@PathVariable() Long id, @RequestBody BookDto bookDto) {
		return bookService.updateBook(id, bookDto);
	}

	@DeleteMapping("{id}")
	public void deleteBook(@PathVariable() Long id) {
		bookService.deleteBook(id);
		return;
	}
	
	@GetMapping("search/{author}")
	public List<BookDto> findByAuthor(@PathVariable()String author) {
		return bookService.findByAuthor(author);
	}
	
	@GetMapping("search/title/{title}")
	public List<BookDto> findByTitle(@PathVariable()String title) {
		return bookService.findByTitle(title);
	}
	
	@GetMapping("search/IS/{isbn}")
	public List<BookDto> findByIsbn(@PathVariable()String isbn) {
		return bookService.findByIsbn(isbn);
	}
	

	@GetMapping("search/status/{status}")
	public List<BookDto> findByStatus(@PathVariable()String status) {
		return bookService.findByStatus(status);
	}
}
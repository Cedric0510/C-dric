package vanhove.cedric.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vanhove.cedric.dto.BookDto;
import vanhove.cedric.models.BookModel;
import vanhove.cedric.repository.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;

	public BookDto modelToDto(BookModel bookModel) {
		BookDto bookDto = new BookDto();
		bookDto.setId(bookModel.getId());
		bookDto.setTitle(bookModel.getTitle());
		bookDto.setAuthor(bookModel.getAuthor());
		bookDto.setIsbn(bookModel.getIsbn());
		bookDto.setStatus(bookModel.getStatus());
		return bookDto;
	}
	

	public BookModel dtoToModel(BookDto bookDto) {
		BookModel bookModel = new BookModel();
		bookModel.setId(bookDto.getId());
		bookModel.setTitle(bookDto.getTitle());
		bookModel.setAuthor(bookDto.getAuthor());
		bookModel.setIsbn(bookDto.getIsbn());
		bookModel.setStatus(bookDto.getStatus());
		return bookModel;
}
	


	public List<BookDto> getAllBooks() {
		final List<BookModel> books = bookRepository.findAll();
		List<BookDto> bookDtos = new ArrayList<>();
		for (int i = 0; i < books.size(); i++) {
			BookModel bookModel = books.get(i);
			BookDto dto = modelToDto(bookModel);
			bookDtos.add(dto);
		}
		return bookDtos;
	}

	public BookDto getOneBook(Long id) {
		final Optional<BookModel> book = bookRepository.findById(id);
		final BookModel bookNonOptionnal = book.get();
		return modelToDto(bookNonOptionnal);
	}

	public BookDto createBook(BookDto bookDto) {
		final BookModel book = bookRepository.save(dtoToModel(bookDto));
		return modelToDto(book);
	}

	public BookDto updateBook(Long id, BookDto bookDto) {
		final Optional<BookModel> bookToUpdate = bookRepository.findById(id);
		bookDto.setId(id);
		final BookModel bookUpdated = dtoToModel(bookDto);
		bookRepository.save(bookUpdated);
		return modelToDto(bookUpdated);
	}

	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		return;
	}

	public List<BookDto> findByAuthor(String author) {
			return bookRepository.findByAuthor(author).stream().map(book->modelToDto(book)).toList();
	}
	public List<BookDto> findByTitle(String title) {
		return bookRepository.findByTitle(title).stream().map(book->modelToDto(book)).toList();
    }
	public List<BookDto> findByIsbn(String isbn) {
		return bookRepository.findByIsbn(isbn).stream().map(book->modelToDto(book)).toList();
	}

	public List<BookDto> findByStatus(String status) {
		return bookRepository.findByStatus(status).stream().map(book->modelToDto(book)).toList();
	}
}
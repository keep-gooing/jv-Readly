package mate.academy.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mate.academy.dao.book.BookDto;
import mate.academy.dao.book.CreateBookRequestDto;
import mate.academy.mapper.BookMapper;
import mate.academy.model.Book;
import mate.academy.service.AiBookService;
import mate.academy.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Book management", description = "Endpoints for managing books")
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {
    private final AiBookService aiBookService;
    private final BookService bookService;
    private final BookMapper bookMapper;

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Create a new book", description = "Create a new book")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody @Valid CreateBookRequestDto bookDto) {
        return bookService.save(bookDto);
    }

    @PreAuthorize(value = "hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get all books",
            description = "Get paginated and sorted list of all available books")
    @GetMapping
    public Page<BookDto> getAll(Pageable pageable) {
        return bookService.findAll(pageable);
    }

    @PreAuthorize(value = "hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Get specific book", description = "Get specific book")
    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Update specific book", description = "Update specific book")
    @PutMapping("/{id}")
    public BookDto update(@PathVariable Long id, @RequestBody @Valid CreateBookRequestDto bookDto) {
        return bookService.update(id, bookDto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete specific book", description = "Delete specific book")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @Operation(summary = "Semantic search",
            description = "Smart search for books based on context, mood, or description using AI")
    @GetMapping("/search-ai")
    public List<BookDto> searchAi(@RequestParam String query) {
        List<Book> books = aiBookService.findBooksBySemanticContent(query);
        return books.stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Index books for AI",
            description = "Convert all existing books into vector embeddings (Run this once after adding data)")
    @PostMapping("/index-ai")
    @ResponseStatus(HttpStatus.OK)
    public String indexAi() {
        aiBookService.indexAllBooks();
        return "All books have been indexed for AI search successfully!";
    }
}

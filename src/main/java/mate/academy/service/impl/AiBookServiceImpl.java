package mate.academy.service.impl;

import lombok.RequiredArgsConstructor;
import mate.academy.model.Book;
import mate.academy.repository.BookRepository;
import mate.academy.service.AiBookService;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AiBookServiceImpl implements AiBookService {
    private final BookRepository bookRepository;
    private final VectorStore vectorStore;

    @Override
    public void indexAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<Document> documents = books.stream()
                .map(book -> {
                    String content = "Назва: " + book.getTitle() +
                            ". Опис: " + (book.getDescription() != null ? book.getDescription() : "немає опису");

                    return new Document(
                            content,
                            Map.of("bookId", book.getId())
                    );
                })
                .toList();

        if (!documents.isEmpty()) {
            vectorStore.add(documents);
        }
    }

    @Override
    public List<Book> findBooksBySemanticContent(String query) {
        List<Document> similarDocuments = vectorStore.similaritySearch(
                SearchRequest.builder()
                        .query(query)
                        .topK(3)
                        .build()
        );

        List<Long> ids = similarDocuments.stream()
                .map(doc -> Long.parseLong(doc.getMetadata().get("bookId").toString()))
                .toList();

        return bookRepository.findAllById(ids);
    }
}
package mate.academy.service;

import mate.academy.model.Book;
import java.util.List;

public interface AiBookService {
    void indexAllBooks();

    List<Book> findBooksBySemanticContent(String query);
}

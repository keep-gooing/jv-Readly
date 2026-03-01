package mate.academy.mapper.impl;

import javax.annotation.processing.Generated;
import mate.academy.dao.book.BookDto;
import mate.academy.dao.book.BookDtoWithoutCategoryIds;
import mate.academy.dao.book.CreateBookRequestDto;
import mate.academy.mapper.BookMapper;
import mate.academy.model.Book;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-01T22:19:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toDto(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDto bookDto = new BookDto();

        if ( book.getTitle() != null ) {
            bookDto.setTitle( book.getTitle() );
        }
        if ( book.getAuthor() != null ) {
            bookDto.setAuthor( book.getAuthor() );
        }
        if ( book.getIsbn() != null ) {
            bookDto.setIsbn( book.getIsbn() );
        }
        if ( book.getPrice() != null ) {
            bookDto.setPrice( book.getPrice() );
        }
        if ( book.getDescription() != null ) {
            bookDto.setDescription( book.getDescription() );
        }
        if ( book.getCoverImage() != null ) {
            bookDto.setCoverImage( book.getCoverImage() );
        }

        setCategoriesIds( bookDto, book );

        return bookDto;
    }

    @Override
    public BookDtoWithoutCategoryIds toDtoWithoutCategories(Book book) {
        if ( book == null ) {
            return null;
        }

        BookDtoWithoutCategoryIds bookDtoWithoutCategoryIds = new BookDtoWithoutCategoryIds();

        if ( book.getId() != null ) {
            bookDtoWithoutCategoryIds.setId( book.getId() );
        }
        if ( book.getTitle() != null ) {
            bookDtoWithoutCategoryIds.setTitle( book.getTitle() );
        }
        if ( book.getAuthor() != null ) {
            bookDtoWithoutCategoryIds.setAuthor( book.getAuthor() );
        }
        if ( book.getIsbn() != null ) {
            bookDtoWithoutCategoryIds.setIsbn( book.getIsbn() );
        }
        if ( book.getPrice() != null ) {
            bookDtoWithoutCategoryIds.setPrice( book.getPrice() );
        }
        if ( book.getDescription() != null ) {
            bookDtoWithoutCategoryIds.setDescription( book.getDescription() );
        }
        if ( book.getCoverImage() != null ) {
            bookDtoWithoutCategoryIds.setCoverImage( book.getCoverImage() );
        }

        return bookDtoWithoutCategoryIds;
    }

    @Override
    public Book toEntity(CreateBookRequestDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        if ( bookDto.getTitle() != null ) {
            book.setTitle( bookDto.getTitle() );
        }
        if ( bookDto.getAuthor() != null ) {
            book.setAuthor( bookDto.getAuthor() );
        }
        if ( bookDto.getIsbn() != null ) {
            book.setIsbn( bookDto.getIsbn() );
        }
        if ( bookDto.getPrice() != null ) {
            book.setPrice( bookDto.getPrice() );
        }
        if ( bookDto.getDescription() != null ) {
            book.setDescription( bookDto.getDescription() );
        }
        if ( bookDto.getCoverImage() != null ) {
            book.setCoverImage( bookDto.getCoverImage() );
        }

        setCategories( book, bookDto );

        return book;
    }

    @Override
    public void updateBookFromDto(CreateBookRequestDto bookDto, Book book) {
        if ( bookDto == null ) {
            return;
        }

        if ( bookDto.getTitle() != null ) {
            book.setTitle( bookDto.getTitle() );
        }
        else {
            book.setTitle( null );
        }
        if ( bookDto.getAuthor() != null ) {
            book.setAuthor( bookDto.getAuthor() );
        }
        else {
            book.setAuthor( null );
        }
        if ( bookDto.getIsbn() != null ) {
            book.setIsbn( bookDto.getIsbn() );
        }
        else {
            book.setIsbn( null );
        }
        if ( bookDto.getPrice() != null ) {
            book.setPrice( bookDto.getPrice() );
        }
        else {
            book.setPrice( null );
        }
        if ( bookDto.getDescription() != null ) {
            book.setDescription( bookDto.getDescription() );
        }
        else {
            book.setDescription( null );
        }
        if ( bookDto.getCoverImage() != null ) {
            book.setCoverImage( bookDto.getCoverImage() );
        }
        else {
            book.setCoverImage( null );
        }

        setCategories( book, bookDto );
    }
}

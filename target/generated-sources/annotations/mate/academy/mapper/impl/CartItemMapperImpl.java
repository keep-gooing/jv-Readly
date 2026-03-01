package mate.academy.mapper.impl;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import mate.academy.dao.shoppingcart.CartItemDto;
import mate.academy.dao.shoppingcart.CartItemResponseDto;
import mate.academy.mapper.CartItemMapper;
import mate.academy.model.Book;
import mate.academy.model.CartItem;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-01T22:19:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class CartItemMapperImpl implements CartItemMapper {

    @Override
    public CartItemResponseDto toDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemResponseDto cartItemResponseDto = new CartItemResponseDto();

        Long id = cartItemBookId( cartItem );
        if ( id != null ) {
            cartItemResponseDto.setBookId( id );
        }
        String title = cartItemBookTitle( cartItem );
        if ( title != null ) {
            cartItemResponseDto.setBookTitle( title );
        }
        if ( cartItem.getId() != null ) {
            cartItemResponseDto.setId( cartItem.getId() );
        }
        cartItemResponseDto.setQuantity( cartItem.getQuantity() );

        return cartItemResponseDto;
    }

    @Override
    public Set<CartItemResponseDto> toDto(Set<CartItem> cartItems) {
        if ( cartItems == null ) {
            return null;
        }

        Set<CartItemResponseDto> set = new LinkedHashSet<CartItemResponseDto>( Math.max( (int) ( cartItems.size() / .75f ) + 1, 16 ) );
        for ( CartItem cartItem : cartItems ) {
            set.add( toDto( cartItem ) );
        }

        return set;
    }

    @Override
    public CartItem toEntity(CartItemDto cartItemDto) {
        if ( cartItemDto == null ) {
            return null;
        }

        CartItem cartItem = new CartItem();

        return cartItem;
    }

    private Long cartItemBookId(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Book book = cartItem.getBook();
        if ( book == null ) {
            return null;
        }
        Long id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String cartItemBookTitle(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }
        Book book = cartItem.getBook();
        if ( book == null ) {
            return null;
        }
        String title = book.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }
}

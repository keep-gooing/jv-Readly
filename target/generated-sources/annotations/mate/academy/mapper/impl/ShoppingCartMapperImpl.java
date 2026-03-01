package mate.academy.mapper.impl;

import java.util.Set;
import javax.annotation.processing.Generated;
import mate.academy.dao.shoppingcart.CartItemResponseDto;
import mate.academy.dao.shoppingcart.ShoppingCartResponseDto;
import mate.academy.mapper.CartItemMapper;
import mate.academy.mapper.ShoppingCartMapper;
import mate.academy.model.CartItem;
import mate.academy.model.ShoppingCart;
import mate.academy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-01T22:19:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class ShoppingCartMapperImpl implements ShoppingCartMapper {

    private final CartItemMapper cartItemMapper;

    @Autowired
    public ShoppingCartMapperImpl(CartItemMapper cartItemMapper) {

        this.cartItemMapper = cartItemMapper;
    }

    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        if ( shoppingCart == null ) {
            return null;
        }

        ShoppingCartResponseDto shoppingCartResponseDto = new ShoppingCartResponseDto();

        Long id = shoppingCartUserId( shoppingCart );
        if ( id != null ) {
            shoppingCartResponseDto.setUserId( id );
        }
        Set<CartItemResponseDto> set = cartItemMapper.toDto( shoppingCart.getCartItems() );
        if ( set != null ) {
            shoppingCartResponseDto.setCartItem( set );
        }
        if ( shoppingCart.getId() != null ) {
            shoppingCartResponseDto.setId( shoppingCart.getId() );
        }

        return shoppingCartResponseDto;
    }

    @Override
    public CartItemResponseDto toDto(CartItem cartItem) {
        if ( cartItem == null ) {
            return null;
        }

        CartItemResponseDto cartItemResponseDto = new CartItemResponseDto();

        if ( cartItem.getId() != null ) {
            cartItemResponseDto.setId( cartItem.getId() );
        }
        cartItemResponseDto.setQuantity( cartItem.getQuantity() );

        return cartItemResponseDto;
    }

    private Long shoppingCartUserId(ShoppingCart shoppingCart) {
        if ( shoppingCart == null ) {
            return null;
        }
        User user = shoppingCart.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

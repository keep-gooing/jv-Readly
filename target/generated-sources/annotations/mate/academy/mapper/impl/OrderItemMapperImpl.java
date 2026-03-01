package mate.academy.mapper.impl;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import mate.academy.dao.order.OrderItemResponseDto;
import mate.academy.mapper.OrderItemMapper;
import mate.academy.model.Book;
import mate.academy.model.OrderItem;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-01T22:19:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemResponseDto toDto(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto();

        Long id = orderItemBookId( orderItem );
        if ( id != null ) {
            orderItemResponseDto.setBookId( id );
        }
        if ( orderItem.getId() != null ) {
            orderItemResponseDto.setId( orderItem.getId() );
        }
        orderItemResponseDto.setQuantity( orderItem.getQuantity() );

        return orderItemResponseDto;
    }

    @Override
    public Set<OrderItemResponseDto> toDto(Set<OrderItem> orderItems) {
        if ( orderItems == null ) {
            return null;
        }

        Set<OrderItemResponseDto> set = new LinkedHashSet<OrderItemResponseDto>( Math.max( (int) ( orderItems.size() / .75f ) + 1, 16 ) );
        for ( OrderItem orderItem : orderItems ) {
            set.add( toDto( orderItem ) );
        }

        return set;
    }

    private Long orderItemBookId(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }
        Book book = orderItem.getBook();
        if ( book == null ) {
            return null;
        }
        Long id = book.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

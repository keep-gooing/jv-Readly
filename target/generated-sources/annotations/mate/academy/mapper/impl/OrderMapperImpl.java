package mate.academy.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import mate.academy.dao.order.OrderItemResponseDto;
import mate.academy.dao.order.OrderRequestDto;
import mate.academy.dao.order.OrderResponseDto;
import mate.academy.mapper.OrderItemMapper;
import mate.academy.mapper.OrderMapper;
import mate.academy.model.Order;
import mate.academy.model.OrderItem;
import mate.academy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-01T22:19:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    private final OrderItemMapper orderItemMapper;

    @Autowired
    public OrderMapperImpl(OrderItemMapper orderItemMapper) {

        this.orderItemMapper = orderItemMapper;
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();

        Long id = orderUserId( order );
        if ( id != null ) {
            orderResponseDto.setUserId( id );
        }
        if ( order.getId() != null ) {
            orderResponseDto.setId( order.getId() );
        }
        List<OrderItemResponseDto> list = orderItemSetToOrderItemResponseDtoList( order.getOrderItems() );
        if ( list != null ) {
            orderResponseDto.setOrderItems( list );
        }
        if ( order.getOrderDate() != null ) {
            orderResponseDto.setOrderDate( order.getOrderDate() );
        }
        if ( order.getTotal() != null ) {
            orderResponseDto.setTotal( order.getTotal() );
        }
        if ( order.getStatus() != null ) {
            orderResponseDto.setStatus( order.getStatus() );
        }

        return orderResponseDto;
    }

    @Override
    public Order toEntity(OrderRequestDto orderRequestDto) {
        if ( orderRequestDto == null ) {
            return null;
        }

        Order order = new Order();

        if ( orderRequestDto.getShippingAddress() != null ) {
            order.setShippingAddress( orderRequestDto.getShippingAddress() );
        }

        return order;
    }

    private Long orderUserId(Order order) {
        if ( order == null ) {
            return null;
        }
        User user = order.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<OrderItemResponseDto> orderItemSetToOrderItemResponseDtoList(Set<OrderItem> set) {
        if ( set == null ) {
            return null;
        }

        List<OrderItemResponseDto> list = new ArrayList<OrderItemResponseDto>( set.size() );
        for ( OrderItem orderItem : set ) {
            list.add( orderItemMapper.toDto( orderItem ) );
        }

        return list;
    }
}

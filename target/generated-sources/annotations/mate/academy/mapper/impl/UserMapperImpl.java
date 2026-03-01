package mate.academy.mapper.impl;

import javax.annotation.processing.Generated;
import mate.academy.dao.user.UserRegistrationRequestDto;
import mate.academy.dao.user.UserResponseDto;
import mate.academy.mapper.UserMapper;
import mate.academy.model.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-01T22:19:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponseDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto userResponseDto = new UserResponseDto();

        if ( user.getId() != null ) {
            userResponseDto.setId( user.getId() );
        }
        if ( user.getEmail() != null ) {
            userResponseDto.setEmail( user.getEmail() );
        }
        if ( user.getFirstName() != null ) {
            userResponseDto.setFirstName( user.getFirstName() );
        }
        if ( user.getLastName() != null ) {
            userResponseDto.setLastName( user.getLastName() );
        }
        if ( user.getShippingAddress() != null ) {
            userResponseDto.setShippingAddress( user.getShippingAddress() );
        }

        return userResponseDto;
    }

    @Override
    public User toModel(UserRegistrationRequestDto request) {
        if ( request == null ) {
            return null;
        }

        User user = new User();

        if ( request.getEmail() != null ) {
            user.setEmail( request.getEmail() );
        }
        if ( request.getPassword() != null ) {
            user.setPassword( request.getPassword() );
        }
        if ( request.getFirstName() != null ) {
            user.setFirstName( request.getFirstName() );
        }
        if ( request.getLastName() != null ) {
            user.setLastName( request.getLastName() );
        }
        if ( request.getShippingAddress() != null ) {
            user.setShippingAddress( request.getShippingAddress() );
        }

        return user;
    }
}

package mate.academy.mapper.impl;

import javax.annotation.processing.Generated;
import mate.academy.dao.category.CategoryDto;
import mate.academy.mapper.CategoryMapper;
import mate.academy.model.Category;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-01T22:19:40+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.1 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryDto toDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        if ( category.getId() != null ) {
            categoryDto.setId( category.getId() );
        }
        if ( category.getName() != null ) {
            categoryDto.setName( category.getName() );
        }
        if ( category.getDescription() != null ) {
            categoryDto.setDescription( category.getDescription() );
        }

        return categoryDto;
    }

    @Override
    public Category toEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        if ( categoryDto.getId() != null ) {
            category.setId( categoryDto.getId() );
        }
        if ( categoryDto.getName() != null ) {
            category.setName( categoryDto.getName() );
        }
        if ( categoryDto.getDescription() != null ) {
            category.setDescription( categoryDto.getDescription() );
        }

        return category;
    }

    @Override
    public void updateCategoryFromDto(CategoryDto categoryDto, Category entity) {
        if ( categoryDto == null ) {
            return;
        }

        if ( categoryDto.getId() != null ) {
            entity.setId( categoryDto.getId() );
        }
        else {
            entity.setId( null );
        }
        if ( categoryDto.getName() != null ) {
            entity.setName( categoryDto.getName() );
        }
        else {
            entity.setName( null );
        }
        if ( categoryDto.getDescription() != null ) {
            entity.setDescription( categoryDto.getDescription() );
        }
        else {
            entity.setDescription( null );
        }
    }
}

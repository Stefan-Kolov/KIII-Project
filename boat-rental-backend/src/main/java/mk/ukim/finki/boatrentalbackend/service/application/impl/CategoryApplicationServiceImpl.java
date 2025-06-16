package mk.ukim.finki.boatrentalbackend.service.application.impl;

import mk.ukim.finki.boatrentalbackend.dto.domain.CreateCategoryDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayCategoryDto;
import mk.ukim.finki.boatrentalbackend.service.application.CategoryApplicationService;
import mk.ukim.finki.boatrentalbackend.service.domain.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryApplicationServiceImpl implements CategoryApplicationService {

    private final CategoryService categoryService;

    public CategoryApplicationServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public List<DisplayCategoryDto> findAll() {
        return DisplayCategoryDto.from(categoryService.findAll());
    }

    @Override
    public Optional<DisplayCategoryDto> findById(Long id) {
        return categoryService
                .findById(id)
                .map(DisplayCategoryDto::from);
    }

    @Override
    public DisplayCategoryDto save(CreateCategoryDto createCategoryDto) {
        return DisplayCategoryDto.from(categoryService.save(createCategoryDto.toCategory()));
    }

    @Override
    public Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto createCategoryDto) {
        return categoryService
                .update(id, createCategoryDto.toCategory())
                .map(DisplayCategoryDto::from);
    }

    @Override
    public Optional<DisplayCategoryDto> deleteById(Long id) {
        return categoryService
                .deleteById(id)
                .map(DisplayCategoryDto::from);
    }

}

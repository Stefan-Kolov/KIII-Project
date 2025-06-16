package mk.ukim.finki.boatrentalbackend.service.domain.impl;

import mk.ukim.finki.boatrentalbackend.model.domain.Category;
import mk.ukim.finki.boatrentalbackend.repository.CategoryRepository;
import mk.ukim.finki.boatrentalbackend.service.domain.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> update(Long id, Category category) {
        return findById(id)
                .map(existingRestaurant -> {
                    existingRestaurant.setName(category.getName());
                    existingRestaurant.setDescription(category.getDescription());
                    return categoryRepository.save(existingRestaurant);
                });
    }

    @Override
    public Optional<Category> deleteById(Long id) {
        Optional<Category> restaurant = findById(id);
        restaurant.ifPresent(categoryRepository::delete);
        return restaurant;
    }

}

package mk.ukim.finki.boatrentalbackend.web.controllers;

import mk.ukim.finki.boatrentalbackend.dto.domain.CreateCategoryDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayCategoryDto;
import mk.ukim.finki.boatrentalbackend.service.application.CategoryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryApplicationService categoryApplicationService;

    public CategoryController(CategoryApplicationService categoryApplicationService) {
        this.categoryApplicationService = categoryApplicationService;
    }

    @GetMapping
    public ResponseEntity<List<DisplayCategoryDto>> findAll() {
        return ResponseEntity.ok(categoryApplicationService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayCategoryDto> findById(@PathVariable Long id) {
        return categoryApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DisplayCategoryDto> save(@RequestBody CreateCategoryDto createCategoryDto) {
        return ResponseEntity.ok(categoryApplicationService.save(createCategoryDto));
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayCategoryDto> update(
            @PathVariable Long id,
            @RequestBody CreateCategoryDto createCategoryDto
    ) {
        return categoryApplicationService
                .update(id, createCategoryDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayCategoryDto> deleteById(@PathVariable Long id) {
        return categoryApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}

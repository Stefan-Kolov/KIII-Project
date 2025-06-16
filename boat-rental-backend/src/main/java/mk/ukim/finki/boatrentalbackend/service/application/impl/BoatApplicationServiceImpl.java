package mk.ukim.finki.boatrentalbackend.service.application.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.boatrentalbackend.dto.domain.CreateBoatDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayBoatDetailsDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayBoatDto;
import mk.ukim.finki.boatrentalbackend.dto.domain.DisplayOrderDto;
import mk.ukim.finki.boatrentalbackend.model.domain.Boat;
import mk.ukim.finki.boatrentalbackend.model.domain.Category;
import mk.ukim.finki.boatrentalbackend.model.domain.Order;
import mk.ukim.finki.boatrentalbackend.model.exceptions.BoatNotFoundException;
import mk.ukim.finki.boatrentalbackend.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.boatrentalbackend.service.application.BoatApplicationService;
import mk.ukim.finki.boatrentalbackend.service.domain.BoatService;
import mk.ukim.finki.boatrentalbackend.service.domain.CategoryService;
import mk.ukim.finki.boatrentalbackend.service.domain.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoatApplicationServiceImpl implements BoatApplicationService {

    private final BoatService boatService;
    private final CategoryService categoryService;
    private final OrderService orderService;

    public BoatApplicationServiceImpl(BoatService boatService, CategoryService categoryService, OrderService orderService) {
        this.boatService = boatService;
        this.categoryService = categoryService;
        this.orderService = orderService;
    }

    @Override
    public List<DisplayBoatDto> findAll() {
        return DisplayBoatDto.from(boatService.findAll());
    }

    @Override
    public Optional<DisplayBoatDto> findById(Long id) {
        return boatService
                .findById(id)
                .map(DisplayBoatDto::from);
    }

    @Override
    public Optional<DisplayBoatDetailsDto> findByIdWithDetails(Long id) {
        return boatService
                .findById(id)
                .map(DisplayBoatDetailsDto::from);
    }

    @Override
    public DisplayBoatDto save(CreateBoatDto createBoatDto) {
        Category category = categoryService
                .findById(createBoatDto.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException(createBoatDto.categoryId()));
        return DisplayBoatDto.from(boatService.save(createBoatDto.toBoat(category)));
    }

    @Override
    public Optional<DisplayBoatDto> update(Long id, CreateBoatDto createBoatDto) {
        Category category = categoryService
                .findById(createBoatDto.categoryId())
                .orElseThrow(() -> new CategoryNotFoundException(createBoatDto.categoryId()));
        return boatService
                .update(id, createBoatDto.toBoat(category))
                .map(DisplayBoatDto::from);
    }

    @Override
    public Optional<DisplayBoatDto> deleteById(Long id) {
        return boatService
                .deleteById(id)
                .map(DisplayBoatDto::from);
    }

    @Transactional
    @Override
    public DisplayOrderDto addToOrder(Long id, String username) {
        Boat boat = boatService
                .findById(id)
                .orElseThrow(() -> new BoatNotFoundException(id));
        Order order = orderService
                .findOrCreatePending(username);
        return DisplayOrderDto.from(boatService.addToOrder(boat, order));
    }
    @Transactional
    @Override
    public DisplayOrderDto removeFromOrder(Long id, String username) {
        Boat boat = boatService
                .findById(id)
                .orElseThrow(() -> new BoatNotFoundException(id));
        Order order = orderService
                .findOrCreatePending(username);
        return DisplayOrderDto.from(boatService.removeFromOrder(boat, order));
    }

}

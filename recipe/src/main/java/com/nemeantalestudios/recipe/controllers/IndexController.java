package com.nemeantalestudios.recipe.controllers;


import com.nemeantalestudios.recipe.models.Category;
import com.nemeantalestudios.recipe.models.UnitOfMeasure;
import com.nemeantalestudios.recipe.repositories.CategoryRepository;
import com.nemeantalestudios.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {

        Optional<Category> categoryOptional = categoryRepository.findByDescription("Japanese");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Ounce");

        System.out.println("Cat Id:" + categoryOptional.get().getId());
        System.out.println("UOM Id:" + unitOfMeasureOptional.get().getId());
        return "index";
    }
}

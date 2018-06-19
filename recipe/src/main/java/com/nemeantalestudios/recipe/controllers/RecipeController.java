package com.nemeantalestudios.recipe.controllers;

import com.nemeantalestudios.recipe.commands.RecipeCommand;
import com.nemeantalestudios.recipe.models.Recipe;
import com.nemeantalestudios.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author kevin.amiranoff on 26/05/2018
 */

@Slf4j
@Controller
public class RecipeController {
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/recipes", "recipes/test"})
    public String renderRecipes(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        log.debug("Returning Recipes template");
        return "recipes";
    }

    @RequestMapping("/recipe/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }

    @RequestMapping("/recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("command", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/recipeForm";
    }

    @RequestMapping("/recipe/add")
    public String addRecipe(Model model) {
        model.addAttribute("command", new RecipeCommand());
        return "recipe/recipeForm";
    }

    @PostMapping
    @RequestMapping("/recipe")
    public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
        RecipeCommand savedCommand = recipeService.saveCommand(command);
        return "redirect:/recipe/" + savedCommand.getId() + "/show";
    }

    @RequestMapping("/recipe/{id}/delete")
    public String delete(@PathVariable String id) {
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/";
    }
}

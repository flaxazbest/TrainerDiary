package ua.azbest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.azbest.model.Exercise;
import ua.azbest.service.ExerciseService;

@Controller
public class ExerciseController {

    private ExerciseService exerciseService;

    @Autowired(required = true)
    @Qualifier(value = "exerciseService")
    public void setExerciseService(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @RequestMapping(value = "exercises", method = RequestMethod.GET)
    public String listExercises(Model model) {
        model.addAttribute("exercise", new Exercise());
        model.addAttribute("listExercises", this.exerciseService.listExercises());
        return "exercises";
    }

    @RequestMapping(value = "exercises/add", method = RequestMethod.POST)
    public String addExercise(@ModelAttribute("exercise") Exercise exercise) {
         if (exercise.getId() == 0)
             this.exerciseService.addExercise(exercise);
         else
             this.exerciseService.updateExercise(exercise);
         return "redirect:/exercises";
    }

    @RequestMapping("/delete/{id}")
    public String deleteExercise(@PathVariable("id") int id) {
        this.exerciseService.deleteExercise(id);
        return "redirect:/exercises";
    }

    @RequestMapping("edit/{id}")
    public String editExercise(@PathVariable("id") int id, Model model) {
        model.addAttribute("exercise", this.exerciseService.getExerciseById(id));
        model.addAttribute("listExercise", this.exerciseService.listExercises());
        return "exercises";
    }

    @RequestMapping("exercisedata/{id}")
    public String bookData(@PathVariable("id") int id, Model model){
        model.addAttribute("exercise", this.exerciseService.getExerciseById(id));

        return "exercisedata";
    }
}

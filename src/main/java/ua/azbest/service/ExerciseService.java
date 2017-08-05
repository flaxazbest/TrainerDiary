package ua.azbest.service;

import ua.azbest.model.Exercise;

import java.util.List;

public interface ExerciseService {

    void addExercise(Exercise exercise);
    void updateExercise(Exercise exercise);
    void deleteExercise(int id);
    Exercise getExerciseById(int id);
    List<Exercise> listExercises();

}

package ua.azbest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.azbest.dao.ExerciseDao;
import ua.azbest.model.Exercise;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseDao exerciseDao;

    public void setExerciseDao(ExerciseDao exerciseDao) {
        this.exerciseDao = exerciseDao;
    }

    @Override
    @Transactional
    public void addExercise(Exercise exercise) {
        this.exerciseDao.addExercise(exercise);
    }

    @Override
    @Transactional
    public void updateExercise(Exercise exercise) {
        this.exerciseDao.updateExercise(exercise);
    }

    @Override
    @Transactional
    public void deleteExercise(int id) {
        this.exerciseDao.deleteExercise(id);
    }

    @Override
    @Transactional
    public Exercise getExerciseById(int id) {
        return this.exerciseDao.getExerciseById(id);
    }

    @Override
    @Transactional
    public List<Exercise> listExercises() {
        return this.exerciseDao.listExercises();
    }
}

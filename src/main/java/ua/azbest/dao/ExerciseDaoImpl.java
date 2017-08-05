package ua.azbest.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.azbest.model.Exercise;

import java.util.List;

@Repository
public class ExerciseDaoImpl implements ExerciseDao {
    private static final Logger logger = LoggerFactory.getLogger(ExerciseDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addExercise(Exercise exercise) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(exercise);
        logger.info("Exercise " + exercise + "\nAdded.");
    }

    @Override
    public void updateExercise(Exercise exercise) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(exercise);
        logger.info("Exercise " + exercise + "\nUpdated.");
    }

    @Override
    public void deleteExercise(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Exercise exercise = (Exercise) session.load(Exercise.class, new Integer(id));
        if (exercise != null)
            session.delete(exercise);
        logger.info("Exercise " + exercise + "\nRemoved.");
    }

    @Override
    public Exercise getExerciseById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Exercise exercise = (Exercise) session.load(Exercise.class, new Integer(id));
        if (exercise != null) {
            logger.info("Exercise " + exercise + "\nLoaded.");
            return exercise;
        }
        logger.info("No exercise with id " + id);
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Exercise> listExercises() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Exercise> exerciseList = session.createQuery("from Exercise").list();
        for (Exercise e: exerciseList) {
            logger.info("List : " + e + "\n");
        }
        return exerciseList;
    }
}
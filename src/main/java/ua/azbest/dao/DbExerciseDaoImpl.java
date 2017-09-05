package ua.azbest.dao;

import org.hibernate.Session;
import ua.azbest.model.Exercise;

import java.util.List;

public class DbExerciseDaoImpl implements ExerciseDao {

    @Override
    public void addExercise(Exercise exercise) {
        Session session = HibernateUtilites.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(exercise);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + exercise);
    }

    @Override
    public void updateExercise(Exercise exercise) {
        Session session = HibernateUtilites.getSessionFactory().openSession();
        session.beginTransaction();
        Exercise em = (Exercise) session.load(Exercise.class, exercise.getId());
        em.setName(exercise.getName());
        em.setDescription(exercise.getDescription());
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully updated " + exercise.toString());
    }

    @Override
    public void deleteExercise(int id) {
        Session session = HibernateUtilites.getSessionFactory().openSession();
        session.beginTransaction();
        Exercise e = getExerciseById(id);
        session.delete(e);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + e.toString());
    }

    @Override
    public Exercise getExerciseById(int id) {
        Session session = HibernateUtilites.getSessionFactory().openSession();
        Exercise e = (Exercise) session.load(Exercise.class, id);
        session.close();
        return e;
    }

    @Override
    public List<Exercise> listExercises() {
        Session session = HibernateUtilites.getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<Exercise> exercises = session.createQuery("FROM Exercise").list();
        session.close();
        System.out.println("Found " + exercises.size() + " Employees");
        return exercises;
    }
}

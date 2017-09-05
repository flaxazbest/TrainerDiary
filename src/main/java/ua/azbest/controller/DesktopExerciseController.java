package ua.azbest.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.azbest.dao.DbExerciseDaoImpl;
import ua.azbest.model.Exercise;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DesktopExerciseController {

    private DbExerciseDaoImpl db;

    @FXML
    TableView table;

    @FXML
    TableColumn<Exercise, Integer> idCol;

    @FXML
    TableColumn<Exercise, String> nameCol;

    @FXML
    TableColumn<Exercise, String> descriptionCol;

    @FXML
    Button addnewBtn;

    @FXML
    TextField textFieldName;

    @FXML
    TextArea textAreaDescription;

    public void refresh() {
        ObservableList<Exercise> list = FXCollections.observableArrayList();
        for (Exercise ex: db.listExercises())
            list.add(ex);
        table.setItems(list);
    }

    public void AddNewUser(ActionEvent actionEvent) {
        Exercise ex = new Exercise(
                textFieldName.getText(),
                textAreaDescription.getText()
        );
        db.addExercise(ex);
        textFieldName.clear();
        textAreaDescription.clear();
        refresh();
    }

    public void UpdateUser(ActionEvent actionEvent) {
    }

    public void deleteUser(ActionEvent actionEvent) {
    }

    public void showOnClick(MouseEvent mouseEvent) {
    }

    public void initialize() {
        table.setTableMenuButtonVisible(true);
        db = new DbExerciseDaoImpl();
        idCol.setCellValueFactory(new PropertyValueFactory<Exercise, Integer>("ID_exercise"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Exercise, String>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Exercise, String>("description"));
        refresh();
    }
}

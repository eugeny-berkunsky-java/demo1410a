package main;

import beans.Person;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML private TableView<Person> peopleTable;
    @FXML private TableColumn<Person,Integer> idColumn;
    @FXML private TableColumn<Person, String> nameColumn;
    @FXML private TableColumn<Person, Integer> ageColumn;
    @FXML private TextField userIdField;
    @FXML private TextField userAgeField;
    @FXML private TextField userNameField;

    private List<Person> people;

    @FXML
    public void initialize() {
        people = new ArrayList<>();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        peopleTable.setItems(FXCollections.observableList(people));
    }

    public void addUser() {
        int id = Integer.parseInt(userIdField.getText());
        String userName = userNameField.getText();
        int userAge = Integer.parseInt(userAgeField.getText());
        people.add(new Person(id, userName, userAge));
        peopleTable.setItems(FXCollections.observableList(people));
    }
}

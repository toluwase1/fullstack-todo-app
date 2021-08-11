package com.example.testfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableController implements Initializable {
    @FXML
    private TableView<Todos> table;

    @FXML
    private TableColumn<Todos, String> taskTitle;

    @FXML
    private TableColumn<Todos, String> taskDescription;

    @FXML
    private TableColumn<Todos, String> startDate;

    @FXML
    private TableColumn<Todos, String> finishDate;

    ObservableList<Todos> list = FXCollections.observableArrayList(
            new Todos("Read", "Java", "12-12-21", "12-12-22"),
            new Todos("Read", "Java", "12-12-21", "12-12-22"),
            new Todos("Read", "Java", "12-12-21", "12-12-22")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        taskTitle.setCellValueFactory(new PropertyValueFactory<Todos, String>("taskTitle"));
        taskDescription.setCellValueFactory(new PropertyValueFactory<Todos, String>("taskDescription"));
        startDate.setCellValueFactory(new PropertyValueFactory<Todos, String>("startDate"));
        finishDate.setCellValueFactory(new PropertyValueFactory<Todos, String>("finishDate"));

        table.setItems(list);
    }
}

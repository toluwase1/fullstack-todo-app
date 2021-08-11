module com.example.fxfrontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fxfrontend to javafx.fxml;
    exports com.example.fxfrontend;
}
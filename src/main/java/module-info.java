module com.example.grasshopper {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.grasshopper to javafx.fxml;
    exports com.example.grasshopper;
}
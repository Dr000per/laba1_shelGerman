module com.example.laba1_shelgerman {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.laba1_shelgerman to javafx.fxml;
    exports com.example.laba1_shelgerman;
}
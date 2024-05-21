module com.example.padariaproject {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;

    opens com.example.padariaproject to javafx.fxml;
    exports com.example.padariaproject;
    exports com.example.padariaproject.Controller;
    opens com.example.padariaproject.Controller to javafx.fxml;
    opens com.example.padariaproject.Models to javafx.base;

}
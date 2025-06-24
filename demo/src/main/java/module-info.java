module com.example.demo {
    // JavaFX modules
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    // External libraries
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.google.gson;

    // Opens directives for reflection (JavaFX and Gson)
    opens com.example.demo to javafx.fxml, com.google.gson;
    opens com.example.demo.controllers to javafx.fxml, com.google.gson;
    opens com.example.demo.controllers.Admin to javafx.fxml;
    opens com.example.demo.controllers.Customer to javafx.fxml;
    opens com.example.demo.controllers.Delivery to javafx.fxml, com.google.gson;
    opens com.example.demo.Models to com.google.gson;

    // Exported packages for use by other modules
    exports com.example.demo;
    exports com.example.demo.controllers;
    exports com.example.demo.controllers.Admin;
    exports com.example.demo.controllers.Customer;
    exports com.example.demo.controllers.Delivery;
    exports com.example.demo.Models;
}
module com.example.mbacbyte {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires org.jfree.jfreechart;

    opens com.example.mbacbyte to javafx.fxml;
    exports com.example.mbacbyte;
}
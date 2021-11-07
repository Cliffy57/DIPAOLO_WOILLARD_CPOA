module javafx.woillard_dipaolo_cpoa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires junit;

    opens javafx to javafx.fxml;
    exports javafx;
    exports test;
    exports dao.metier;
    exports test.testListeMemoire;
    exports test.testMySQL;

}
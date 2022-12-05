module com.nj.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.nj.javafxdemo to javafx.fxml;
    exports com.nj.javafxdemo;
}
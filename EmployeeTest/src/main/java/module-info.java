module com.nj.employeetest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.nj.employeetest to javafx.fxml;
    exports com.nj.employeetest;
}
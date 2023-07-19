module com.example.conversorxd {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.conversorxd to javafx.fxml;
    exports com.example.conversorxd;
}
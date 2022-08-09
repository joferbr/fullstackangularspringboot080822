module com.github.joferbr.vendas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.joferbr.vendas to javafx.fxml;
    exports com.github.joferbr.vendas;
}
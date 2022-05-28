module edu.proyectofinal.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires lombok;
    requires jakarta.ws.rs;

    opens edu.proyectofinal.tictactoe to javafx.fxml;
    exports edu.proyectofinal.tictactoe;
    exports edu.proyectofinal.tictactoe.controller;
    opens edu.proyectofinal.tictactoe.controller to javafx.fxml;
}
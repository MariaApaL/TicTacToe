module edu.proyectofinal.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.proyectofinal.tictactoe to javafx.fxml;
    exports edu.proyectofinal.tictactoe;
}
package edu.proyectofinal.tictactoe.excepciones;

public class TicTacToeException extends Throwable{
    public static final String MESSAGE="Exception: ";

    public TicTacToeException(String message){
        super(MESSAGE+ message);
    }
}

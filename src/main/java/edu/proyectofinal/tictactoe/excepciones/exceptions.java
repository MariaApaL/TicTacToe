package edu.proyectofinal.tictactoe.excepciones;

public class exceptions extends Throwable{
    public static final String MESSAGE="Exception: ";

    public exceptions (String message){
        super(MESSAGE+ message);
    }
}

package edu.proyectofinal.tictactoe.excepciones;

public class Exceptions extends Throwable{
    public static final String MESSAGE="Exception: ";

    public Exceptions(String message){
        super(MESSAGE+ message);
    }
}

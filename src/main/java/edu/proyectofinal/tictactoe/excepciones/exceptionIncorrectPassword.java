package edu.proyectofinal.tictactoe.excepciones;

public class exceptionIncorrectPassword extends Throwable{
    public static final String MESSAGE="Exception: ";

    public exceptionIncorrectPassword(String message){
        super(MESSAGE+ message);
    }
}

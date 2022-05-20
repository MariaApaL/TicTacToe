package edu.proyectofinal.tictactoe.excepciones;

public class exception extends Throwable{
    public static final String MESSAGE="Exception: ";

    public exception (String message){
        super(MESSAGE+message);
    }
}

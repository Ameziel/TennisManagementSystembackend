package tms.tennismanagementsystem.app.moniteur.exceptions;

public class MoniteurNotFoundException extends Exception {
    private static final String MONITEUR_NOT_FOUND_MESSAGE_EXCEPTION = "Moniteur not found";
    public MoniteurNotFoundException() { super(MONITEUR_NOT_FOUND_MESSAGE_EXCEPTION);}
}

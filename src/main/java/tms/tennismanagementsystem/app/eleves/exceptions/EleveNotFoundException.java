package tms.tennismanagementsystem.app.eleves.exceptions;

public class EleveNotFoundException extends Exception {
    private static final String ELEVE_NOT_FOUND_MESSAGE_EXCEPTION = "Eleve not found";

    public EleveNotFoundException() {
        super(ELEVE_NOT_FOUND_MESSAGE_EXCEPTION);
    }
}

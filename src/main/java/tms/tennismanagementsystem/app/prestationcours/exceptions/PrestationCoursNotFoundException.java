package tms.tennismanagementsystem.app.prestationcours.exceptions;

public class PrestationCoursNotFoundException extends Exception {
    private static final String PRESTATION_COURS_NOT_FOUND_MESSAGE_EXCEPTION = "PrestationCours not found";
    public PrestationCoursNotFoundException() {
        super(PRESTATION_COURS_NOT_FOUND_MESSAGE_EXCEPTION);
    }
}

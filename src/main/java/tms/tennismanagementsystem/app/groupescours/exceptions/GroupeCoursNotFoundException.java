package tms.tennismanagementsystem.app.groupescours.exceptions;

public class GroupeCoursNotFoundException extends Exception {
    public static final String GROUPE_COURS_NOT_FOUND_MESSAGE_EXCEPTION = "GroupeCours not found";
    public GroupeCoursNotFoundException() {
        super(GROUPE_COURS_NOT_FOUND_MESSAGE_EXCEPTION);
    }
}

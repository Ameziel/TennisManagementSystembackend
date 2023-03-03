package tms.tennismanagementsystem.app.formulecours;

public record FormuleCoursDTO(
    String id,
    Integer effectifMaximum,
    Integer nombreSeance,
    Double tarif,
    String annee,
    String saison
) {
}

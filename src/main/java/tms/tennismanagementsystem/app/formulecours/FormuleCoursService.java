package tms.tennismanagementsystem.app.formulecours;

import tms.tennismanagementsystem.app.formulecours.exceptions.FormuleNotFoundException;

import java.util.List;
import java.util.UUID;

public interface FormuleCoursService {
    List<FormuleCoursDTO> getAllFormulesCours();
    FormuleCoursDTO getFormuleCoursById(UUID id) throws FormuleNotFoundException; // throws exception
    FormuleCoursDTO saveFormuleCours(FormuleCoursDTO formuleCoursDTO);
    FormuleCoursDTO updateFormuleCours(FormuleCoursDTO formuleCoursDTO);
    void deleteFormuleCours(UUID id);


    List<FormuleCoursDTO> getAllActifsFormulesCours();

    List<FormuleCoursDTO> getAllInactifsFormulesCours();
}

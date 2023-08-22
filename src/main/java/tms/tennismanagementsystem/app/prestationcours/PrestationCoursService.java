package tms.tennismanagementsystem.app.prestationcours;

import tms.tennismanagementsystem.app.moniteur.exceptions.MoniteurNotFoundException;
import tms.tennismanagementsystem.app.prestationcours.exceptions.PrestationCoursNotFoundException;

import java.util.List;
import java.util.UUID;

public interface PrestationCoursService {
    List<PrestationCoursDTO> getAllPrestationsCours();
    PrestationCoursDTO getGPrestationCoursById(UUID id) throws PrestationCoursNotFoundException;
    PrestationCoursDTO savePrestationCours(PrestationCoursDTO prestationCoursDTO) throws MoniteurNotFoundException;
    PrestationCoursDTO updatePrestationCours(PrestationCoursDTO prestationCoursDTO);
    void deletePrestationCoursDTO(UUID id);
}

package tms.tennismanagementsystem.app.moniteur;

import tms.tennismanagementsystem.app.moniteur.exceptions.MoniteurNotFoundException;

import java.util.List;
import java.util.UUID;

public interface MoniteurService {
    List<MoniteurDTO> getAllMoniteurs();
    MoniteurDTO getMoniteurById(UUID id) throws MoniteurNotFoundException;
    MoniteurDTO saveMoniteur(MoniteurDTO moniteurDTO);
    MoniteurDTO updateMoniteur(MoniteurDTO moniteurDTO);
    void deleteMoniteur(UUID id);
    List<MoniteurDTO> searchMoniteursByNames(String keyword);
    List<MoniteurDTO> getAllByActifTrueOrderByNomAsc();
}

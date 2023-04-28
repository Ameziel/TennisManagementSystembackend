package tms.tennismanagementsystem.app.inscriptionformule;

import tms.tennismanagementsystem.app.inscriptionformule.exceptions.InscriptionFormuleNotFoundException;

import java.util.List;
import java.util.UUID;

public interface InscriptionFormuleService {

    List<InscriptionFormuleDTO> getAllInscriptionFormules();
    InscriptionFormuleDTO getInscriptionFormuleById(UUID id) throws InscriptionFormuleNotFoundException;
    InscriptionFormuleDTO saveInscriptionFormule(InscriptionFormuleDTO inscriptionFormuleDTO);
    InscriptionFormuleDTO updateInscriptionFormule(InscriptionFormuleDTO inscriptionFormuleDTO);
    void deleteInscriptionFormuleDTO(UUID id);

}

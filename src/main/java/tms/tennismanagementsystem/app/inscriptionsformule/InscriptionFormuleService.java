package tms.tennismanagementsystem.app.inscriptionsformule;

import tms.tennismanagementsystem.app.inscriptionsformule.exceptions.InscriptionFormuleNotFoundException;

import java.util.List;
import java.util.UUID;

public interface InscriptionFormuleService {

    List<InscriptionFormuleDTO> getAllInscriptionsFormule();
    InscriptionFormuleDTO getInscriptionFormuleById(UUID id) throws InscriptionFormuleNotFoundException;
    InscriptionFormuleDTO saveInscriptionFormule(InscriptionFormuleDTO inscriptionFormuleDTO);
    InscriptionFormuleDTO updateInscriptionFormule(InscriptionFormuleDTO inscriptionFormuleDTO);
    void deleteInscriptionFormuleDTO(UUID id);

}

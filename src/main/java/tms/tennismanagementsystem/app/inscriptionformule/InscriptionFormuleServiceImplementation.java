package tms.tennismanagementsystem.app.inscriptionformule;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tms.tennismanagementsystem.app.inscriptionformule.exceptions.InscriptionFormuleNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InscriptionFormuleServiceImplementation implements InscriptionFormuleService {

    private InscriptionFormuleRepository inscriptionFormuleRepository;
    private InscriptionFormuleMapperImplementation inscriptionFormuleMapperImplementation;

    @Override
    public List<InscriptionFormuleDTO> getAllInscriptionFormules() {
        List<InscriptionFormuleEntity> inscriptionFormuleEntities = inscriptionFormuleRepository.findAll();
        List<InscriptionFormuleDTO> inscriptionFormuleDTOS =
                inscriptionFormuleEntities.stream().map(
                        inscriptionFormuleEntity -> inscriptionFormuleMapperImplementation.fromInscriptionFormuleEntity(inscriptionFormuleEntity)).collect(Collectors.toList());

        return inscriptionFormuleDTOS;
    }
    @Override
    public InscriptionFormuleDTO getInscriptionFormuleById(UUID id) throws InscriptionFormuleNotFoundException {
        InscriptionFormuleEntity inscriptionFormuleEntity = inscriptionFormuleRepository.findById(id)
                .orElseThrow(() -> new InscriptionFormuleNotFoundException("Inscription not found"));
        return inscriptionFormuleMapperImplementation.fromInscriptionFormuleEntity(inscriptionFormuleEntity);
    }
    @Override
    public InscriptionFormuleDTO saveInscriptionFormule(InscriptionFormuleDTO inscriptionFormuleDTO) {
        InscriptionFormuleEntity inscriptionFormule = inscriptionFormuleMapperImplementation.fromInscriptionFormuleDTO(inscriptionFormuleDTO);
        InscriptionFormuleEntity savedInscriptionFormule = inscriptionFormuleRepository.save(inscriptionFormule);
        return inscriptionFormuleMapperImplementation.fromInscriptionFormuleEntity(savedInscriptionFormule);
    }
    @Override
    public InscriptionFormuleDTO updateInscriptionFormule(InscriptionFormuleDTO inscriptionFormuleDTO) {
        InscriptionFormuleEntity inscriptionFormule = inscriptionFormuleMapperImplementation.fromInscriptionFormuleDTO(inscriptionFormuleDTO);
        InscriptionFormuleEntity savedInscriptionFormule = inscriptionFormuleRepository.save(inscriptionFormule);
        return inscriptionFormuleMapperImplementation.fromInscriptionFormuleEntity(savedInscriptionFormule);
    }
    @Override
    public void deleteInscriptionFormuleDTO(UUID id) {
inscriptionFormuleRepository.deleteById(id);
    }
}

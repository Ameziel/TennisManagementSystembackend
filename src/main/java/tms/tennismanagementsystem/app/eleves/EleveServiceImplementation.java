package tms.tennismanagementsystem.app.eleves;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tms.tennismanagementsystem.app.eleves.exceptions.EleveNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class EleveServiceImplementation {

    private EleveRepository eleveRepository;
    private EleveMapperImplementation eleveMapperImplementation;


    public List<EleveDTO> getAllEleves() {
        List<EleveEntity> eleveEntities = eleveRepository.findAll();
        List<EleveDTO> elevesDTOs =
                eleveEntities.stream().map(
                        eleveEntity -> eleveMapperImplementation.fromEleveEntity(eleveEntity)).collect(Collectors.toList());
        return elevesDTOs;
    }




    public EleveDTO getEleveById(UUID id) throws EleveNotFoundException {
        EleveEntity eleve = eleveRepository.findById(id)
                .orElseThrow(() -> new EleveNotFoundException("Eleve not found"));
        return eleveMapperImplementation.fromEleveEntity(eleve);
    }


    public EleveDTO saveEleve(EleveDTO eleveDTO) {
        EleveEntity eleve = eleveMapperImplementation.fromEleveDTO(eleveDTO);
        EleveEntity savedEleve = eleveRepository.save(eleve);
//        TransformAttributeIntoLowercase(savedEleve);
        return eleveMapperImplementation.fromEleveEntity(savedEleve);
    }


    public EleveDTO updateEleve(EleveDTO eleveDTO) {
        EleveEntity eleve = eleveMapperImplementation.fromEleveDTO(eleveDTO);
        EleveEntity savedEleve = eleveRepository.save(eleve);
//        TransformAttributeIntoLowercase(savedEleve);
        return eleveMapperImplementation.fromEleveEntity(savedEleve);
    }

    public void deleteEleve(UUID id) {
        eleveRepository.deleteById(id);
    }


    public List<EleveDTO> searchElevesByNames(String keyword) {
        List<EleveEntity> eleves = eleveRepository.searchElevesByName(keyword);
        List<EleveDTO> elevesDtos = eleves.stream().map(e -> eleveMapperImplementation.fromEleveEntity(e)).collect(Collectors.toList());
        return elevesDtos;
    }


    public List<EleveDTO> findByEmail(String email) {
        return eleveRepository.findByEmail(email);
    } //TODO s'il y en a plusieurs, JPA va trouver par défaut ?


    public List<EleveDTO> getAllActifsEleves() {
        List<EleveEntity> eleves = eleveRepository.findAllByActifTrue();
        List<EleveDTO> elevesDtos = eleves.stream().map(e -> eleveMapperImplementation.fromEleveEntity(e)).collect(Collectors.toList());
        return elevesDtos;
    }


    public List<EleveDTO> getAllInactifEleves() {

        return null;
    }

    /*******************************
            Private
     ********************************/

//    private void TransformAttributeIntoLowercase(EleveEntity savedEleve) {
//        savedEleve.setNom(savedEleve.getNom().toLowerCase());
//        savedEleve.setPrenom(savedEleve.getPrenom().toLowerCase());
//    }
}

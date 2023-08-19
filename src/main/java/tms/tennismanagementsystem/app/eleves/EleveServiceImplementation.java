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

    /**
     * **************************************
     * *                                    *
     * *            GET Methods             *
     * *                                    *
     * **************************************
     */
    public List<EleveDTO> getAllEleves() {
        List<EleveEntity> eleveEntities = eleveRepository.findAll();
        List<EleveDTO> elevesDTOs =
                eleveEntities.stream().map(
                        eleveEntity -> eleveMapperImplementation.fromEleveEntity(eleveEntity)).collect(Collectors.toList());
        return elevesDTOs;
    }
    public EleveDTO getEleveById(UUID id) throws EleveNotFoundException {
        EleveEntity eleve = eleveRepository.findById(id)
                .orElseThrow(() -> new EleveNotFoundException());
        return eleveMapperImplementation.fromEleveEntity(eleve);
    }
    public List<EleveDTO> searchElevesByNames(String keyword) {
        List<EleveEntity> eleves = eleveRepository.searchElevesByNames(keyword);
        List<EleveDTO> elevesDtos = eleves.stream().map(e -> eleveMapperImplementation.fromEleveEntity(e)).collect(Collectors.toList());
        return elevesDtos;
    }
    public List<EleveDTO> getAllActifsEleves() {
        List<EleveEntity> elevesActifs = eleveRepository.findAllByActifTrue();
        List<EleveDTO> elevesActifsDtos = elevesActifs.stream().map(e -> eleveMapperImplementation.fromEleveEntity(e)).collect(Collectors.toList());
        return elevesActifsDtos;
    }
    public List<EleveDTO> getAllInactifsEleves() {
        List<EleveEntity> elevesInactifs = eleveRepository.findAllByActifFalse();
        List<EleveDTO> elevesInactifsDtos = elevesInactifs.stream().map(e -> eleveMapperImplementation.fromEleveEntity(e)).collect(Collectors.toList());
        return elevesInactifsDtos;
    }
    public List<EleveDTO> findAllByEmail(String email) {
        List<EleveEntity> elevesByEmail = eleveRepository.findAllByEmail(email);
        List<EleveDTO> elevesInactifsDtos = elevesByEmail.stream().map(e -> eleveMapperImplementation.fromEleveEntity(e)).collect(Collectors.toList());
        return elevesInactifsDtos;
    }
    /**
     * **************************************
     * *                                    *
     * *            POST Methods            *
     * *                                    *
     * **************************************
     */
    public EleveDTO saveEleve(EleveDTO eleveDTO) {
        EleveEntity eleve = eleveMapperImplementation.fromEleveDTO(eleveDTO);
        EleveEntity savedEleve = eleveRepository.save(eleve);
//        TransformAttributeIntoLowercase(savedEleve);
        return eleveMapperImplementation.fromEleveEntity(savedEleve);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Methods             *
     * *                                    *
     * **************************************
     */
    public EleveDTO updateEleve(EleveDTO eleveDTO) {
        EleveEntity eleve = eleveMapperImplementation.fromEleveDTO(eleveDTO);
        EleveEntity savedEleve = eleveRepository.save(eleve);
//        TransformAttributeIntoLowercase(savedEleve);
        return eleveMapperImplementation.fromEleveEntity(savedEleve);
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Methods           *
     * *                                    *
     * **************************************
     */
    public void deleteEleve(UUID id) {
        eleveRepository.deleteById(id);
    }
    /**
     * **************************************
     * *                                    *
     * *        Private Methods             *
     * *                                    *
     * **************************************
     */
//    private void TransformAttributeIntoLowercase(EleveEntity savedEleve) {
//        savedEleve.setNom(savedEleve.getNom().toLowerCase());
//        savedEleve.setPrenom(savedEleve.getPrenom().toLowerCase());
//    }
}

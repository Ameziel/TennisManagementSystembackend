package tms.tennismanagementsystem.app.moniteur;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tms.tennismanagementsystem.app.moniteur.exceptions.MoniteurNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class MoniteurServiceImplementation implements MoniteurService{

    private MoniteurRepository moniteurRepository;
    private MoniteurMapperImplementation moniteurMapperImplementation;

    /**
     * **************************************
     * *                                    *
     * *            GET Methods             *
     * *                                    *
     * **************************************
     */
    @Override
    public List<MoniteurDTO> getAllMoniteurs() {
        List<MoniteurEntity> moniteurEntities = moniteurRepository.findAll();
        List<MoniteurDTO> moniteursDTOS =
                moniteurEntities.stream().map(
                        moniteurEntity -> moniteurMapperImplementation.fromMoniteurEntity(moniteurEntity)).collect(Collectors.toList()
                );
        return moniteursDTOS;
    }
    @Override
    public MoniteurDTO getMoniteurById(UUID id) throws MoniteurNotFoundException {
        MoniteurEntity moniteurEntity = moniteurRepository.findById(id)
                .orElseThrow(() -> new MoniteurNotFoundException());
        return moniteurMapperImplementation.fromMoniteurEntity((moniteurEntity));
    }
    @Override
    public List<MoniteurDTO> searchMoniteursByNames(String keyword) {
        List<MoniteurEntity> moniteurs = moniteurRepository.searchMoniteursByName(keyword);
        List<MoniteurDTO> moniteurDTOS = moniteurs.stream().map(
                m -> moniteurMapperImplementation.fromMoniteurEntity(m)).collect(Collectors.toList());
        return moniteurDTOS;
    }
    public List<MoniteurDTO> getAllActifsMoniteurs() {
        List<MoniteurEntity> moniteursActifs = moniteurRepository.findAllByActifTrue();
        List<MoniteurDTO> moniteursActifsDtos = moniteursActifs.stream().map(e -> moniteurMapperImplementation.fromMoniteurEntity(e)).collect(Collectors.toList());
        return moniteursActifsDtos;
    }
    public List<MoniteurDTO> getAllInactifsMoniteurs() {
        List<MoniteurEntity> moniteursInactifs = moniteurRepository.findAllByActifFalse();
        List<MoniteurDTO> moniteursInactifsDtos = moniteursInactifs.stream().map(e -> moniteurMapperImplementation.fromMoniteurEntity(e)).collect(Collectors.toList());
        return moniteursInactifsDtos;
    }

    /**
     * **************************************
     * *                                    *
     * *            POST Methods            *
     * *                                    *
     * **************************************
     */
    @Override
    public MoniteurDTO saveMoniteur(MoniteurDTO moniteurDTO) {
        MoniteurEntity moniteurEntity = moniteurMapperImplementation.fromMoniteurDTO(moniteurDTO);
        MoniteurEntity savedMoniteur = moniteurRepository.save(moniteurEntity);
//        TransformAttributeIntoLowercase(savedMoniteur);
        return moniteurMapperImplementation.fromMoniteurEntity(savedMoniteur);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Methods             *
     * *                                    *
     * **************************************
     */
    @Override
    public MoniteurDTO updateMoniteur(MoniteurDTO moniteurDTO) {
        MoniteurEntity moniteurEntity = moniteurMapperImplementation.fromMoniteurDTO(moniteurDTO);
        MoniteurEntity savedMoniteur = moniteurRepository.save(moniteurEntity);
//        TransformAttributeIntoLowercase(savedMoniteur);
        return moniteurMapperImplementation.fromMoniteurEntity(savedMoniteur);
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Methods           *
     * *                                    *
     * **************************************
     */
    @Override
    public void deleteMoniteur(UUID id) {
        moniteurRepository.deleteById(id);

    }
    /**
     * **************************************
     * *                                    *
     * *        Private Methods             *
     * *                                    *
     * **************************************
     */
//    private void TransformAttributeIntoLowercase(MoniteurEntity savedMoniteur) {
//        savedMoniteur.setNom(savedMoniteur.getNom().toLowerCase());
//        savedMoniteur.setPrenom(savedMoniteur.getPrenom().toLowerCase());
//    }
}

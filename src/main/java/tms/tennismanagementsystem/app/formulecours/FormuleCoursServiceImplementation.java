package tms.tennismanagementsystem.app.formulecours;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tms.tennismanagementsystem.app.formulecours.exceptions.FormuleNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FormuleCoursServiceImplementation implements FormuleCoursService {

    private FormuleCoursRepository formuleCoursRepository;
    private FormuleCoursMapperImplementation formuleCoursMapperImplementation;
    /**
     * **************************************
     * *                                    *
     * *            GET Method              *
     * *                                    *
     * **************************************
     */
    @Override
    public List<FormuleCoursDTO> getAllFormulesCours() {
        List<FormuleCoursEntity> formulesCoursEntities = formuleCoursRepository.findAll();
        List<FormuleCoursDTO> formuleCoursDTOS = formulesCoursEntities.stream().map(
                formuleCoursEntity -> formuleCoursMapperImplementation.fromFormuleCoursEntity(formuleCoursEntity)).collect(Collectors.toList());
        return formuleCoursDTOS;
    }
    @Override
    public FormuleCoursDTO getFormuleCoursById(UUID id) throws FormuleNotFoundException {
        FormuleCoursEntity formuleCoursEntity = formuleCoursRepository.findById(id)
                .orElseThrow(() -> new FormuleNotFoundException("Formule not found"));
        return formuleCoursMapperImplementation.fromFormuleCoursEntity(formuleCoursEntity);
    }

    @Override
    public List<FormuleCoursDTO> getAllActifsFormulesCours() {
        List<FormuleCoursEntity> formulesCoursActifs = formuleCoursRepository.findAllByActifTrue();
        List<FormuleCoursDTO> formulesCoursActifsDtos = formulesCoursActifs.stream().map(e -> formuleCoursMapperImplementation.fromFormuleCoursEntity(e)).collect(Collectors.toList());
        return formulesCoursActifsDtos;
    }

    @Override
    public List<FormuleCoursDTO> getAllInactifsFormulesCours() {
        List<FormuleCoursEntity> formulesCoursInactifs = formuleCoursRepository.findAllByActifFalse();
        List<FormuleCoursDTO> formulesCoursInactifsDTO = formulesCoursInactifs.stream().map( e -> formuleCoursMapperImplementation.fromFormuleCoursEntity(e)).collect(Collectors.toList());
        return formulesCoursInactifsDTO;
    }
    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @Override
    public FormuleCoursDTO saveFormuleCours(FormuleCoursDTO formuleCoursDTO) {
        FormuleCoursEntity formuleCoursEntity = formuleCoursMapperImplementation.fromFormuleCoursDTO(formuleCoursDTO);
        FormuleCoursEntity savedFormuleCours = formuleCoursRepository.save(formuleCoursEntity);
        return formuleCoursMapperImplementation.fromFormuleCoursEntity(savedFormuleCours);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */
    @Override
    public FormuleCoursDTO updateFormuleCours(FormuleCoursDTO formuleCoursDTO) {
        FormuleCoursEntity formuleCoursEntity = formuleCoursMapperImplementation.fromFormuleCoursDTO(formuleCoursDTO);
        FormuleCoursEntity savedFormuleCours = formuleCoursRepository.save(formuleCoursEntity);
        return formuleCoursMapperImplementation.fromFormuleCoursEntity(savedFormuleCours);
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @Override
    public void deleteFormuleCours(UUID id) {
        formuleCoursRepository.deleteById(id);
    }

}

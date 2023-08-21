package tms.tennismanagementsystem.app.prestationcours;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tms.tennismanagementsystem.app.prestationcours.exceptions.PrestationCoursNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class PrestationCoursServiceImplementation implements PrestationCoursService{

    private PrestationCoursRepository prestationCoursRepository;
    private PrestationCoursMapperImplementation prestationCoursMapperImplementation;
    /**
     * **************************************
     * *                                    *
     * *            GET Method              *
     * *                                    *
     * **************************************
     */
    @Override
    public List<PrestationCoursDTO> getAllPrestationsCours() {
        List<PrestationCoursEntity> prestationCoursEntities = prestationCoursRepository.findAll();
        List<PrestationCoursDTO> prestationCoursDTOS = prestationCoursEntities.stream().map(
                prestationCoursEntity -> prestationCoursMapperImplementation.fromPrestationCoursEntity(prestationCoursEntity)).collect(Collectors.toList());
        return prestationCoursDTOS;
    }

    @Override
    public PrestationCoursDTO getGPrestationCoursById(UUID id) throws PrestationCoursNotFoundException {
        PrestationCoursEntity prestationCoursEntity = prestationCoursRepository.findById(id)
                .orElseThrow(() -> new PrestationCoursNotFoundException("PrestationCours not found"));
        return prestationCoursMapperImplementation.fromPrestationCoursEntity(prestationCoursEntity);
    }
    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @Override
    public PrestationCoursDTO savePrestationCours(PrestationCoursDTO prestationCoursDTO) {
        return null;
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */
    @Override
    public PrestationCoursDTO updatePrestationCours(PrestationCoursDTO prestationCoursDTO) {
        return null;
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @Override
    public void deletePrestationCoursDTO(UUID id) {

    }
}

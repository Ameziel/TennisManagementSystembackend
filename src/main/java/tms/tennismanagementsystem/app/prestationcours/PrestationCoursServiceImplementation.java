package tms.tennismanagementsystem.app.prestationcours;

import tms.tennismanagementsystem.app.prestationcours.exceptions.PrestationCoursNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PrestationCoursServiceImplementation implements PrestationCoursService{

    private PrestationCoursRepository prestationCoursRepository;
    private PrestationCoursMapperImplementation prestationCoursMapperImplementation;

    @Override
    public List<PrestationCoursDTO> getAllPrestationsCours() {
        List<PrestationCoursEntity> prestationCoursEntities = prestationCoursRepository.findAll();
        List<PrestationCoursDTO> prestationCoursDTOS = prestationCoursEntities.stream().map(
                prestationCoursEntity -> prestationCoursMapperImplementation.fromPrestationCoursEntity(prestationCoursEntity)).collect(Collectors.toList());
        return prestationCoursDTOS;
    }

    @Override
    public PrestationCoursDTO getGPrestationCours(UUID id) throws PrestationCoursNotFoundException {
        PrestationCoursEntity prestationCoursEntity = prestationCoursRepository.findById(id)
                .orElseThrow(() -> new PrestationCoursNotFoundException("PrestationCours not found"));
        return prestationCoursMapperImplementation.fromPrestationCoursEntity(prestationCoursEntity);
    }

    @Override
    public PrestationCoursDTO savePrestationCours(PrestationCoursDTO prestationCoursDTO) {
        return null;
    }

    @Override
    public PrestationCoursDTO updatePrestationCours(PrestationCoursDTO prestationCoursDTO) {
        return null;
    }

    @Override
    public void deletePrestationCoursDTO(UUID id) {

    }
}

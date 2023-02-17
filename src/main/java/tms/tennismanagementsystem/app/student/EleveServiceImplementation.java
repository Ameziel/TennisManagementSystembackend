package tms.tennismanagementsystem.app.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tms.tennismanagementsystem.app.student.exceptions.EleveNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class EleveServiceImplementation implements EleveService{

    private EleveRepository eleveRepository;
    private EleveMapperImplementation eleveMapperImplementation;


    @Override
    public EleveDTO saveEleve(EleveDTO eleveDTO) {
        EleveEntity eleve = eleveMapperImplementation.fromEleveDTO(eleveDTO);
        EleveEntity savedEleve = eleveRepository.save(eleve);
        return eleveMapperImplementation.fromEleveEntity(savedEleve);
    }
    @Override
    public List<EleveDTO> getAllEleves() {
        List<EleveEntity> eleveEntities = eleveRepository.findAll();
        List<EleveDTO> elevesDTOs =
                eleveEntities.stream().map(eleveEntity -> eleveMapperImplementation.fromEleveEntity(eleveEntity)).collect(Collectors.toList());
        return elevesDTOs;
    }
    @Override
    public EleveDTO getEleveById(UUID id) throws EleveNotFoundException {
        EleveEntity eleve = eleveRepository.findById(id)
                .orElseThrow(() -> new EleveNotFoundException("Eleve not found"));
        return eleveMapperImplementation.fromEleveEntity(eleve);
    }
    @Override
    public EleveDTO updateEleve(EleveDTO eleveDTO) {
        EleveEntity eleve = eleveMapperImplementation.fromEleveDTO(eleveDTO);
        EleveEntity savedEleve = eleveRepository.save(eleve);
        return eleveMapperImplementation.fromEleveEntity(savedEleve);
    }
    @Override
    public void deleteEleve(UUID id) {
        eleveRepository.deleteById(id);
    }
}
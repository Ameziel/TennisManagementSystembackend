package tms.tennismanagementsystem.app.student;

import tms.tennismanagementsystem.app.student.exceptions.EleveNotFoundException;

import java.util.List;
import java.util.UUID;

public interface EleveService {
    List<EleveDTO> getAllEleves();
    EleveDTO getEleveById(UUID id) throws EleveNotFoundException;
    EleveDTO saveEleve(EleveDTO eleveDTO);
    EleveDTO updateEleve(EleveDTO eleveDTO);
    void deleteEleve(UUID id);
    List<EleveDTO> searchElevesByNames(String keyword);
}

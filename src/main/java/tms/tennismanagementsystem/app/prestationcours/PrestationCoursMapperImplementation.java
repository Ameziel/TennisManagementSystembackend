package tms.tennismanagementsystem.app.prestationcours;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tms.tennismanagementsystem.app.moniteur.MoniteurEntity;

@Service
public class PrestationCoursMapperImplementation {
    public PrestationCoursDTO fromPrestationCoursEntity(PrestationCoursEntity prestationCoursEntity) {
        PrestationCoursDTO prestationCoursDTO = new PrestationCoursDTO();
        BeanUtils.copyProperties(prestationCoursEntity, prestationCoursDTO);
        prestationCoursDTO.setReferenceMoniteur(prestationCoursEntity.getReferenceMoniteur().getId());
        return prestationCoursDTO;
    }
    public PrestationCoursEntity fromPrestationCoursDTO(PrestationCoursDTO prestationCoursDTO) {
        PrestationCoursEntity prestationCoursEntity = new PrestationCoursEntity();
        BeanUtils.copyProperties(prestationCoursDTO, prestationCoursEntity);
        MoniteurEntity temp_moniteur = new MoniteurEntity();                                        //TODO a améliorer
        temp_moniteur.setId(prestationCoursDTO.getReferenceMoniteur());
        prestationCoursEntity.setReferenceMoniteur(temp_moniteur);
        return prestationCoursEntity;
    }
}

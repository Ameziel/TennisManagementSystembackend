package tms.tennismanagementsystem.app.prestationcours;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tms.tennismanagementsystem.app.groupescours.GroupeCoursEntity;
import tms.tennismanagementsystem.app.moniteur.MoniteurEntity;

@Service
public class PrestationCoursMapperImplementation {
    public PrestationCoursDTO fromPrestationCoursEntity(PrestationCoursEntity prestationCoursEntity) {
        PrestationCoursDTO prestationCoursDTO = new PrestationCoursDTO();
        BeanUtils.copyProperties(prestationCoursEntity, prestationCoursDTO);
        prestationCoursDTO.setReferenceMoniteur(prestationCoursEntity.getReferenceMoniteur().getId());
        prestationCoursDTO.setReferenceGroupe((prestationCoursEntity.getReferenceGroupe().getId()));

        return prestationCoursDTO;
    }
    public PrestationCoursEntity fromPrestationCoursDTO(PrestationCoursDTO prestationCoursDTO) {
        PrestationCoursEntity prestationCoursEntity = new PrestationCoursEntity();
        BeanUtils.copyProperties(prestationCoursDTO, prestationCoursEntity);

        MoniteurEntity temp_moniteur = new MoniteurEntity();
        temp_moniteur.setId(prestationCoursDTO.getReferenceMoniteur());
        prestationCoursEntity.setReferenceMoniteur(temp_moniteur);

        GroupeCoursEntity temp_groupeEntity = new GroupeCoursEntity();
        temp_groupeEntity.setId(prestationCoursDTO.getReferenceGroupe());
        prestationCoursEntity.setReferenceGroupe(temp_groupeEntity);

        return prestationCoursEntity;
    }
}

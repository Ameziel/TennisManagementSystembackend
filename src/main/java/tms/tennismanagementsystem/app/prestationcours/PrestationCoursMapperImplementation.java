package tms.tennismanagementsystem.app.prestationcours;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PrestationCoursMapperImplementation {
    public PrestationCoursDTO fromPrestationCoursEntity(PrestationCoursEntity prestationCoursEntity) {
        PrestationCoursDTO prestationCoursDTO = new PrestationCoursDTO();
        BeanUtils.copyProperties(prestationCoursEntity, prestationCoursDTO);
        return prestationCoursDTO;
    }
    public PrestationCoursEntity fromPrestationCoursDTO(PrestationCoursDTO prestationCoursDTO) {
        PrestationCoursEntity prestationCoursEntity = new PrestationCoursEntity();
        BeanUtils.copyProperties(prestationCoursDTO, prestationCoursEntity);
        return prestationCoursEntity;
    }
}

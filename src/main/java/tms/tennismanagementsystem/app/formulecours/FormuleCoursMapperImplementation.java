package tms.tennismanagementsystem.app.formulecours;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class FormuleCoursMapperImplementation {
    public FormuleCoursDTO fromFormuleCoursEntity(FormuleCoursEntity formuleCoursEntity) {
        FormuleCoursDTO formuleCoursDTO = new FormuleCoursDTO();
        BeanUtils.copyProperties(formuleCoursEntity, formuleCoursDTO);
        return formuleCoursDTO;
    }
    public FormuleCoursEntity fromFormuleCoursDTO(FormuleCoursDTO formuleCoursDTO){
        FormuleCoursEntity formuleCoursEntity = new FormuleCoursEntity();
        BeanUtils.copyProperties(formuleCoursDTO, formuleCoursEntity);
        return formuleCoursEntity;
    }
}

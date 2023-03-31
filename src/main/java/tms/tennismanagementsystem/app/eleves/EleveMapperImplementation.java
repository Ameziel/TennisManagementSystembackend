package tms.tennismanagementsystem.app.eleves;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EleveMapperImplementation {
    public EleveDTO fromEleveEntity(EleveEntity eleveEntity) {
        EleveDTO eleveDTO = new EleveDTO();
        BeanUtils.copyProperties(eleveEntity, eleveDTO);
        return eleveDTO;
    }
    public EleveEntity fromEleveDTO(EleveDTO eleveDTO){
        EleveEntity eleveEntity = new EleveEntity();
        BeanUtils.copyProperties(eleveDTO, eleveEntity);
        return eleveEntity;
    }
}

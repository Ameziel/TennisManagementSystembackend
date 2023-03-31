package tms.tennismanagementsystem.app.moniteur;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MoniteurMapperImplementation {
    public MoniteurDTO fromMoniteurEntity(MoniteurEntity moniteurEntity) {
        MoniteurDTO moniteurDTO = new MoniteurDTO();
        BeanUtils.copyProperties(moniteurEntity, moniteurDTO);
        return moniteurDTO;
    }
    public MoniteurEntity fromMoniteurDTO(MoniteurDTO moniteurDTO) {
        MoniteurEntity moniteurEntity = new MoniteurEntity();
        BeanUtils.copyProperties(moniteurDTO, moniteurEntity);
        return moniteurEntity;
    }
}

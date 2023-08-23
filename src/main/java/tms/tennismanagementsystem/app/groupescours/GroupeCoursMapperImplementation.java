package tms.tennismanagementsystem.app.groupescours;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class GroupeCoursMapperImplementation {
    public GroupeCoursDTO fromGroupeCoursEntity(GroupeCoursEntity groupeCoursEntity) {
        GroupeCoursDTO groupeCoursDTO = new GroupeCoursDTO();
        BeanUtils.copyProperties(groupeCoursEntity, groupeCoursDTO);
        return groupeCoursDTO;
    }

    public GroupeCoursEntity fromGroupeCoursDTO(GroupeCoursDTO groupeCoursDTO) {
        GroupeCoursEntity groupeCoursEntity = new GroupeCoursEntity();
        BeanUtils.copyProperties(groupeCoursDTO, groupeCoursEntity);
        return groupeCoursEntity;
    }
}

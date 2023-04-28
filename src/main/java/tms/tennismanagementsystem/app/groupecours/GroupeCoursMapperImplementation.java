package tms.tennismanagementsystem.app.groupecours;

import org.springframework.beans.BeanUtils;

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

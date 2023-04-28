package tms.tennismanagementsystem.app.groupecours;

import tms.tennismanagementsystem.app.groupecours.exceptions.GroupeCoursNotFoundException;

import java.util.List;
import java.util.UUID;

public interface GroupeCoursService {
    List<GroupeCoursDTO> getAllGroupesCours();
    GroupeCoursDTO getGroupeCoursById(UUID id) throws GroupeCoursNotFoundException;
    GroupeCoursDTO saveGroupeCours(GroupeCoursDTO groupeCoursEntity);
    GroupeCoursDTO updateGroupeCours(GroupeCoursDTO groupeCoursEntity);
    void deleteGroupeCours(UUID id);

}

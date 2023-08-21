package tms.tennismanagementsystem.app.groupecours;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tms.tennismanagementsystem.app.groupecours.exceptions.GroupeCoursNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@Transactional
@AllArgsConstructor
public class GroupeCoursServiceImplementation implements GroupeCoursService{

    private GroupeCoursRepository groupeCoursRepository;
    private GroupeCoursMapperImplementation groupeCoursMapperImplementation;
    /**
     * **************************************
     * *                                    *
     * *            GET Method              *
     * *                                    *
     * **************************************
     */
    @Override
    public List<GroupeCoursDTO> getAllGroupesCours() {
        List<GroupeCoursEntity> groupeCoursEntities = groupeCoursRepository.findAll();
        List<GroupeCoursDTO> groupeCoursDTOs = groupeCoursEntities.stream().map(
                groupeCoursEntity -> groupeCoursMapperImplementation.fromGroupeCoursEntity(groupeCoursEntity)).collect(Collectors.toList());
        return groupeCoursDTOs;
    }

    @Override
    public GroupeCoursDTO getGroupeCoursById(UUID id) throws GroupeCoursNotFoundException {
        GroupeCoursEntity groupeCoursEntity = groupeCoursRepository.findById(id)
                .orElseThrow(() -> new GroupeCoursNotFoundException("GroupeCours not found"));
        return groupeCoursMapperImplementation.fromGroupeCoursEntity(groupeCoursEntity);
    }
    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @Override
    public GroupeCoursDTO saveGroupeCours(GroupeCoursDTO groupeCoursDTO) {
        GroupeCoursEntity groupeCours = groupeCoursMapperImplementation.fromGroupeCoursDTO(groupeCoursDTO);
        GroupeCoursEntity savedGroupeCours = groupeCoursRepository.save(groupeCours);
        return groupeCoursMapperImplementation.fromGroupeCoursEntity(savedGroupeCours);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */
    @Override
    public GroupeCoursDTO updateGroupeCours(GroupeCoursDTO groupeCoursDTO) {
        GroupeCoursEntity groupeCours = groupeCoursMapperImplementation.fromGroupeCoursDTO(groupeCoursDTO);
        GroupeCoursEntity savedGroupeCours = groupeCoursRepository.save(groupeCours);
        return groupeCoursMapperImplementation.fromGroupeCoursEntity(savedGroupeCours);
    }

    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @Override
    public void deleteGroupeCours(UUID id) {
        groupeCoursRepository.deleteById(id); //TODO que s'il n'existe aucune prestation lié à ce groupe.
    }
}

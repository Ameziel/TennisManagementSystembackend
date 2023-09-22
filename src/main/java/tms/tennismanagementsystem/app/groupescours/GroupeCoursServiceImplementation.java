package tms.tennismanagementsystem.app.groupescours;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tms.tennismanagementsystem.app.groupescours.exceptions.GroupeCoursNotFoundException;

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
                .orElseThrow(() -> new GroupeCoursNotFoundException());
        return groupeCoursMapperImplementation.fromGroupeCoursEntity(groupeCoursEntity);
    }
    @Override
    public List<GroupeCoursDTO> getAllActifsGroupeCours() {
        List<GroupeCoursEntity> groupeCoursEntities = groupeCoursRepository.findAllByActifTrue();
        List<GroupeCoursDTO> groupeCoursDTOS = groupeCoursEntities.stream().map(
                groupeCoursEntity -> groupeCoursMapperImplementation.fromGroupeCoursEntity(groupeCoursEntity)).collect(Collectors.toList());
        return groupeCoursDTOS;
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
        groupeCoursRepository.deleteById(id);
    }

}

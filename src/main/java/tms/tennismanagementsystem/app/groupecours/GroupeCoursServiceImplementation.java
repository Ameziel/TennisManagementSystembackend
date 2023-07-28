package tms.tennismanagementsystem.app.groupecours;

import tms.tennismanagementsystem.app.groupecours.exceptions.GroupeCoursNotFoundException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class GroupeCoursServiceImplementation implements GroupeCoursService{

    private GroupeCoursRepository groupeCoursRepository;
    private GroupeCoursMapperImplementation groupeCoursMapperImplementation;

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

    @Override
    public GroupeCoursDTO saveGroupeCours(GroupeCoursDTO groupeCoursDTO) {
        GroupeCoursEntity groupeCours = groupeCoursMapperImplementation.fromGroupeCoursDTO(groupeCoursDTO);
        GroupeCoursEntity savedGroupeCours = groupeCoursRepository.save(groupeCours);
        return groupeCoursMapperImplementation.fromGroupeCoursEntity(savedGroupeCours);
    }

    @Override
    public GroupeCoursDTO updateGroupeCours(GroupeCoursDTO groupeCoursDTO) {
        GroupeCoursEntity groupeCours = groupeCoursMapperImplementation.fromGroupeCoursDTO(groupeCoursDTO);
        GroupeCoursEntity savedGroupeCours = groupeCoursRepository.save(groupeCours);
        return groupeCoursMapperImplementation.fromGroupeCoursEntity(savedGroupeCours);
    }

    @Override
    public void deleteGroupeCours(UUID id) {
        groupeCoursRepository.deleteById(id); //TODO que s'il n'existe aucune prestation lié à ce groupe.
    }
}
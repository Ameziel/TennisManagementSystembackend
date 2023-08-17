package tms.tennismanagementsystem.app.groupecours;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.groupecours.exceptions.GroupeCoursNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class GroupeCoursController {

    private GroupeCoursService groupeCoursService;

    @GetMapping("/groupecours")
    public List<GroupeCoursDTO> getAllGroupeCours() {
        return groupeCoursService.getAllGroupesCours();
    }
//    @GetMapping("/groupecours/search")
//    public List<GroupeCoursDTO> search(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
//        return prestationCoursService.searchMoniteursByNames("%"+keyword+"%");
//    }

    @GetMapping("/groupecours/{id}")
    public GroupeCoursDTO getGroupeCours(@PathVariable(name = "id")String id) throws GroupeCoursNotFoundException {
        return groupeCoursService.getGroupeCoursById(UUID.fromString(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/groupecours")
    public GroupeCoursDTO save(@RequestBody GroupeCoursDTO groupeCoursDTO) {
        return groupeCoursService.saveGroupeCours(groupeCoursDTO);
    }

    @PostMapping("/groupecours/{id}")
    public GroupeCoursDTO updateGroupeCours(@PathVariable UUID id, @RequestBody GroupeCoursDTO groupeCoursDTO) {
        groupeCoursDTO.setId(id);
        return groupeCoursService.updateGroupeCours(groupeCoursDTO);
    }
    @ResponseStatus()
    @DeleteMapping("/groupecours/{id}")
    public void deleteGroupeCours(@PathVariable UUID id) {
        groupeCoursService.deleteGroupeCours(id);
    }
}

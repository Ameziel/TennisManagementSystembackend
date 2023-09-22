package tms.tennismanagementsystem.app.groupescours;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.groupescours.exceptions.GroupeCoursNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class GroupeCoursController {

    private GroupeCoursService groupeCoursService;
    /**
     * **************************************
     * *                                    *
     * *            GET Method              *
     * *                                    *
     * **************************************
     */
    @GetMapping("/groupescours")
    public List<GroupeCoursDTO> getAllGroupesCours() {
        return groupeCoursService.getAllGroupesCours();
    }
    @GetMapping("/groupescours/{id}")
    public GroupeCoursDTO getGroupeCoursById(@PathVariable(name = "id")UUID id) throws GroupeCoursNotFoundException {
        return groupeCoursService.getGroupeCoursById((id));
    }
    @GetMapping("/groupescours/actifs")
    public List<GroupeCoursDTO> getAllActifsGroupeCours() {
        return groupeCoursService.getAllActifsGroupeCours();
    }

    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/groupescours")
    public GroupeCoursDTO saveGroupeCours(@RequestBody GroupeCoursDTO groupeCoursDTO) {
        return groupeCoursService.saveGroupeCours(groupeCoursDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */
    @PutMapping("/groupescours/{id}")
    public GroupeCoursDTO updateGroupeCours(@PathVariable UUID id, @RequestBody GroupeCoursDTO groupeCoursDTO) {
        groupeCoursDTO.setId(id);
        return groupeCoursService.updateGroupeCours(groupeCoursDTO);
    }

    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @ResponseStatus()
    @DeleteMapping("/groupescours/{id}")
    public void deleteGroupeCours(@PathVariable UUID id) {
        groupeCoursService.deleteGroupeCours(id);
    }
}

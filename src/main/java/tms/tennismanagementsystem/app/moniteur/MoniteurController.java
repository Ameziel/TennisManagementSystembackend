package tms.tennismanagementsystem.app.moniteur;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.moniteur.exceptions.MoniteurNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class MoniteurController {

    private MoniteurService moniteurService;
    /**
     * **************************************
     * *                                    *
     * *            GET Method              *
     * *                                    *
     * **************************************
     */
    @GetMapping("/moniteurs")
    public List<MoniteurDTO> getAllEleves() {
        return moniteurService.getAllMoniteurs();
    }
    @GetMapping("/moniteurs/search")
    public List<MoniteurDTO> searchEleve(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
        return moniteurService.searchMoniteursByNames("%"+keyword+"%");
    }

    @GetMapping("/moniteurs/{id}")
    public MoniteurDTO getEleve(@PathVariable(name = "id")String id) throws MoniteurNotFoundException {
        return moniteurService.getMoniteurById(UUID.fromString(id));
    }

    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/moniteurs")
    public MoniteurDTO save(@RequestBody MoniteurDTO moniteurDTO) {
        return moniteurService.saveMoniteur(moniteurDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */

    @PutMapping("/moniteurs/{id}")
    public MoniteurDTO updateEleve(@PathVariable UUID id, @RequestBody MoniteurDTO moniteurDTO) {
        moniteurDTO.setId(id);
        return moniteurService.updateMoniteur(moniteurDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @ResponseStatus()
    @DeleteMapping("/moniteurs/{id}")
    public void deleteEleve(@PathVariable UUID id) {
        moniteurService.deleteMoniteur(id);
    }
}

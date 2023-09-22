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
    public List<MoniteurDTO> getAllMoniteurs() {
        return moniteurService.getAllMoniteurs();
    }

    @GetMapping("/moniteurs/{id}")
    public MoniteurDTO getMoniteurById(@PathVariable(name = "id")UUID id) throws MoniteurNotFoundException {
        return moniteurService.getMoniteurById((id));
    }
    @GetMapping("/moniteurs/ActifsAndAllNameAsc")
    public List<MoniteurDTO> getAllActifsEleveAndOrderByNomAsc() {
        return moniteurService.getAllByActifTrueOrderByNomAsc();
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
    public MoniteurDTO saveMoniteur(@RequestBody MoniteurDTO moniteurDTO) {
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
    public MoniteurDTO updateMoniteur(@PathVariable UUID id, @RequestBody MoniteurDTO moniteurDTO) {
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
    public void deleteMoniteur(@PathVariable UUID id) {
        moniteurService.deleteMoniteur(id);
    }
}

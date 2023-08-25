package tms.tennismanagementsystem.app.inscriptionsformule;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.inscriptionsformule.exceptions.InscriptionFormuleNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class InscriptionFormuleController {

    private InscriptionFormuleService inscriptionFormuleService;
    /**
     * **************************************
     * *                                    *
     * *            GET Method              *
     * *                                    *
     * **************************************
     */
    @GetMapping("/inscriptionsformule")
    public List<InscriptionFormuleDTO> getAllInscriptionsFormule() {
        return inscriptionFormuleService.getAllInscriptionsFormule();
    }

    @GetMapping("/inscriptionsformule/{id}")
    public InscriptionFormuleDTO getInscriptionFormuleById(@PathVariable(name = "id")UUID id) throws InscriptionFormuleNotFoundException {
        return inscriptionFormuleService.getInscriptionFormuleById((id));
    }
    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/inscriptionsformule")
    public InscriptionFormuleDTO saveInscriptionFormule(@RequestBody InscriptionFormuleDTO inscriptionFormuleDTO) {
        return inscriptionFormuleService.saveInscriptionFormule(inscriptionFormuleDTO);
    }

    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */
    @PutMapping("/inscriptionsformule/{id}")
    public InscriptionFormuleDTO updateInscriptionFormule(@PathVariable UUID id, @RequestBody InscriptionFormuleDTO inscriptionFormuleDTO) {
        inscriptionFormuleDTO.setId(id);
        return inscriptionFormuleService.updateInscriptionFormule(inscriptionFormuleDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @ResponseStatus()
    @DeleteMapping("/inscriptionsformule/{id}")
    public void deleteInscriptionFormule(@PathVariable UUID id) {
        inscriptionFormuleService.deleteInscriptionFormuleDTO(id);
    }
}

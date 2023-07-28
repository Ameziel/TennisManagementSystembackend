package tms.tennismanagementsystem.app.inscriptionformule;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.inscriptionformule.exceptions.InscriptionFormuleNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class InscriptionFormuleController {

    private InscriptionFormuleService inscriptionFormuleService;

    @GetMapping("/inscriptionFormule")
    public List<InscriptionFormuleDTO> getAllEleves() {
        return inscriptionFormuleService.getAllInscriptionFormules();
    }

    @GetMapping("/inscriptionFormule/{id}")
    public InscriptionFormuleDTO getInscriptionFormule(@PathVariable(name = "id")String id) throws InscriptionFormuleNotFoundException {
        return inscriptionFormuleService.getInscriptionFormuleById(UUID.fromString(id));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/inscriptionFormule")
    public InscriptionFormuleDTO save(@RequestBody InscriptionFormuleDTO inscriptionFormuleDTO) {
        return inscriptionFormuleService.saveInscriptionFormule(inscriptionFormuleDTO);
    }

    @PutMapping("/inscriptionFormule/{id}")
    public InscriptionFormuleDTO updateEleve(@PathVariable UUID id, @RequestBody InscriptionFormuleDTO inscriptionFormuleDTO) {
        inscriptionFormuleDTO.setId(id);
        return inscriptionFormuleService.updateInscriptionFormule(inscriptionFormuleDTO);
    }
    @ResponseStatus()
    @DeleteMapping("/inscriptionFormule/{id}")
    public void deleteInscriptionFormule(@PathVariable UUID id) {
        inscriptionFormuleService.deleteInscriptionFormuleDTO(id);
    }
}
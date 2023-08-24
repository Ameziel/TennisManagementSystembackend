package tms.tennismanagementsystem.app.formulecours;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.formulecours.exceptions.FormuleNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class FormuleCoursController {

    private FormuleCoursService formuleCoursService;
    /**
     * **************************************
     * *                                    *
     * *            GET Method              *
     * *                                    *
     * **************************************
     */
    @GetMapping("/formulescours")
    public List<FormuleCoursDTO> getAllFormulesCours() {
        return formuleCoursService.getAllFormulesCours();
    }

    @GetMapping("/formulescours/{id}")
    public FormuleCoursDTO getFormulecours(@PathVariable(name = "id") UUID id) throws FormuleNotFoundException {
        return formuleCoursService.getFormuleCoursById((id));
    }
    @GetMapping("/formulescours/actifs")
    public List<FormuleCoursDTO> getAllActifsFormulesCours() {
        return formuleCoursService.getAllActifsFormulesCours();
    }
    @GetMapping("/formulescours/inactifs")
    public List<FormuleCoursDTO> getAllInactifsFormulesCours() {
        return formuleCoursService.getAllInactifsFormulesCours();
    }

    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/formulescours")
    public FormuleCoursDTO saveFormuleCours(@RequestBody FormuleCoursDTO formuleCoursDTO) {
        return formuleCoursService.saveFormuleCours(formuleCoursDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */
    @PutMapping("/formulescours/{id}")
    public FormuleCoursDTO updateFormuleCours(@PathVariable UUID id, @RequestBody FormuleCoursDTO formuleCoursDTO) {
        formuleCoursDTO.setId(id);
        return formuleCoursService.updateFormuleCours(formuleCoursDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @ResponseStatus()
    @DeleteMapping("/formulescours/{id}")
    public void deleteFormuleCours(@PathVariable UUID id) {
        formuleCoursService.deleteFormuleCours(id);
    }
}

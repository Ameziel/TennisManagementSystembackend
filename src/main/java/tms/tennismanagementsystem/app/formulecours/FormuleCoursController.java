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
    @GetMapping("/formulecours")
    public List<FormuleCoursDTO> getAllFormulesCours() {
        return formuleCoursService.getAllFormulesCours();
    }

    @GetMapping("/formulecours/{id}")
    public FormuleCoursDTO getFormulecours(@PathVariable(name = "id") String id) throws FormuleNotFoundException {
        return formuleCoursService.getFormuleCoursById(UUID.fromString(id));
    }

    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/formulecours")
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
    @PutMapping("/formulecours/{id}")
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
    @DeleteMapping("/formulecours/{id}")
    public void deleteFormuleCours(@PathVariable UUID id) {
        formuleCoursService.deleteFormuleCours(id);
    }
}

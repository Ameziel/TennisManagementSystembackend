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

    @GetMapping("/formulescours")
    public List<FormuleCoursDTO> getAllEleves() {
        return formuleCoursService.getAllFormulesCours();
    }

    @GetMapping("/formulescours/{id}")
    public FormuleCoursDTO getFormulecours(@PathVariable(name = "id") String id) throws FormuleNotFoundException {
        return formuleCoursService.getFormuleCoursById(UUID.fromString(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/formulescours")
    public FormuleCoursDTO save(@RequestBody FormuleCoursDTO formuleCoursDTO) {
        return formuleCoursService.saveFormuleCours(formuleCoursDTO);
    }

    @PutMapping("/formulescours/{id}")
    public FormuleCoursDTO updateEleve(@PathVariable UUID id, @RequestBody FormuleCoursDTO formuleCoursDTO) {
        formuleCoursDTO.setId(id);
        return formuleCoursService.updateFormuleCours(formuleCoursDTO);
    }

    @ResponseStatus()
    @DeleteMapping("/formulescours/{id}")
    public void deleteFormuleCours(@PathVariable UUID id) {
        formuleCoursService.deleteFormuleCours(id);
    }
}

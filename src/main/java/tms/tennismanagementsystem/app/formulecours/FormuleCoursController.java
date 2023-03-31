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

    @GetMapping("/formulecours")
    public List<FormuleCoursDTO> getAllEleves() {
        return formuleCoursService.getAllFormulesCours();
    }

    @GetMapping("/formulecours/{id}")
    public FormuleCoursDTO getFormulecours(@PathVariable(name = "id") String id) throws FormuleNotFoundException {
        return formuleCoursService.getFormuleCoursById(UUID.fromString(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/formulecours")
    public FormuleCoursDTO save(@RequestBody FormuleCoursDTO formuleCoursDTO) {
        return formuleCoursService.saveFormuleCours(formuleCoursDTO);
    }

    @PutMapping("/formulecours/{id}")
    public FormuleCoursDTO updateEleve(@PathVariable UUID id, @RequestBody FormuleCoursDTO formuleCoursDTO) {
        formuleCoursDTO.setId(id);
        return formuleCoursService.updateFormuleCours(formuleCoursDTO);
    }

    @ResponseStatus()
    @DeleteMapping("/formulecours/{id}")
    public void deleteFormuleCours(@PathVariable UUID id) {
        formuleCoursService.deleteFormuleCours(id);
    }
}

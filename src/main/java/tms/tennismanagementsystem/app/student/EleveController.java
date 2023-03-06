package tms.tennismanagementsystem.app.student;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.student.exceptions.EleveNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class EleveController {

    private EleveService eleveService;

    @GetMapping("/eleves")
    public List<EleveDTO> getAllEleves() {
        return eleveService.getAllEleves();
    }
    @GetMapping("/eleves/search")
    public List<EleveDTO> searchEleve(@RequestParam (name = "keyword", defaultValue = "") String keyword) {
        return eleveService.searchElevesByNames("%"+keyword+"%");
    }
    @GetMapping("/eleves/{id}")
    public EleveDTO getEleve(@PathVariable(name = "id")String id) throws EleveNotFoundException {
        return eleveService.getEleveById(UUID.fromString(id));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/eleves")
    public EleveDTO save(@RequestBody EleveDTO eleveDTO) {
        return eleveService.saveEleve(eleveDTO);
    }

    @PutMapping("/eleves/{id}")
    public EleveDTO updateEleve(@PathVariable UUID id, @RequestBody EleveDTO eleveDTO) {
        eleveDTO.setId(id);
        return eleveService.updateEleve(eleveDTO);
    }
    @ResponseStatus()
    @DeleteMapping("/eleves/{id}")
    public void deleteEleve(@PathVariable UUID id) {
        eleveService.deleteEleve(id);
    }
}

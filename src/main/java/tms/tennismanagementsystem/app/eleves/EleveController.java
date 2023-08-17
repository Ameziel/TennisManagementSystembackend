package tms.tennismanagementsystem.app.eleves;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.eleves.exceptions.EleveNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class EleveController {

    private EleveServiceImplementation eleveServiceImplementation;

    @GetMapping("/eleves")
    public List<EleveDTO> getAllEleves() {
        return eleveServiceImplementation.getAllEleves();
    }
    @GetMapping("/eleves/search")
    public List<EleveDTO> searchEleveByNames(@RequestParam (name = "keyword", defaultValue = "") String keyword) {
        return eleveServiceImplementation.searchElevesByNames("%"+keyword+"%");
    }
    @GetMapping("/eleves/{id}")
    public EleveDTO getEleveById(@PathVariable(name = "id")String id) throws EleveNotFoundException {
        return eleveServiceImplementation.getEleveById(UUID.fromString(id));
    }
    @PostMapping("/eleves")
    @ResponseStatus(HttpStatus.CREATED)
    public EleveDTO save(@RequestBody EleveDTO eleveDTO) {
        return eleveServiceImplementation.saveEleve(eleveDTO);
    }

    @PutMapping("/eleves/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EleveDTO updateEleve(@PathVariable UUID id, @RequestBody EleveDTO eleveDTO) {
        eleveDTO.setId(id);
        return eleveServiceImplementation.updateEleve(eleveDTO);
    }

    @DeleteMapping("/eleves/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEleve(@PathVariable UUID id) {
        eleveServiceImplementation.deleteEleve(id);
    }
}

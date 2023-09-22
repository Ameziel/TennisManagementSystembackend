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
    @GetMapping("/eleves/{id}")
    public EleveDTO getEleveById(@PathVariable(name = "id")UUID id) throws EleveNotFoundException {
        return eleveServiceImplementation.getEleveById((id));
    }
    @GetMapping("/eleves/search")
    public List<EleveDTO> searchEleveByNames(@RequestParam (name = "keyword", defaultValue = "") String keyword) {
        return eleveServiceImplementation.searchElevesByNames("%"+keyword+"%");
    }
    @GetMapping("/eleves/actifs")
    public List<EleveDTO> getAllActifsEleves() {
        return eleveServiceImplementation.getAllActifsEleves();
    }
    @GetMapping("/eleves/inactifs")
    public List<EleveDTO> getAllInactifsEleves() {
        return eleveServiceImplementation.getAllInactifsEleves();
    }
    @GetMapping("/eleves/email")
    public List<EleveDTO> getAllElevesByEmails(@RequestParam (name = "email", defaultValue = "") String email) {
        return eleveServiceImplementation.findAllByEmail(email);
    }
    @GetMapping("/eleves/allNameAsc")
    public List<EleveDTO> getAllByOrderByNomAsc() {
        return eleveServiceImplementation.getAllByOrderByNomAsc();
    }
    @GetMapping("/eleves/ActifsAndAllNameAsc")
    public List<EleveDTO> getAllActifsEleveAndOrderByNomAsc() {
        return eleveServiceImplementation.findAllByActifTrueOrderByNomAsc();
    }
    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @PostMapping("/eleves")
    @ResponseStatus(HttpStatus.CREATED)
    public EleveDTO saveEleve(@RequestBody EleveDTO eleveDTO) {
        return eleveServiceImplementation.saveEleve(eleveDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */
    @PutMapping("/eleves/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EleveDTO updateEleve(@PathVariable UUID id, @RequestBody EleveDTO eleveDTO) {
        eleveDTO.setId(id);
        return eleveServiceImplementation.updateEleve(eleveDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @DeleteMapping("/eleves/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEleve(@PathVariable UUID id) {
        eleveServiceImplementation.deleteEleve(id);
    }
}

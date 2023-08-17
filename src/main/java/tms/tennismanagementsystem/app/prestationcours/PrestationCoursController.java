package tms.tennismanagementsystem.app.prestationcours;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.prestationcours.exceptions.PrestationCoursNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class PrestationCoursController {

    private PrestationCoursService prestationCoursService;

    @GetMapping("/prestationscours")
    public List<PrestationCoursDTO> getAllPrestationCours() {
        return prestationCoursService.getAllPrestationsCours();
    }
//    @GetMapping("/prestationscours/search") //Mettre recherche par moniteur
//    public List<MoniteurDTO> search(@RequestParam(name = "keyword", defaultValue = "") String keyword) {
//        return prestationCoursService.searchMoniteursByNames("%"+keyword+"%");
//    }

    @GetMapping("/prestationscours/{id}")
    public PrestationCoursDTO getPrestationCours(@PathVariable(name = "id")String id) throws PrestationCoursNotFoundException {
        return prestationCoursService.getGPrestationCoursById(UUID.fromString(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/prestationscours")
    public PrestationCoursDTO save(@RequestBody PrestationCoursDTO prestationCoursDTO) {
        return prestationCoursService.savePrestationCours(prestationCoursDTO);
    }

    @PostMapping("/prestationscours/{id}")
    public PrestationCoursDTO updateEleve(@PathVariable UUID id, @RequestBody PrestationCoursDTO prestationCoursDTO) {
        prestationCoursDTO.setId(id);
        return prestationCoursService.updatePrestationCours(prestationCoursDTO);
    }
    @ResponseStatus()
    @DeleteMapping("/prestationscours/{id}")
    public void deletePrestationCours(@PathVariable UUID id) {
        prestationCoursService.deletePrestationCoursDTO(id);
    }
}

package tms.tennismanagementsystem.app.prestationcours;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tms.tennismanagementsystem.app.moniteur.exceptions.MoniteurNotFoundException;
import tms.tennismanagementsystem.app.prestationcours.exceptions.PrestationCoursNotFoundException;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping(path = "/api/v1")
public class PrestationCoursController {

    private PrestationCoursService prestationCoursService;
    /**
     * **************************************
     * *                                    *
     * *            GET Method              *
     * *                                    *
     * **************************************
     */
    @GetMapping("/prestationscours")
    public List<PrestationCoursDTO> getAllPrestationsCours() {
        return prestationCoursService.getAllPrestationsCours();
    }

    @GetMapping("/prestationscours/{id}")
    public PrestationCoursDTO getPrestationCoursById(@PathVariable(name = "id")String id) throws PrestationCoursNotFoundException {
        return prestationCoursService.getGPrestationCoursById(UUID.fromString(id));
    }

    /**
     * **************************************
     * *                                    *
     * *            POST Method             *
     * *                                    *
     * **************************************
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/prestationscours")
    public PrestationCoursDTO savePrestationCours(@RequestBody PrestationCoursDTO prestationCoursDTO) throws MoniteurNotFoundException {
        return prestationCoursService.savePrestationCours(prestationCoursDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Method              *
     * *                                    *
     * **************************************
     */
    @PutMapping("/prestationscours/{id}")
    public PrestationCoursDTO updatePrestationCours(@PathVariable UUID id, @RequestBody PrestationCoursDTO prestationCoursDTO) {
        prestationCoursDTO.setId(id);
        return prestationCoursService.updatePrestationCours(prestationCoursDTO);
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Method            *
     * *                                    *
     * **************************************
     */
    @ResponseStatus()
    @DeleteMapping("/prestationscours/{id}")
    public void deletePrestationCours(@PathVariable UUID id) {
        prestationCoursService.deletePrestationCoursDTO(id);
    }
}

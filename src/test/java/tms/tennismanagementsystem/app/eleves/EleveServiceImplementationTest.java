package tms.tennismanagementsystem.app.eleves;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tms.tennismanagementsystem.app.eleves.exceptions.EleveNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EleveServiceImplementationTest {

    @InjectMocks
    private EleveServiceImplementation eleveServiceImplementation;
    @Mock
    private EleveRepository eleveRepository;
    @Mock
    private EleveMapperImplementation eleveMapperImplementation;


                                /**
                                 * ╔══════════════════════════════════════════╗
                                 * ║                                          ║
                                 * ║                                          ║
                                 * ║                GET METHODS               ║
                                 * ║                                          ║
                                 * ║                                          ║
                                 * ╚══════════════════════════════════════════╝
                                 */
    @Test
    @DisplayName("╔════════════════════GetAllEleves════════════════════╗")
    void getAllEleves() {
        List<EleveEntity> expectedEleves = new ArrayList<>();
        EleveEntity eleve1 = new EleveEntity("5FD2CE6E-7358-204F-E15E-C8D9982160C4",
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve2 = new EleveEntity("5FD2CE6E-7358-204F-E15E-C8D9982160B4",
                "Alexandre","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve3 = new EleveEntity("5FD2CE6E-7358-204F-E15E-C8D9982160AA",
                "Addison","Mona",Genre.F,"04 12 12 89 88","addison.id@outlook.ca",
                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);

        expectedEleves.add(eleve1);
        expectedEleves.add(eleve2);
        expectedEleves.add(eleve3);
//        expectedEleves.set(0, eleveServiceImplementation.saveEleve(eleve1));
//        expectedEleves.set(1, eleveServiceImplementation.saveEleve(eleve2));
//        expectedEleves.set(2, eleveServiceImplementation.saveEleve(eleve3));
//        expectedEleves.forEach(e -> System.out.println(e));
        when(eleveRepository.findAll())
                .thenReturn(expectedEleves);
        when(eleveMapperImplementation.fromEleveEntity(any())).thenCallRealMethod();
        List<EleveDTO> savedEleves = eleveServiceImplementation.getAllEleves();
        assertEquals(expectedEleves.size(),savedEleves.size());
//        for(int i = 0; i < expectedEleves.size(); i++) {
//            assertEquals(expectedEleves.get(i),savedEleves.get(i));
//        }
    }

    @Test
    @DisplayName("╔════════════════════GetAllActifEleves════════════════════╗")
    void getAllActifEleves() {
        eleveRepository.deleteAll();
        List<EleveDTO> startData = new ArrayList<>();
        EleveDTO eleve1 = new EleveDTO("5FD2CE6E-7358-204F-E15E-C8D9982160F9",
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",false);
        EleveDTO eleve2 = new EleveDTO("5FD2CE6E-7358-204F-E15E-C8D9982160B1",
                "Alexandre","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",false);
        EleveDTO eleve3 = new EleveDTO(
                "Addison","Mona",Genre.F,"04 12 12 89 88","addison.id@outlook.ca",
                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);
        startData.add(eleve1);
        startData.add(eleve2);
        startData.add(eleve3);
        startData.set(0, eleveServiceImplementation.saveEleve(eleve1));
        startData.set(1, eleveServiceImplementation.saveEleve(eleve2));
        startData.set(2, eleveServiceImplementation.saveEleve(eleve3));

        List<EleveDTO> actifsEleves = eleveServiceImplementation.getAllActifsEleves();
        assertEquals(actifsEleves.get(0),startData.get(2));
        assertEquals(actifsEleves.size(), 1);

        //actifsEleves.forEach(e -> System.out.println(e));
        
    }

    /**
     * L'objet envoyé en base de données est dans un état correct
     * Vérifie que l'élève enregistré peut bien être récupéré en utilisant son ID.
     */
    @Test
    @DisplayName("╔════════════════════getEleveById════════════════════╗")
    void getEleveById() throws EleveNotFoundException {
        eleveRepository.deleteAll();
        EleveDTO eleveToSave = new EleveDTO(
                "Anthony","Moraux",Genre.H,"04 12 15 89 77","anthony.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveDTO savedEleve = eleveServiceImplementation.saveEleve(eleveToSave);
        EleveDTO testSavedEleve = eleveServiceImplementation.getEleveById(savedEleve.getId());
        assertEquals(savedEleve,testSavedEleve);
    }

    @Test
    @DisplayName("╔════════════════════FindByEmail════════════════════╗")
    void findByEmail() {
        eleveRepository.deleteAll();
        final String EMAIL = "margot.id@outlook.ca";
        List<EleveDTO> startData = new ArrayList<>();
        EleveDTO eleve1 = new EleveDTO(
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",false);
        EleveDTO eleve2 = new EleveDTO(
                "Alexandre","Duroy",Genre.H,"04 12 10 89 88","margot.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",false);
        EleveDTO eleve3 = new EleveDTO(
                "Addison","Mona",Genre.F,"04 12 12 89 88","addison.id@outlook.ca",
                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);
        startData.add(eleve1);
        startData.add(eleve2);
        startData.add(eleve3);
        startData.set(0, eleveServiceImplementation.saveEleve(eleve1));
        startData.set(1, eleveServiceImplementation.saveEleve(eleve2));
        startData.set(2, eleveServiceImplementation.saveEleve(eleve3));

        List<EleveDTO> savedEleves = eleveServiceImplementation.findByEmail(EMAIL); //TODO BUG à cause de JPA ? Optional<T>
//        findById(ID id)
//        Retrieves an entity by its id.
        // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html ça retourne un optional et donc pas une collection ?
        assertEquals(savedEleves.size(),2);



    }
    /**
     * L'objet envoyé en base de données est dans un état correct
     * Vérifie que l'élève enregistré correspond à celui saisit.
     */
    @Test
    @DisplayName("╔════════════════════SaveEleve════════════════════╗")
    void saveEleve() throws EleveNotFoundException {
        eleveRepository.deleteAll();
        EleveDTO eleveToSave = new EleveDTO(
                "Anthony","Moraux",Genre.H,"04 12 15 89 77","anthony.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveDTO e = eleveServiceImplementation.saveEleve(eleveToSave);
        eleveToSave.setId(e.getId());
        assertEquals(e,eleveToSave);
    }

    /**
     * L'object envoyé en base de données est dans un état correct.
     * On modifie un paramètre et on fait la mise à jour.
     * Le test vérifie que la modification apporté à l'objet l'est aussi en base de données en appelant la méthode
     * "update" du service.
     */
    @Test
    @DisplayName("╔════════════════════UpdateEleve════════════════════╗")
    void updateEleve() {
        eleveRepository.deleteAll();
        EleveDTO eleveToSave = new EleveDTO(
                "Anthony","Moraux",Genre.H,"04 12 15 89 77","anthony.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveDTO e = eleveServiceImplementation.saveEleve(eleveToSave);
        eleveToSave.setId(e.getId()); //Ici E contient l'objet tel qu'il est dans la BD.
        assertEquals(e.getId(),eleveToSave.getId()); //On vérifie que l'objet en BD est bien le même que celui de départ.
        e.setTelephone("aucun");
        eleveToSave.setTelephone("aucun");
        e = eleveServiceImplementation.updateEleve(e);
        assertEquals(e,eleveToSave);
    }

    @Test
    @DisplayName("╔════════════════════DeleteEleve════════════════════╗")
    void deleteEleve() throws EleveNotFoundException {
        eleveRepository.deleteAll();
        EleveDTO eleveToSave = new EleveDTO(
                "Anthony","Moraux",Genre.H,"04 12 15 89 77","anthony.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveDTO savedEleve = eleveServiceImplementation.saveEleve(eleveToSave);
        eleveServiceImplementation.deleteEleve(savedEleve.getId());
        //vérifier que la méthode a été appelé une seule fois ?
        //Et une seconde méthode pour dire que l'exception est bien levée ?

        Exception exception = assertThrows(EleveNotFoundException.class, () -> {
            eleveServiceImplementation.getEleveById(savedEleve.getId());
        });

    }

    @Test
    void searchElevesByNames() {
    }


}
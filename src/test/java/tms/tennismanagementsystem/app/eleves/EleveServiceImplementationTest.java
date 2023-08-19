package tms.tennismanagementsystem.app.eleves;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tms.tennismanagementsystem.app.eleves.exceptions.EleveNotFoundException;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EleveServiceImplementationTest {

    @Mock
    private EleveRepository eleveRepository;
    @Mock
    private EleveMapperImplementation eleveMapperImplementation;
    @InjectMocks
    private EleveServiceImplementation eleveServiceImplementation;
    /**
     * **************************************
     * *                                    *
     * *            GET Methods             *
     * *                                    *
     * **************************************
     */
    @Test
    @DisplayName("=================== getAll [good IN > good OUT ] ====================")
    public void test_GetAll_renvoitLaBonneListeDElevesQuandOnAUneListeDEleve() {
        EleveEntity eleve1 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve2 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D998216000"),
                "Alexandre","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve3 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160AA"),
                "Addison","Mona",Genre.F,"04 12 12 89 88","addison.id@outlook.ca",
                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);
        List<EleveEntity> dataEleves = Arrays.asList(eleve1,eleve2,eleve3);

        when(eleveRepository.findAll()).thenReturn(dataEleves);
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();

        List<EleveDTO> resultat = eleveServiceImplementation.getAllEleves();
        verify(eleveRepository,times(1)).findAll();
        verify(eleveMapperImplementation,times(dataEleves.size())).fromEleveEntity(any(EleveEntity.class));
        System.out.println("affichage des résultats");
//        resultat.forEach(e -> System.out.println(e));Affichage de controle
        for(int i = 0; i < dataEleves.size(); i ++) {
            assertEquals(dataEleves.get(i).getId(),resultat.get(i).getId());
        }
    }
    @Test
    @DisplayName("=================== getAll [Rien en IN > Rien en OUT ] ====================")
    public void test_GetAll_renvoitUneListeVideSiRienEnEntree() {
        List<EleveEntity> dataEleves = new ArrayList<>();
        when(eleveRepository.findAll()).thenReturn(dataEleves);
        List<EleveDTO> resultat = eleveServiceImplementation.getAllEleves();
        verify(eleveRepository,times(1)).findAll();
        verify(eleveMapperImplementation,times(dataEleves.size())).fromEleveEntity(any(EleveEntity.class));
        assertEquals(dataEleves.size(),resultat.size());
    }
    @Test
    @DisplayName("=================== getEleveById [Eleve{id} en IN > Eleve en OUT ] ====================")
    public void test_GetEleveById_renvoitUnEleveExistant() throws EleveNotFoundException {
        EleveEntity eleve = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        when(eleveRepository.findById(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"))).thenReturn(Optional.of(eleve));
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();
        when(eleveMapperImplementation.fromEleveDTO(any(EleveDTO.class))).thenCallRealMethod();

        EleveDTO resultatDTO = eleveServiceImplementation.getEleveById(eleve.getId());
        EleveEntity resultatEntity = eleveMapperImplementation.fromEleveDTO(resultatDTO);
        verify(eleveRepository,times(1)).findById(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"));
        verify(eleveMapperImplementation,times(1)).fromEleveEntity(any(EleveEntity.class));
        assertEquals(eleve,resultatEntity);
    }
    @Test
    @DisplayName("=================== getEleveById [Eleve{id} en IN > Exception en OUT ] ====================")
    public void test_GetEleveById_renvoitUneExeptionPourUnIDNonExistant() throws EleveNotFoundException {
        UUID id = UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9");
        Assertions.assertThrows(EleveNotFoundException.class, () -> {
            eleveServiceImplementation.getEleveById(id);
            throw new EleveNotFoundException();
        });
    }
    @Test
    @DisplayName("=================== test_searchElevesByNames [Ok en In > Ok en OUT ] ====================")
    public void test_searchElevesByNames() {
        EleveEntity eleve1 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve2 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D998216000"),
                "Martin","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
        List<EleveEntity> dataEleves = Arrays.asList(eleve1,eleve2);
        final String ARGUMENT = "Ma";

        when(eleveRepository.searchElevesByNames(ARGUMENT)).thenReturn(dataEleves);
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();

        List<EleveDTO> resultatDTO = eleveServiceImplementation.searchElevesByNames(ARGUMENT);
        verify(eleveRepository,times(1)).searchElevesByNames(ARGUMENT);
        for(int i = 0; i < dataEleves.size(); i++) {
            assertEquals(dataEleves.get(i).getId(), resultatDTO.get(i).getId());
        }
    }
    @Test
    @DisplayName("=================== test_getAllActifsEleves [Ok IN> Ok OUT ] ====================")
    public void test_getAllActifsEleves() {
        EleveEntity eleve1 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve2 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D998216000"),
                "Martin","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
        List<EleveEntity> dataEleves = Arrays.asList(eleve1,eleve2);

        when(eleveRepository.findAllByActifTrue()).thenReturn(dataEleves);
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();

        List<EleveDTO> resultatDTO = eleveServiceImplementation.getAllActifsEleves();
        verify(eleveRepository,times(1)).findAllByActifTrue();
        for(int i = 0; i < dataEleves.size(); i++) {
            assertEquals(dataEleves.get(i).getId(), resultatDTO.get(i).getId());
        }
    }
    @Test
    @DisplayName("=================== test_getAllInactifsEleves [Ok IN> Ok OUT ] ====================")
    public void test_getAllInactifsEleves() {
        EleveEntity eleve1 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",false);
        EleveEntity eleve2 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D998216000"),
                "Martin","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",false);
        List<EleveEntity> dataEleves = Arrays.asList(eleve1,eleve2);

        when(eleveRepository.findAllByActifFalse()).thenReturn(dataEleves);
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();

        List<EleveDTO> resultatDTO = eleveServiceImplementation.getAllInactifsEleves();
        verify(eleveRepository,times(1)).findAllByActifFalse();
        for(int i = 0; i < dataEleves.size(); i++) {
            assertEquals(dataEleves.get(i).getId(), resultatDTO.get(i).getId());
        }
    }
    //
    @Test
    @DisplayName("=================== test_findAllByEmail [Ok en In > Ok en OUT ] ====================")
    public void test_findAllByEmail() {
        EleveEntity eleve1 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve2 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D998216000"),
                "Martin","Duroy",Genre.H,"04 12 10 89 88","margot.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve3 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160AA"),
                "Addison","Mona",Genre.F,"04 12 12 89 88","margot.id@outlook.ca",
                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);
        List<EleveEntity> dataEleves = Arrays.asList(eleve1,eleve2,eleve3);
        final String EMAIL_ARGUMENT = "Ma";

        when(eleveRepository.findAllByEmail(EMAIL_ARGUMENT)).thenReturn(dataEleves);
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();

        List<EleveDTO> resultatDTO = eleveServiceImplementation.findAllByEmail(EMAIL_ARGUMENT);
        verify(eleveRepository,times(1)).findAllByEmail(EMAIL_ARGUMENT);
        for(int i = 0; i < dataEleves.size(); i++) {
            assertEquals(dataEleves.get(i).getId(), resultatDTO.get(i).getId());
        }
    }
    /**
     * **************************************
     * *                                    *
     * *            POST Methods            *
     * *                                    *
     * **************************************
     */
    @Test
    @DisplayName("=================== test_saveEleve [Ok en In > Ok en OUT ] ====================")
    public void test_saveEleve() {
        EleveEntity eleveToSave = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);

        EleveDTO eleveExpected = new EleveDTO(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);



        when(eleveRepository.save(eleveToSave)).thenReturn(eleveToSave);
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();
        when(eleveMapperImplementation.fromEleveDTO(any(EleveDTO.class))).thenCallRealMethod();

        EleveDTO resultatDTO = eleveServiceImplementation.saveEleve(eleveExpected);
        verify(eleveRepository,times(1)).save(eleveToSave);
        assertEquals(eleveExpected,resultatDTO);
        assertEquals(eleveToSave.getId(), resultatDTO.getId());
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Methods             *
     * *                                    *
     * **************************************
     */
    @Test
    @DisplayName("=================== test_updateEleve [Ok en In > Ok en OUT ] ====================")
    public void test_updateEleve() {
        final String EMAIL_CHANGING = "Emailde@test.fr";
        EleveEntity eleveToSave = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);

        EleveDTO eleveExpected = new EleveDTO(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);


        when(eleveRepository.save(eleveToSave)).thenReturn(eleveToSave);
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();
        when(eleveMapperImplementation.fromEleveDTO(any(EleveDTO.class))).thenCallRealMethod();

        EleveDTO resultatDTO = eleveServiceImplementation.saveEleve(eleveExpected);
        eleveExpected.setEmail(EMAIL_CHANGING);
//        System.out.println("Avant le service " + resultatDTO);
        resultatDTO = eleveServiceImplementation.saveEleve(resultatDTO);
//        System.out.println("Après le servce ?" + resultatDTO);
        verify(eleveRepository,times(2)).save(eleveToSave);
        System.out.println(eleveExpected);
        resultatDTO.setEmail(EMAIL_CHANGING);
        assertEquals(eleveExpected,resultatDTO);
        assertEquals(eleveToSave.getId(), resultatDTO.getId());
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Methods           *
     * *                                    *
     * **************************************
     */
    @Test
    @DisplayName("=================== test_sdeleteEleve [Ok en In > Ok en OUT ] ====================")
    public void test_deleteEleve() {
        final UUID idADelete = UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160AA");
        EleveEntity eleve1 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve2 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D998216000"),
                "Alexandre","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve3 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160AA"),
                "Addison","Mona",Genre.F,"04 12 12 89 88","addison.id@outlook.ca",
                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);
        List<EleveEntity> dataEleves = Arrays.asList(eleve1,eleve2,eleve3);

        //On part avec les données de départ
        when(eleveRepository.findAll()).thenReturn(dataEleves);
        when(eleveMapperImplementation.fromEleveEntity(any(EleveEntity.class))).thenCallRealMethod();

        //On vérifie que l'on obitent tout.
        List<EleveDTO> listeEleveAttendue = eleveServiceImplementation.getAllEleves();
        assertEquals(dataEleves.size(),listeEleveAttendue.size());
        //On supprime un élève
        eleveServiceImplementation.deleteEleve(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160AA"));
        verify(eleveRepository,times(1)).deleteById(idADelete);
    }
}
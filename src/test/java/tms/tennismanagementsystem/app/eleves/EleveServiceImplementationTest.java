package tms.tennismanagementsystem.app.eleves;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EleveServiceImplementationTest {

    @Mock
    private EleveRepository eleveRepository;
    @Mock
    private EleveMapperImplementation eleveMapperImplementation;

    @InjectMocks
    private EleveServiceImplementation eleveServiceImplementation;

//    private List<EleveEntity> fakeUsers = new ArrayList<>();
//
//    @BeforeEach
//    public void setup() {
//        EleveEntity eleve1 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
//                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
//                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
////        EleveEntity eleve2 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D998216000"),
////                "Alexandre","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
////                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
////        EleveEntity eleve3 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160AA"),
////                "Addison","Mona",Genre.F,"04 12 12 89 88","addison.id@outlook.ca",
////                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);
//        fakeUsers.add(eleve1);
//        System.out.println(eleve1);
//        fakeUsers.add(new EleveEntity());
//    }
    @Test
    public void testCHATGPT() {
        List<EleveEntity> fakeUsers = new ArrayList<>();
        EleveEntity eleve1 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve2 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D998216000"),
                "Alexandre","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
        EleveEntity eleve3 = new EleveEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160AA"),
                "Addison","Mona",Genre.F,"04 12 12 89 88","addison.id@outlook.ca",
                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);
        fakeUsers.add(eleve1);
        fakeUsers.add(eleve2);
        fakeUsers.add(eleve3);
        fakeUsers.forEach(e -> System.out.println(e));
//        given(eleveRepository).
        when(eleveRepository.findAll()).thenReturn(fakeUsers);
//        when(EleveMapperImplementation.m)
        List<EleveDTO> resultat = eleveServiceImplementation.getAllEleves();
        assertNotNull(resultat);
        System.out.println("affichage des résultats");
        resultat.forEach(e -> System.out.println(e));
//        assertEquals(fakeUsers.get(0),resultat.get(0));
    }

    @Test
    public void testGetAllEleves() {
        List<EleveDTO> expectedEleves = new ArrayList<>();
        EleveDTO eleve1 = new EleveDTO(
                "Margot","Iktoria",Genre.F,"04 12 15 45 88","margot.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);
        EleveDTO eleve2 = new EleveDTO(
                "Alexandre","Duroy",Genre.H,"04 12 10 89 88","alexandre.id@outlook.ca",
                LocalDate.of(1992, 5, 15),"Lorem ipsum",true);
        EleveDTO eleve3 = new EleveDTO(
                "Addison","Mona",Genre.F,"04 12 12 89 88","addison.id@outlook.ca",
                LocalDate.of(1991, 5, 15),"Lorem ipsum",true);
        expectedEleves.add(eleve1);
        expectedEleves.add(eleve2);
        expectedEleves.add(eleve3);

        // Définir le comportement du mock pour la méthode userRepository.findAll()
//        when(eleveRepository.findAll()).thenReturn();

        // Appeler la méthode du service que vous testez
        List<EleveDTO> result = eleveServiceImplementation.getAllEleves();

        // Vérifier les appels et les résultats
        verify(eleveRepository, times(1)).findAll(); // Vérifier que userRepository.findAll() a été appelé une fois
        assertEquals(2, result.size());
    }


}
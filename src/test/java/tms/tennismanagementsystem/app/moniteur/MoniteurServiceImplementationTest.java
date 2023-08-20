package tms.tennismanagementsystem.app.moniteur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tms.tennismanagementsystem.app.moniteur.exceptions.MoniteurNotFoundException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MoniteurServiceImplementationTest {

    @Mock
    private MoniteurRepository moniteurRepository;
    @Mock
    private MoniteurMapperImplementation moniteurMapperImplementation;
    @InjectMocks
    private MoniteurServiceImplementation moniteurServiceImplementation;


    /**
     * **************************************
     * *                                    *
     * *            GET Methods             *
     * *                                    *
     * **************************************
     */
    @Test
    @DisplayName("=================== getAll [good IN > good OUT ] ====================")
    public void test_GetAll_renvoitLaBonneListeDeMoniteurQuandOnAUneListeDeMoniteur() {
        MoniteurEntity moniteur1 = new MoniteurEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , true);
        MoniteurEntity moniteur2 = new MoniteurEntity(UUID.fromString("122A2ED4-ED45-ADB9-A68C-2E5D8D36240"),
                "Dumont", "Antoine", "ant.dum@yahoo.be", "04 58 28 42 41", QualificationMoniteur.INITIATEUR
                , true);
        MoniteurEntity moniteur3 = new MoniteurEntity(UUID.fromString("676AD84B-36A0-47E9-9354-C7E24C673016"),
                "Roylt", "Vanessa", "vanessa@gmail.fr", "07 01 25 42 41", QualificationMoniteur.ENTRAINEUR
                , true);

        List<MoniteurEntity> dataMoniteurs = Arrays.asList(moniteur1, moniteur2, moniteur3);

        when(moniteurRepository.findAll()).thenReturn(dataMoniteurs);
        when(moniteurMapperImplementation.fromMoniteurEntity(any(MoniteurEntity.class))).thenCallRealMethod();

        List<MoniteurDTO> resultat = moniteurServiceImplementation.getAllMoniteurs();
        verify(moniteurRepository, times(1)).findAll();
        verify(moniteurMapperImplementation, times(dataMoniteurs.size())).fromMoniteurEntity(any(MoniteurEntity.class));
//        resultat.forEach(e -> System.out.println(e));Affichage de controle
        for (int i = 0; i < dataMoniteurs.size(); i++) {
            assertEquals(dataMoniteurs.get(i).getId(), resultat.get(i).getId());
        }
    }

    @Test
    @DisplayName("=================== getAll [Rien en IN > Rien en OUT ] ====================")
    public void test_GetAll_renvoitUneListeVideSiRienEnEntree() {
        List<MoniteurEntity> dataMoniteur = new ArrayList<>();
        when(moniteurRepository.findAll()).thenReturn(dataMoniteur);
        List<MoniteurDTO> resultat = moniteurServiceImplementation.getAllMoniteurs();
        verify(moniteurRepository, times(1)).findAll();
        verify(moniteurMapperImplementation, times(dataMoniteur.size())).fromMoniteurEntity(any(MoniteurEntity.class));
        assertEquals(dataMoniteur.size(), resultat.size());
    }

    @Test
    @DisplayName("=================== getMoniteurById [Moniteur{id} en IN > Moniteur en OUT ] ====================")
    public void test_GetEleveById_renvoitUnMoniteurExistant() throws MoniteurNotFoundException {
        MoniteurEntity moniteur = new MoniteurEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , true);
        when(moniteurRepository.findById(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"))).thenReturn(Optional.of(moniteur));
        when(moniteurMapperImplementation.fromMoniteurEntity(any(MoniteurEntity.class))).thenCallRealMethod();
        when(moniteurMapperImplementation.fromMoniteurDTO(any(MoniteurDTO.class))).thenCallRealMethod();

        MoniteurDTO resultatDTO = moniteurServiceImplementation.getMoniteurById(moniteur.getId());
        MoniteurEntity resultatEntity = moniteurMapperImplementation.fromMoniteurDTO(resultatDTO);
        verify(moniteurRepository, times(1)).findById(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"));
        verify(moniteurMapperImplementation, times(1)).fromMoniteurEntity(any(MoniteurEntity.class));
        assertEquals(moniteur, resultatEntity);
    }
    @Test
    @DisplayName("=================== getMoniteurById [Moniteur{id} en IN > Exception en OUT ] ====================")
    public void test_GetMoniteurById_renvoitUneExeptionPourUnIDNonExistant() throws MoniteurNotFoundException {
        final UUID id = UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9");
        Assertions.assertThrows(MoniteurNotFoundException.class, () -> {
            moniteurServiceImplementation.getMoniteurById(id);
            throw new MoniteurNotFoundException();
        });
    }
    @Test
    @DisplayName("=================== test_getAllActifsMoniteurs [Ok IN> Ok OUT ] ====================")
    public void test_getAllActifsMoniteurs() {
        MoniteurEntity moniteur1 = new MoniteurEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , true);
        MoniteurEntity moniteur2 = new MoniteurEntity(UUID.fromString("122A2ED4-ED45-ADB9-A68C-2E5D8D36240"),
                "Dumont", "Antoine", "ant.dum@yahoo.be", "04 58 28 42 41", QualificationMoniteur.INITIATEUR
                , true);
        MoniteurEntity moniteur3 = new MoniteurEntity(UUID.fromString("676AD84B-36A0-47E9-9354-C7E24C673016"),
                "Roylt", "Vanessa", "vanessa@gmail.fr", "07 01 25 42 41", QualificationMoniteur.ENTRAINEUR
                , true);

        List<MoniteurEntity> dataMoniteurs = Arrays.asList(moniteur1, moniteur2, moniteur3);

        when(moniteurRepository.findAllByActifTrue()).thenReturn(dataMoniteurs);
        when(moniteurMapperImplementation.fromMoniteurEntity(any(MoniteurEntity.class))).thenCallRealMethod();

        List<MoniteurDTO> resultatDTO = moniteurServiceImplementation.getAllActifsMoniteurs();
        verify(moniteurRepository,times(1)).findAllByActifTrue();
        for(int i = 0; i < dataMoniteurs.size(); i++) {
            assertEquals(dataMoniteurs.get(i).getId(), resultatDTO.get(i).getId());
        }
    }
    @Test
    @DisplayName("=================== test_getAllInactifsMoniteurs [Ok IN> Ok OUT ] ====================")
    public void test_getAllInactifsMoniteurs() {
        MoniteurEntity moniteur1 = new MoniteurEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , false);
        MoniteurEntity moniteur2 = new MoniteurEntity(UUID.fromString("122A2ED4-ED45-ADB9-A68C-2E5D8D36240"),
                "Dumont", "Antoine", "ant.dum@yahoo.be", "04 58 28 42 41", QualificationMoniteur.INITIATEUR
                , false);
        MoniteurEntity moniteur3 = new MoniteurEntity(UUID.fromString("676AD84B-36A0-47E9-9354-C7E24C673016"),
                "Roylt", "Vanessa", "vanessa@gmail.fr", "07 01 25 42 41", QualificationMoniteur.ENTRAINEUR
                , false);

        List<MoniteurEntity> dataMoniteurs = Arrays.asList(moniteur1, moniteur2, moniteur3);

        when(moniteurRepository.findAllByActifFalse()).thenReturn(dataMoniteurs);
        when(moniteurMapperImplementation.fromMoniteurEntity(any(MoniteurEntity.class))).thenCallRealMethod();

        List<MoniteurDTO> resultatDTO = moniteurServiceImplementation.getAllInactifsMoniteurs();
        verify(moniteurRepository,times(1)).findAllByActifFalse();
        for(int i = 0; i < dataMoniteurs.size(); i++) {
            assertEquals(dataMoniteurs.get(i).getId(), resultatDTO.get(i).getId());
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
    @DisplayName("=================== test_saveMoniteur [Ok en In > Ok en OUT ] ====================")
    public void test_saveMoniteur() {
        MoniteurEntity moniteurToSave = new MoniteurEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , false);

        MoniteurDTO moniteurExpected = new MoniteurDTO(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , false);

        when(moniteurRepository.save(moniteurToSave)).thenReturn(moniteurToSave);
        when(moniteurMapperImplementation.fromMoniteurEntity(any(MoniteurEntity.class))).thenCallRealMethod();
        when(moniteurMapperImplementation.fromMoniteurDTO(any(MoniteurDTO.class))).thenCallRealMethod();

        MoniteurDTO resultatDTO = moniteurServiceImplementation.saveMoniteur(moniteurExpected);
        verify(moniteurRepository,times(1)).save(moniteurToSave);
        assertEquals(moniteurExpected,resultatDTO);
        assertEquals(moniteurToSave.getId(), resultatDTO.getId());
    }
    /**
     * **************************************
     * *                                    *
     * *            PUT Methods             *
     * *                                    *
     * **************************************
     */
    @Test
    @DisplayName("=================== test_updateMoniteur [Ok en In > Ok en OUT ] ====================")
    public void test_updateMoniteur() {
        final String EMAIL_CHANGING = "Emailde@test.fr";
        MoniteurEntity moniteurToSave = new MoniteurEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , false);

        MoniteurDTO moniteurExpected = new MoniteurDTO(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , false);
        when(moniteurRepository.save(moniteurToSave)).thenReturn(moniteurToSave);
        when(moniteurMapperImplementation.fromMoniteurEntity(any(MoniteurEntity.class))).thenCallRealMethod();
        when(moniteurMapperImplementation.fromMoniteurDTO(any(MoniteurDTO.class))).thenCallRealMethod();

        MoniteurDTO resultatDTO = moniteurServiceImplementation.updateMoniteur(moniteurExpected);
        moniteurExpected.setEmail(EMAIL_CHANGING);
//        System.out.println("Avant le service " + resultatDTO);
        resultatDTO = moniteurServiceImplementation.saveMoniteur(resultatDTO);
        //        System.out.println("Après le servce ?" + resultatDTO);
        verify(moniteurRepository, times(2)).save(moniteurToSave);
        System.out.println(moniteurExpected);
        resultatDTO.setEmail(EMAIL_CHANGING);
        assertEquals(moniteurExpected, resultatDTO);
        assertEquals(moniteurToSave.getId(), resultatDTO.getId());
    }
    /**
     * **************************************
     * *                                    *
     * *           DELETE Methods           *
     * *                                    *
     * **************************************
     */
    @Test
    void test_deleteMoniteur() {
        final UUID id = UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9");
        MoniteurEntity moniteur1 = new MoniteurEntity(UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),
                "Clarke", "Dalton", "nunc@yahoo.edu", "03 98 25 42 41", QualificationMoniteur.ANIMATEUR
                , true);
        MoniteurEntity moniteur2 = new MoniteurEntity(UUID.fromString("122A2ED4-ED45-ADB9-A68C-2E5D8D36240"),
                "Dumont", "Antoine", "ant.dum@yahoo.be", "04 58 28 42 41", QualificationMoniteur.INITIATEUR
                , true);
        MoniteurEntity moniteur3 = new MoniteurEntity(UUID.fromString("676AD84B-36A0-47E9-9354-C7E24C673016"),
                "Roylt", "Vanessa", "vanessa@gmail.fr", "07 01 25 42 41", QualificationMoniteur.ENTRAINEUR
                , true);

        List<MoniteurEntity> dataMoniteurs = Arrays.asList(moniteur1, moniteur2, moniteur3);

        //On part avec les données de départ
        when(moniteurRepository.findAll()).thenReturn(dataMoniteurs);
        when(moniteurMapperImplementation.fromMoniteurEntity(any(MoniteurEntity.class))).thenCallRealMethod();

        //On vérifie que l'on obitent tout.
        List<MoniteurDTO> listeMoniteurAttendue = moniteurServiceImplementation.getAllMoniteurs();
        assertEquals(dataMoniteurs.size(),listeMoniteurAttendue.size());
        //On supprime un moniteur
        moniteurServiceImplementation.deleteMoniteur(id);
        verify(moniteurRepository,times(1)).deleteById(id);
    }
}
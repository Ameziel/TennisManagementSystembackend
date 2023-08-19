package tms.tennismanagementsystem.app.eleves;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
@SpringJUnitConfig(EleveControllerTest.class)
@ContextConfiguration(classes = {EleveController.class})
class EleveControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EleveServiceImplementation eleveServiceImplementation;
    private String API_VERSION = "/api/v1";
    @Test
    void getAllEleves() throws Exception {
        //Toujours donner des données, voir s'il ne faut pas mettre un
        mockMvc.perform(get(API_VERSION+ "/eleves"))
                .andExpect(status().isOk());
        verify(eleveServiceImplementation, times(1)).getAllEleves();

    }

    @Test
    void searchEleveByNames() {
    }

    @Test
    void getEleve() {
    }

    @Test
    void save() throws Exception {
        EleveDTO eleveTOSave =        new EleveDTO(
                UUID.fromString("5FD2CE6E-7358-204F-E15E-C8D9982160F9"),"Addison","Mona",Genre.F,"04 12 15 89 88","augue.id@outlook.ca",
                LocalDate.of(1990, 5, 15),"Lorem ipsum",true);

        MvcResult result = mockMvc.perform(
                post("API_VERSION + /eleves")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(eleveTOSave.toString())
        ).andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void updateEleve() {
    }

    @Test
    void deleteEleve() {
    }
}
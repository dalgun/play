package dalgun.github.io.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import dalgun.github.io.web.endpoint.ReservationController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author dalgun
 * @since 2019-11-04
 */
@Slf4j
@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@WebMvcTest(ReservationController.class)
public class MockMvcTest {

    @Autowired
    private MockMvc mvc;

    Map<String, String> reqMap;


    @Before
    public void init(){
        reqMap = new HashMap<>();
        reqMap.put("reservationDt", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        reqMap.put("reservationTm", LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHMMss")));
    }

    @Test
    public void SIMPLE_RESERVATION_TEST() throws Exception{

        reqMap.put("reservationType", "SIMPLE");

        mvc.perform(MockMvcRequestBuilders
                .post("/reservation/v1")
                .content(asJsonString(reqMap))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void CONSULTING_RESERVATION_TEST() throws Exception{

        reqMap.put("reservationType", "CONSULTING");
        reqMap.put("consultingType", "FAMILY");
        reqMap.put("memo", "Long Long ago..");

        mvc.perform(MockMvcRequestBuilders
                .post("/reservation/v1")
                .content(asJsonString(reqMap))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void DIAGNOSIS_RESERVATION_TEST() throws Exception{

        reqMap.put("reservationType", "DIAGNOSIS");
        reqMap.put("symptom", "Ouch..That's hurts");

        mvc.perform(MockMvcRequestBuilders
                .post("/reservation/v1")
                .content(asJsonString(reqMap))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().is2xxSuccessful());
    }



    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

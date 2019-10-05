package io.github.similar_words_generator.web_app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SeedControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private String path = "/";

    @Test
    public void seedsShouldReturnStatusOK() throws Exception {
        mockMvc.perform(get(path)
                .contentType(MediaType.TEXT_HTML)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }

    @Test
    public void sampleSeedShouldReturnStatusOK() throws Exception {
        mockMvc.perform(get(path + "/static/seeds")
                .contentType(MediaType.TEXT_HTML)
                .accept(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }
}

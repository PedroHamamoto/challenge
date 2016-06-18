package br.com.challenge.view.endpoint;

import br.com.challenge.ApplicationConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
@WebAppConfiguration
public class ZipcodeEndpointTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.
                webAppContextSetup(context)
                .build();
    }

    @Test
    public void shouldGetAZipcode() throws Exception {
        mvc.perform(get("/cep/{cep}", "12345678"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.uri", is("/cep/12345678")))
                .andExpect(jsonPath("$.item.zipcode", is("12345678")))
                .andExpect(jsonPath("$.item.neighborhood", is("neighborhood")))
                .andExpect(jsonPath("$.item.state", is("state")))
                .andExpect(jsonPath("$.item.city", is("city")));
    }
}
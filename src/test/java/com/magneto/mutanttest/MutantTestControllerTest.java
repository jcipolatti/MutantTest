package com.magneto.mutanttest;

import com.magneto.mutanttest.controller.DnaController;
import com.magneto.mutanttest.model.DnaModel;
import com.magneto.mutanttest.repository.DnaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(value = DnaController.class)
public class MutantTestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DnaRepository dnaRepository;

    @Test
    public void whenIsMutant_thenReturns200() throws Exception {

        String exampleDnaJson = "{\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/mutant/")
                .accept(MediaType.APPLICATION_JSON).content(exampleDnaJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

    @Test
    public void whenIsNotMutant_thenReturns403() throws Exception {

        String exampleDnaJson = "{\"dna\":[\"ATGCGA\",\"CAGTGC\",\"TATTGT\",\"AGAAGG\",\"ACCCTA\",\"TCACTG\"]}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/mutant/")
                .accept(MediaType.APPLICATION_JSON).content(exampleDnaJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.FORBIDDEN.value(), response.getStatus());

    }

    @Test
    public void whenInvalidCharacterInput_thenReturns400() throws Exception {

        String exampleDnaJson = "{\"dna\":[\"ATGXGA\",\"CAGTGC\",\"TTATGT\",\"AGAAGG\",\"CCCCTA\",\"TCACTG\"]}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/mutant/")
                .accept(MediaType.APPLICATION_JSON).content(exampleDnaJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());

    }

    @Test
    public void whenRatioIsNull() throws Exception {

        Random r = new Random();
        Long mutantCount = r.nextLong();

        Mockito.when(dnaRepository.getMutantCount()).thenReturn(mutantCount);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/stats");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected =
                "{\"count_mutant_dna\":" + mutantCount +
                        ",\"count_human_dna\":0,\"ratio\":null}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void whenRatioIsNotNull() throws Exception {

        Random r = new Random();
        Long mutantCount = r.nextLong() & Long.MAX_VALUE;
        Long humanCount = r.nextLong() & Long.MAX_VALUE;
        Long ratio = mutantCount / humanCount;

        Mockito.when(dnaRepository.getMutantCount()).thenReturn(mutantCount);
        Mockito.when(dnaRepository.getHumanCount()).thenReturn(humanCount);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/stats");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());

        String expected =
                "{\"count_mutant_dna\":" + mutantCount
                        + ",\"count_human_dna\":" + humanCount
                        + ",\"ratio\":" + ratio + "}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

    @Test
    public void coverageForInternalMandatoryMethods() throws Exception {
        DnaModel mockDna = new DnaModel();
        mockDna.getDna();
    }
}

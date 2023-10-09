package com.example.tone_test_task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
class ToneTestTaskApplicationTests {

    @Autowired
    MockMvc mockMvc;

    static String url = "http://localhost:8080/frequency";

    @Test
    void give_empty_returns_empty_hashmap() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "text": ""
                                }
                                """))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {}
                        """));
    }

    @Test
    void give_one_letter_returns_one_letter_hashmap() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "text": "a"
                                }
                                """))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "a": 1
                        }
                        """));
    }
    @Test
    void frequency_valid_test_1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "text": "aaabb"
                                }
                                """))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "a": 3,
                            "b": 2
                        }
                        """));
    }

    @Test
    void frequency_valid_test_2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "text": "abbaac"
                                }
                                """))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "a": 2,
                            "b": 2,
                            "c": 1
                        }
                        """));
    }

    @Test
    void frequency_valid_test_3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                    "text": "ababaccaa"
                                }
                                """))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.content().json("""
                        {
                            "a": 2,
                            "b": 1,
                            "c": 2
                        }
                        """));
    }
}

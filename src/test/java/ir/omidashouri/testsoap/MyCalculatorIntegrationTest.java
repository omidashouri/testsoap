package ir.omidashouri.testsoap;

import ir.omidashouri.testsoap.services.CalculatorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = TestsoapApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MyCalculatorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void testAdd() throws Exception {
        mockMvc.perform(post("/calculator/add/5/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }

    @Test
    void testSubtract() throws Exception {
        mockMvc.perform(post("/calculator/subtract/10/4"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test
    void testMultiply() throws Exception {
        mockMvc.perform(post("/calculator/multiply/7/6"))
                .andExpect(status().isOk())
                .andExpect(content().string("42"));
    }

    @Test
    void testDivide() throws Exception {
        mockMvc.perform(post("/calculator/divide/10/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    void testDivideByZero() throws Exception {
        mockMvc.perform(post("/calculator/divide/10/0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Cannot divide by zero."));
    }
}

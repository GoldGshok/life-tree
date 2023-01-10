package my.goldgshok.life_tree;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public abstract class ControllerTest {

    private final ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    public ControllerTest() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    protected <T> String convertToJson(T body) {
        try {
            return objectMapper.writeValueAsString(body);
        } catch (Exception e) {
            log.error("Can't convert object to JSON", e);
            throw new RuntimeException(e);
        }
    }

    protected <T> T convertToModel(String json, TypeReference<T> typeReference) {
        try {
            return objectMapper.readValue(json, typeReference);
        } catch (Exception e) {
            log.error("Can't convert object to JSON", e);
            throw new RuntimeException(e);
        }
    }

    protected String perform(RequestBuilder request, ResultMatcher result) {
        try {
            return mockMvc.perform(request)
                    .andDo(print())
                    .andExpect(result)
                    .andReturn()
                    .getResponse()
                    .getContentAsString(StandardCharsets.UTF_8);
        } catch (Exception e) {
            log.error("Can't perform request", e);
            throw new RuntimeException(e);
        }
    }
}

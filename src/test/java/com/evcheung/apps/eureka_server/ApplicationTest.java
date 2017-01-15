package com.evcheung.apps.eureka_server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {
    @Value("${local.server.port}")
    private int port = 0;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_load_catalog() throws Exception {
        ResponseEntity<Map> entity = restTemplate.getForEntity("http://localhost:" + port + "/eureka/apps", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());

    }

    @Test
    public void should_load_env() {
        ResponseEntity<Map> entity = restTemplate.getForEntity("http://localhost:" + port + "/env", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }
}

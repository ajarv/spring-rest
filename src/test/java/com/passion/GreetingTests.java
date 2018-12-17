package com.passion;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingTests {

	@Autowired
    private TestRestTemplate rest;

    @Test
    public void availableTest() {
        String resp = rest.getForObject("/v1/greeting", String.class);
        assertThat(resp).contains("Hello, World");
    }

}

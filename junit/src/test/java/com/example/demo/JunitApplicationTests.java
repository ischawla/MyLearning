package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.controller.BookController;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BookController.class})
class JunitApplicationTests {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void sayHelloTest() throws Exception {
			BookController controller = new BookController();
	        String result = controller.sayHello();
	        assertEquals(result, "Hello World");
	}

}

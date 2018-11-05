package br.com.namom.mytimeline.timeline;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.namom.mytimeline.app.App;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class TimelineControllerTest {
	
	@Autowired
	private TimelineController controller;
	
	@Autowired
	private TimelineRepository repository;
	
	@Autowired
	private MockMvc mvc;

	@Test
	public void test() throws Exception {
		
		// cenario
		//repository.save(new )
		
		
		mvc.perform(get("/mytimeline")
						.contentType(MediaType.APPLICATION_JSON_UTF8)
					)
			.andDo(print())
			.andExpect(status().isOk())
//			.andExpect(content().)
	     ;
		
	}

}

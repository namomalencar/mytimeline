package br.com.namom.mytimeline.timeline;

import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.namom.mytimeline.app.App;

@ActiveProfiles("test")
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes=App.class)
public class TimelineServiceTest {

	@Autowired
	private TimelineService service;
	
	@Test
	public void shouldSaveANewTimeline() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("My New Timeline");
		
		// action
		service.save(t);

		// validation
		
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void shouldNotSaveANewTimelineWhenEmpty() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("");
		
		// action
		try {
			service.save(t);
		} catch (ConstraintViolationException e) {
//			assertErrorFieldFor(e, "nome", "xxxxxx");
//			assertErrorFieldFor(e, "nome", "xxxxxx");
//			assertErrorFieldFor(e, "nome", "xxxxxx");
		}

		// validation
		
	}

	private void assertErrorFieldFor(ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		for (ConstraintViolation<?> cv : violations) {
			cv.getPropertyPath();
		}
	}


}

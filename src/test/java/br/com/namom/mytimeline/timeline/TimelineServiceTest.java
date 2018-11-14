package br.com.namom.mytimeline.timeline;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
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
@SpringBootTest(classes = App.class)
public class TimelineServiceTest {

	@Autowired
	private TimelineService service;

	@Test
	public void shouldSaveANewTimeline() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("My New Timeline");

		// action
		try {
			service.save(t);
		} catch (Exception e) {
			// validation
			assertTrue(false);
		}
	}

	@Test
	public void shouldNotSaveANewTimelineWhenEmpty() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("");

		// action
		try {
			service.save(t);
		} catch (ConstraintViolationException e) {
			// validation
			assertTrue(this.getViolationField(e).equalsIgnoreCase("name"));
		}
	}

	@Test
	public void shouldNotSaveANewTimelineWhenNull() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName(null);

		// action
		try {
			service.save(t);
		} catch (ConstraintViolationException e) {
			// validation
			assertTrue(this.getViolationField(e).equalsIgnoreCase("name"));
		}
	}

	@Test
	public void shouldNotSaveANewTimelineWhenLenghtNameLessThanTwo() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("a");

		// action
		try {
			service.save(t);
		} catch (ConstraintViolationException e) {
			// validation
			assertTrue(this.getViolationField(e).equalsIgnoreCase("name"));
		}
	}

	@Test
	public void shouldSaveANewTimelineWhenLenghtNameIsIgualTwo() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("ab");

		// action
		service.save(t);
		
		// validation
		List<Timeline> listTimeline = service.findAll();
		assertTrue(listTimeline.size() == 1);
	}

	@Test
	public void shouldSaveANewTimelineWhenLenghtNameIsHigherThanTwo() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("abc");

		// action
		try {
			service.save(t);
		} catch (Exception e) {
			// validation
			assertTrue(false);
		}
	}

	private String getViolationField(ConstraintViolationException e) {
		Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
		ConstraintViolationImpl<?> violation = (ConstraintViolationImpl<?>) violations.iterator().next();
		return violation.getPropertyPath().toString();
	}

}

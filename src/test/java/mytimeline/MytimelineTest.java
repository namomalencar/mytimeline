package mytimeline;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.namom.mytimeline.timeline.Timeline;
import br.com.namom.mytimeline.timeline.TimelineService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MytimelineTest {
	
	private TimelineService service;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Transactional
	@Test
	public void shouldSaveANewTimeline() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("My New Timeline");
		
		// action
		service.save(t);

		// validation
		
	}
	
	@Transactional
	@Test
	public void shouldNotSaveANewTimelineWhenEmpty() throws Exception {
		// scenario
		Timeline t = new Timeline();
		t.setName("");
		
		// action
		service.save(t);

		// validation
		
	}

}

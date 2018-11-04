package br.com.namom.mytimeline.timeline;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.namom.mytimeline.generic.controller.GenericController;

@RestController
@RequestMapping(path = "/mytimeline", produces = MediaType.APPLICATION_JSON_VALUE)
public class TimelineController extends GenericController<TimelineService, Timeline, Long> {

}

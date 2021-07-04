package com.thomasvitale.streamfunction;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.cloud.stream.binder.test.TestChannelBinderConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.messaging.support.GenericMessage;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestChannelBinderConfiguration.class)
class StreamFunctionApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	private InputDestination input;

	@Autowired
	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	private OutputDestination output;

	@Test
	void testFunctionDefinitionApi() throws JsonProcessingException {
		Instrument inputInstrument = new Instrument("piano");
		Skill expectedOutputSkill = new Skill("I can play the PIANO");
		this.input.send(new GenericMessage<>(objectMapper.writeValueAsBytes(inputInstrument)));
		assertThat(output.receive().getPayload()).isEqualTo(objectMapper.writeValueAsBytes(expectedOutputSkill));
	}

}
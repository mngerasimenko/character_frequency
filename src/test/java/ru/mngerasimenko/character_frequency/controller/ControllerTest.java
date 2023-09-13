package ru.mngerasimenko.character_frequency.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mngerasimenko.character_frequency.exception_handling.IncorrectSourceStringException;
import ru.mngerasimenko.character_frequency.service.CharacterFrequencyService;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

	@Mock
	private CharacterFrequencyService service;

	@InjectMocks
	Controller controller;

	@Test()
	void calculateCharacterFrequency_InvalidSourceString() {
		String source = "aaaa ff b";

		Throwable thrown = assertThrows(IncorrectSourceStringException.class,
				() -> this.controller.calculateCharacterFrequency(source));

		assertNotNull(thrown.getMessage());
	}
}
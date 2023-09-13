package ru.mngerasimenko.character_frequency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mngerasimenko.character_frequency.exception_handling.IncorrectData;
import ru.mngerasimenko.character_frequency.exception_handling.IncorrectSourceStringException;
import ru.mngerasimenko.character_frequency.service.CharacterService;

import java.util.Map;

@RestController
@RequestMapping("/api/frequency-character")
public class Controller {

	private final CharacterService service;

	@Autowired
	public Controller(CharacterService service) {
		this.service = service;
	}

	@GetMapping("/{sourceString}")
	public Map<Character, Integer> calculateCharacterFrequency(@PathVariable String sourceString) {
		sourceString = sourceString.trim();
		if (sourceString.contains(" ")) {
			throw new IncorrectSourceStringException("The string cannot contain space characters");
		}

		return service.calculateCharacterFrequency(sourceString);
	}

	@GetMapping("/")
	public void emptySourceString() {
		throw new IncorrectSourceStringException("The request cannot be empty");
	}

	@ExceptionHandler
	public ResponseEntity<IncorrectData> handleException(IncorrectSourceStringException exception) {
		IncorrectData incorrectData = new IncorrectData();
		incorrectData.setInfo(exception.getMessage());

		return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
	}
}

package ru.mngerasimenko.character_frequency.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {


	@PostMapping("/{sourceString}")
	public Map<Character, Integer> calculateCharacterFrequency(@PathVariable String sourceString) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('a', 2);
		map.put('c', 4);

		return map;
	}
}

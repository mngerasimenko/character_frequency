package ru.mngerasimenko.character_frequency.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharacterFrequencyServiceTest {


	private static CharacterService service;

	@BeforeAll
	static void before() {
		service = new CharacterFrequencyService();
	}

	@Test
	void calculateCharacterFrequency_ReturnsValidMap() {
		//given
		String source = "fffaaaabb";
		Map<Character, Integer> expected = new LinkedHashMap<>();
		expected.put('a', 4);
		expected.put('f', 3);
		expected.put('b', 2);

		//when
		Map<Character, Integer> actual =  service.calculateCharacterFrequency(source);

		// then
		assertEquals(expected, actual);
	}
}
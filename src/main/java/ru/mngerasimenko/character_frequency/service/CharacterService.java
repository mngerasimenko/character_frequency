package ru.mngerasimenko.character_frequency.service;

import java.util.Map;

public interface CharacterService {
	Map<Character, Integer> calculateCharacterFrequency(String sourceString);
}

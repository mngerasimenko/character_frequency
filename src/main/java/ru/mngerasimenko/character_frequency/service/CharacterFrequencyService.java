package ru.mngerasimenko.character_frequency.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CharacterFrequencyService implements CharacterService{

	@Override
	public Map<Character, Integer> calculateCharacterFrequency(String sourceString) {
		Map<Character, Integer> frequencyMap = new HashMap<>();
		for (char c : sourceString.toCharArray()) {
			frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
		}

		return frequencyMap.entrySet()
				.stream()
				.sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(
						Map.Entry::getKey,
						Map.Entry::getValue,
						(oldValue, newValue) -> oldValue,
						LinkedHashMap::new
				));
	}
}

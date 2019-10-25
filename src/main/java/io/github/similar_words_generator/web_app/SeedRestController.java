package io.github.similar_words_generator.web_app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/seeds")
public class SeedRestController {
    private final SeedService seedService = new SeedService();

    @GetMapping
    public ResponseEntity<List<String>> getSeedsList() {
        List<String> seeds = seedService.getSeedsNames();
        return ResponseEntity.ok().body(seeds);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<String>> getWordsFromSeed(@PathVariable(value = "name") String name,
                                                @RequestParam(value = "words", defaultValue = "1") int wordsNumber,
                                                @RequestParam(value = "firstSignAsInInput", defaultValue = "true") boolean firstSignAsInInput,
                                                @RequestParam(value = "lastSignAsInInput", defaultValue = "true") boolean lastSignAsInInput,
                                                @RequestParam(value = "sorted", defaultValue = "true") boolean sorted,
                                                @RequestParam(value = "minWordLength", defaultValue = "default") String minWordLength,
                                                @RequestParam(value = "maxWordLength", defaultValue = "default") String maxWordLength) {
        List<String> words;
        int minWordLengthInt = 0;
        int maxWordLengthInt = 0;

        if (!minWordLength.equals("default")) {
            minWordLengthInt = Integer.parseInt(minWordLength);
        }

        if (!maxWordLength.equals("default")) {
            maxWordLengthInt = Integer.parseInt(maxWordLength);
        }
        words = seedService.getWordsFromSeed(name, wordsNumber, firstSignAsInInput, lastSignAsInInput, sorted, minWordLengthInt, maxWordLengthInt);
        return ResponseEntity.ok().body(words);
    }
}

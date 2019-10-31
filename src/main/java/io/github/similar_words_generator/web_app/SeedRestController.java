package io.github.similar_words_generator.web_app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/seeds")
public class SeedRestController {
    private final SeedService seedService = new SeedService();

    @GetMapping
    public ResponseEntity<Map<String, String>> getSeedsList(HttpServletRequest request) {
        List<String> seeds;
        Map<String, String> seedsAndLinks;

        seeds = seedService.getSeedsNames();
        seedsAndLinks = new HashMap<>();
        String webAddress = request.getRequestURL().toString();
        for (String seed : seeds) {
            String link = webAddress + "/" + seed.replace(" ", "+");
            seedsAndLinks.put(seed, link);
        }
        return ResponseEntity.ok().body(seedsAndLinks);
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

        name = name.replace("+", " ");

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

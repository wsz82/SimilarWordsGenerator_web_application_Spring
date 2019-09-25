package io.github.similar_words_generator.web_app;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeedController {
    private final SeedService seedService = new SeedService();

    @RequestMapping("seeds/{name}")
    public String getWordsFromSeed(@PathVariable("name") String name,
                                   @RequestParam(value = "words", defaultValue = "10") int wordsNumber,
                                   @RequestParam(value = "firstCharAsInInput", defaultValue = "true") boolean firstCharAsInInput,
                                   @RequestParam(value = "lastCharAsInInput", defaultValue = "true") boolean lastCharAsInInput,
                                   @RequestParam(value = "sorted", defaultValue = "true") boolean sorted,
                                   @RequestParam(value = "minWordLength", defaultValue = "0") int minWordLength,
                                   @RequestParam(value = "maxWordLength", defaultValue = "0") int maxWordLength) {
        List<String> words = seedService.getWordsFromSeed(name, wordsNumber, firstCharAsInInput, lastCharAsInInput, sorted, minWordLength, maxWordLength);
        String result = wordsToString(words);
        result = "<html><head/><body><p>" + result + "</p></body></html>";
        return result;
    }

    private String wordsToString(List<String> words) {
        StringBuilder builder = new StringBuilder();
        for (String word : words) {
            if (words.indexOf(word) == words.size() - 1) {
                builder.append(word);
                break;
            } else {
                builder.append(word).append(", ");
            }
        }
        return builder.toString();
    }
}
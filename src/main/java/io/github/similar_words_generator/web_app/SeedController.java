package io.github.similar_words_generator.web_app;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeedController {
    private final SeedService seedService = new SeedService();

    @RequestMapping("seeds")
    public String getSeedsList() {
        List<String> seedsNames = seedService.getSeedsNames();
        return seedsNamesToHTML(seedsNames);
    }

    private String seedsNamesToHTML(List<String> seedsNames) {
        StringBuilder builder = new StringBuilder();

        builder.append("<html><head/><body>");
        for (String name : seedsNames) {
            String url = "http://localhost:8080/seeds/" + name;
            builder.append("<p>").append(name).append(" - ").append("<a href=\"").append(url).append("\">generate</a><p>");
        }
        builder.append("</body></html>");
        return builder.toString();
    }

    @RequestMapping("seeds/{name}")
    public String getWordsFromSeed(@PathVariable("name") String name,
                                   @RequestParam(value = "words", defaultValue = "10") int wordsNumber,
                                   @RequestParam(value = "firstCharAsInInput", defaultValue = "true") boolean firstCharAsInInput,
                                   @RequestParam(value = "lastCharAsInInput", defaultValue = "true") boolean lastCharAsInInput,
                                   @RequestParam(value = "sorted", defaultValue = "true") boolean sorted,
                                   @RequestParam(value = "minWordLength", defaultValue = "0") int minWordLength,
                                   @RequestParam(value = "maxWordLength", defaultValue = "0") int maxWordLength) {
        List<String> words = seedService.getWordsFromSeed(name, wordsNumber, firstCharAsInInput, lastCharAsInInput, sorted, minWordLength, maxWordLength);
        return wordsToHTML(words);
    }

    private String wordsToHTML(List<String> words) {
        StringBuilder builder = new StringBuilder();
        builder.append("<html><head/><body>");
        for (String word : words) {
            builder.append("<p>").append(word).append("</p>");
        }
        builder.append("</body></html>");
        return builder.toString();
    }
}
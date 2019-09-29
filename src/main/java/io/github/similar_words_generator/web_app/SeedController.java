package io.github.similar_words_generator.web_app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SeedController {
    private final SeedService seedService = new SeedService();

    @GetMapping("/")
    public String getSeedsList(@ModelAttribute("model") ModelMap model) {
        List<String> seedsNames = seedService.getSeedsNames();
        model.addAttribute("seedsList", seedsNames);
        return "index";
    }

    @GetMapping("/seeds")
    public String getWordsFromSeed(@ModelAttribute("model") ModelMap model,
                                   @RequestParam(value = "name") String name,
                                   @RequestParam(value = "words", defaultValue = "10") int wordsNumber,
                                   @RequestParam(value = "firstSignAsInInput", defaultValue = "no") String firstSignAsInInput,
                                   @RequestParam(value = "lastSignAsInInput", defaultValue = "no") String lastSignAsInInput,
                                   @RequestParam(value = "sorted", defaultValue = "no") String sorted,
                                   @RequestParam(value = "minWordLength", defaultValue = "default") String minWordLength,
                                   @RequestParam(value = "maxWordLength", defaultValue = "default") String maxWordLength) {
        boolean firstSignAsInInputBoolean = false;
        boolean lastSignAsInInputBoolean = false;
        boolean sortedBoolean = false;
        int minWordLengthInt = 0;
        int maxWordLengthInt = 0;

        if (firstSignAsInInput.equals("yes")) {
            firstSignAsInInputBoolean = true;
        }
        if (lastSignAsInInput.equals("yes")) {
            lastSignAsInInputBoolean = true;
        }
        if (sorted.equals("yes")) {
            sortedBoolean = true;
        }
        if (!minWordLength.equals("default")) {
            minWordLengthInt = Integer.parseInt(minWordLength);
        }
        if (!maxWordLength.equals("default")) {
            maxWordLengthInt = Integer.parseInt(maxWordLength);
        }
        List<String> words = seedService.getWordsFromSeed(name, wordsNumber, firstSignAsInInputBoolean, lastSignAsInInputBoolean, sortedBoolean, minWordLengthInt, maxWordLengthInt);
        model.addAttribute("words", words);
        return "seeds";
    }
}
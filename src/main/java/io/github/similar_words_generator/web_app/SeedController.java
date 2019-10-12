package io.github.similar_words_generator.web_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.List;

@Controller
public class SeedController implements ErrorController {
    private static final Logger logger = LoggerFactory.getLogger(SeedController.class);
    private final SeedService seedService = new SeedService();

    @GetMapping("/")
    public String getSeedsList(@ModelAttribute("model") ModelMap model) {
        List<String> seedsNames = seedService.getSeedsNames();
        logger.info("Seeds list is empty: " + seedsNames.isEmpty());
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
        List<String> seedsNames = seedService.getSeedsNames();
        logger.info("Seeds list is empty: " + seedsNames.isEmpty());
        model.addAttribute("seedsList", seedsNames);
        return "seeds";
    }

    @RequestMapping("/error")
    public String handleError(@ModelAttribute("model") ModelMap model,
                              HttpServletRequest request) {
        String time = Instant.now().toString();
        model.addAttribute("time", time);
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        model.addAttribute("errorStatusCode", statusCode);
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
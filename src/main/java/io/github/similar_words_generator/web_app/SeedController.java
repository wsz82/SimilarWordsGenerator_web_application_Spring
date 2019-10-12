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
        if (seedsNames.isEmpty()) {
            logger.info("Seeds list is empty");
        }
        model.addAttribute("seedsList", seedsNames);
        return "index";
    }

    @GetMapping("/seeds")
    public String getWordsFromSeed(@ModelAttribute("model") ModelMap model,
                                   @RequestParam(value = "name") String name,
                                   @RequestParam(value = "words", defaultValue = "10") int wordsNumber,
                                   @RequestParam(value = "firstSignAsInInput", defaultValue = "false") boolean firstSignAsInInput,
                                   @RequestParam(value = "lastSignAsInInput", defaultValue = "false") boolean lastSignAsInInput,
                                   @RequestParam(value = "sorted", defaultValue = "false") boolean sorted,
                                   @RequestParam(value = "minWordLength", defaultValue = "default") String minWordLength,
                                   @RequestParam(value = "maxWordLength", defaultValue = "default") String maxWordLength) {
        List<String> words;
        List<String> seedsNames;
        int minWordLengthInt = 0;
        int maxWordLengthInt = 0;

        model.addAttribute("name", name);
        model.addAttribute("wordsNumber", wordsNumber);

        if (firstSignAsInInput) {
            model.addAttribute("ifFirstChecked", "checked");
        } else {
            model.addAttribute("ifFirstChecked", "unchecked");
        }

        if (lastSignAsInInput) {
            model.addAttribute("ifLastChecked", "checked");
        } else {
            model.addAttribute("ifLastChecked", "unchecked");
        }

        if (sorted) {
            model.addAttribute("ifSortedChecked", "checked");
        } else {
            model.addAttribute("ifSortedChecked", "unchecked");
        }

        model.addAttribute("minWordLength", minWordLength);
        model.addAttribute("maxWordLength", maxWordLength);

        if (!minWordLength.equals("default")) {
            minWordLengthInt = Integer.parseInt(minWordLength);
        }

        if (!maxWordLength.equals("default")) {
            maxWordLengthInt = Integer.parseInt(maxWordLength);
        }
        words = seedService.getWordsFromSeed(name, wordsNumber, firstSignAsInInput, lastSignAsInInput, sorted, minWordLengthInt, maxWordLengthInt);
        model.addAttribute("words", words);

        seedsNames = seedService.getSeedsNames();
        if (seedsNames.isEmpty()) {
            logger.info("Seeds list is empty");
        }
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
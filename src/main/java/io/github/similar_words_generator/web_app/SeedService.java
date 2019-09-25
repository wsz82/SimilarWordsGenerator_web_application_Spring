package io.github.similar_words_generator.web_app;

import io.github.wsz82.Analyser;
import io.github.wsz82.Controller;
import io.github.wsz82.ProgramParameters;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class SeedService {
    private static final Controller controller = new Controller();
    private static List<Seed> seeds = new ArrayList<>();
    private static File seedsDir;
    private ProgramParameters programParameters;
    private String path;

    static void initializeSeedsLocation() {
        readSeedsFile();
        seeds.clear();
        List<String> seedPaths = new ArrayList<>();

        try (
                Stream<Path> walk = Files.walk(Paths.get(seedsDir.getPath()))
        ) {
            seedPaths = walk
                    .map(e -> e.toAbsolutePath().toString())
                    .filter(e -> e.endsWith(".bin"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String path : seedPaths) {
            addInitSeed(path);
        }
    }

    private static void readSeedsFile() {
        Resource seedsResource = new ClassPathResource("seeds");
        try {
            seedsDir = seedsResource.getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addInitSeed(String path) {
        File seedFile = new File(path);
        String fileName = seedFile.getName();
        String seedName = fileName.substring(0, fileName.length() - 4);
        Analyser analyser = controller.loadSeed(path);
        seeds.add(new Seed(seedName, analyser));
    }

    List<String> getWordsFromSeed(String name, int wordsNumber, boolean firstCharAsInInput, boolean lastCharAsInInput, boolean sorted, int minWordLength, int maxWordLength) {
        for (Seed seed :  seeds) {
            if (name.equals(seed.getName())) {
                Set<String> setOfWords;

                path = seedsDir + "\\" + name + ".bin";
                setParameters(path, wordsNumber, firstCharAsInInput, lastCharAsInInput, sorted, minWordLength, maxWordLength);
                setOfWords = controller.generate(programParameters, Controller.GenerateSource.NEW_ANALYSER);
                return new ArrayList<>(setOfWords);
            }
        }
        return null;
    }

    private void setParameters(String path, int wordsNumber, boolean firstCharAsInInput, boolean lastCharAsInInput, boolean sorted, int minWordLength, int maxWordLength) {
        ProgramParameters.Builder parametersBuilder = new ProgramParameters.Builder();
        parametersBuilder.setPath(path);
        parametersBuilder.setNumberOfWords(wordsNumber);
        parametersBuilder.setFirstCharAsInInput(firstCharAsInInput);
        parametersBuilder.setLastCharAsInInput(lastCharAsInInput);
        parametersBuilder.setSorted(sorted);
        parametersBuilder.setMinWordLength(minWordLength);
        parametersBuilder.setMaxWordLength(maxWordLength);
        programParameters = parametersBuilder.build();
    }
}

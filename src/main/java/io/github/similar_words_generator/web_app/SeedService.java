package io.github.similar_words_generator.web_app;

import io.github.wsz82.Analyser;
import io.github.wsz82.Controller;
import io.github.wsz82.ProgramParameters;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

class SeedService {
    private static final Controller controller = new Controller();
    private static List<Seed> seeds = new ArrayList<>();
    private static ProgramParameters programParameters;
    private static String path;
    private static File appDir;

    void initSeedsLocation() {
        createLocationForSeeds();
        seeds.clear();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        initSeeds(classLoader);
    }

    private void createLocationForSeeds() {
        String path = "";
        path = new File(SeedService.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getParentFile().getParent().replace("file:", "");
        new File(path).mkdir();
        appDir = new File(path);
    }

    private void initSeeds(ClassLoader classLoader) {
        String[] seedsNames = {"Dwemer ruins.bin", "Deadric ruins.bin", "Dunmer strongholds.bin", "Caves.bin"};

        for (String seedName : seedsNames) {
            Analyser analyser = new Analyser();
            try (
                    InputStream inputStream = classLoader.getResourceAsStream("static/seeds/" + seedName);
                    ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)
            ) {
                analyser = (Analyser) objectInputStream.readObject();
                addSeedToListOfSeeds(seedName, analyser);
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            saveSeed(seedName, analyser);
        }
    }

    private void addSeedToListOfSeeds(String seedName, Analyser analyser) {
        String seedShortenName = seedName.substring(0, seedName.length() - 4);
        seeds.add(new Seed(seedShortenName, analyser));
    }

    private void saveSeed(String seedName, Analyser analyser) {
        String seedsPath = appDir + File.separator + seedName;
        File seedFile = new File(seedsPath);

        if (seedFile.exists()) {
            return;
        }
        try (
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(seedsPath))
        ) {
            os.writeObject(analyser);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<String> getSeedsNames() {
        if (!seeds.isEmpty()) {
            List<String> seedsNames = new ArrayList<>();

            for (Seed seed : seeds) {
                String seedName = seed.getName();
                seedsNames.add(seedName);
            }
            return seedsNames;
        } else {
            return Collections.emptyList();
        }
    }

    List<String> getWordsFromSeed(String name, int wordsNumber, boolean firstCharAsInInput, boolean lastCharAsInInput, boolean sorted, int minWordLength, int maxWordLength) {
        for (Seed seed :  seeds) {
            if (name.equals(seed.getName())) {
                Set<String> setOfWords;

                path = appDir + File.separator + name + ".bin";
                setParameters(path, wordsNumber, firstCharAsInInput, lastCharAsInInput, sorted, minWordLength, maxWordLength);
                setOfWords = controller.generate(programParameters, Controller.GenerateSource.NEW_ANALYSER);
                return new ArrayList<>(setOfWords);
            }
        }
        return Collections.emptyList();
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

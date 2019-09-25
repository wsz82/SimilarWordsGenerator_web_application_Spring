package io.github.similar_words_generator.web_app;

import io.github.wsz82.Analyser;

class Seed {
    private final String name;
    private final Analyser analyser;

    Seed(String name, Analyser analyser) {
        this.name = name;
        this.analyser = analyser;
    }

    String getName() {
        return name;
    }

    Analyser getAnalyser() {
        return analyser;
    }
}

var wordsInputInit;
var minWordLengthInputInit;
var maxWordLengthInputInit;

document.getElementById("words").addEventListener("focus", function() {
    wordsInputInit = parseInt(document.getElementById("words").value);
});

document.getElementById("words").addEventListener("change", function() {
    var wordsInput;

    wordsInput = parseInt(document.getElementById("words").value);
    document.getElementById("words").value = wordsInput;

    if (isNaN(wordsInput) || wordsInput < 1) {
        document.getElementById("words").value = wordsInputInit;
    }
});

document.getElementById("minWordLength").addEventListener("focus", function() {
    minWordLengthInputInit = document.getElementById("minWordLength").value;
});

document.getElementById("minWordLength").addEventListener("change", function() {
    var minWordLength;

    minWordLength = document.getElementById("minWordLength").value;
    if (!(minWordLength == "default")) {
        minWordLength = parseInt(minWordLength);
    }

    document.getElementById("minWordLength").value = minWordLength;

    if ((isNaN(minWordLength) || minWordLength == "default") || minWordLength < 1) {
        document.getElementById("minWordLength").value = minWordLengthInputInit;
    }
});

document.getElementById("maxWordLength").addEventListener("focus", function() {
    maxWordLengthInputInit = document.getElementById("maxWordLength").value;
});

document.getElementById("maxWordLength").addEventListener("change", function() {
    var maxWordLength;

    maxWordLength = document.getElementById("maxWordLength").value;
    if (!(maxWordLength == "default")) {
        maxWordLength = parseInt(maxWordLength);
    }

    document.getElementById("maxWordLength").value = maxWordLength;

    if ((isNaN(maxWordLength) || maxWordLength == "default") || maxWordLength < 1) {
        document.getElementById("maxWordLength").value = maxWordLengthInputInit;
    }
});
var wordsInputInit;

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
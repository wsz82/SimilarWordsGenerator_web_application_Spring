var initOutput;

function sortUnsort() {
    var sortedOutput;
    var ifSorted;

    ifSorted = document.getElementById("sorted").checked;
    if (initOutput == undefined) {
        initOutput = document.getElementById("output").innerHTML;
    }
    if (ifSorted) {
        sortedOutput = initOutput.replace(/\n/g, "");
        sortedOutput = sortedOutput.split("<br>");
        sortedOutput.sort();
        sortedOutput = sortedOutput.join("<br>")
        document.getElementById("output").innerHTML = sortedOutput;
    } else {
        document.getElementById("output").innerHTML = initOutput;
    }
}
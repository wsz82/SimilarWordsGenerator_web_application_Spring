<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
<head>
    <title>Similar Words Generator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="This is an application for generating words similar to given input" />
    <meta name="keywords" content="name generator, words generator, morrowind" />
    <link rel="icon" type="image/png" href="/favicon.png">
</head>
<body>
<div id="header">

</div>
<div id="container">
<form action="/seeds" method="get">
    <fieldset>
        <legend>Generator parameters:</legend>
        <div>
            <label for="name">Name:</label>
            <select name="name" id="name">
                <#list model["seedsList"] as seed>
                    <option selected>
                        ${seed}
                    </option>
                </#list>
            </select>
        </div>
        <div>
            <label for="words">Number of words:</label>
            <input name="words" id="words" value="10">
        </div>
        <div>
            <label for="firstSignAsInInput">Put first sign as in input?</label>
            <input type="checkbox" name="firstSignAsInInput" id="firstSignAsInInput" value="yes" checked>
        </div>
        <div>
            <label for="lastSignAsInInput">Put last sign as in input?</label>
            <input type="checkbox" name="lastSignAsInInput" id="lastSignAsInInput" value="yes" checked>
        </div>
        <div>
            <label for="sorted">Sort output?</label>
            <input type="checkbox" name="sorted" id="sorted" value="yes" checked>
        </div>
        <div>
            <label for="minWordLength">Min. word length:</label>
            <input name="minWordLength" id="minWordLength" value="default">
        </div>
        <div>
            <label for="maxWordLength">Max. word length:</label>
            <input name="maxWordLength" id="maxWordLength" value="default">
        </div>
        <div>
            <input type="submit" value="Generate words">
            <input type="reset" value="Reset">
        </div>
    </fieldset>
</form>
</div>
<div id="side-bar">

</div>

<div id="footer">
</div>

</body>
</html>
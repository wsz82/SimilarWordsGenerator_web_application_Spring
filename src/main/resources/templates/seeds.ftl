<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
    <head>
        <title>Similar Words Generator for Morrowind</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="This is an application for generating words similar to given input" />
        <meta name="keywords" content="name generator, words generator, morrowind" />
        <link rel="icon" type="image/png" href="/favicon.png">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <header id="header">
            <p><h1>Similar Words Generator for Morrowind</h1></p>
        </header>
        <div id="main">
                <form action="/seeds" method="get">
            <section>
                <div id="parameters">
                    <form action="/seeds" method="get">
                        <fieldset>
                            <legend><h2>Generator parameters:</h2></legend>
                            <div id="seeds_select">
                                <label for="name">Seed name:</label>
                                <select name="name" id="name">
                                    <#list model["seedsList"] as seed>
                                    <option selected>
                                        ${seed}
                                    </option>
                                </#list>
                                </select>
                            </div>
                            <div class="input">
                                <label for="words">Number of words:</label>
                                <input name="words" id="words" value="10">
                            </div>
                            <div class="input">
                                <label for="firstSignAsInInput">Put first sign as in input?</label>
                                <input type="checkbox" name="firstSignAsInInput" id="firstSignAsInInput" value="yes" checked>
                            </div>
                            <div class="input">
                                <label for="lastSignAsInInput">Put last sign as in input?</label>
                                <input type="checkbox" name="lastSignAsInInput" id="lastSignAsInInput" value="yes" checked>
                            </div>
                            <div class="input">
                                <label for="sorted">Sort output?</label>
                                <input type="checkbox" name="sorted" id="sorted" value="yes" checked>
                            </div>
                            <div class="input">
                                <label for="minWordLength">Min. word length:</label>
                                <input name="minWordLength" id="minWordLength" value="default">
                            </div>
                            <div class="input">
                                <label for="maxWordLength">Max. word length:</label>
                                <input name="maxWordLength" id="maxWordLength" value="default">
                            </div>
                            <div class="input">
                                <input type="submit" value="Generate words">
                                <input type="reset" value="Reset">
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div id="output">
                    <ul style="list-style-type:none;">
                    <#list model["words"] as word>
                        <li>${word}</li>
                    </#list>
                    </ul>
                </div>
            </section>
            <aside id="side_bar">
                <p><label for="useful_links">Useful links:</label></p>
                <ul id="useful_links">
                    <li><a href="https://www.tamriel-rebuilt.org/" target="_blank">Tamriel Rebuilt</a></li>
                    <li><a href="https://github.com/wsz82/SimilarWordsGenerator_web_application_Spring" target="_blank">Project's repository</a></li>
                </ul>
            </aside>
        </div>
        <footer id="footer">
            <ul>
                <li><a href="/">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
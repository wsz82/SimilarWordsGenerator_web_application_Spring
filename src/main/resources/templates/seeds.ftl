<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
    <head>
        <title>Similar Words Generator for Morrowind</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="This is an application for generating words similar to given input" />
        <meta name="keywords" content="name generator, words generator, morrowind" />
        <link rel="icon" type="image/png" href="favicon.png">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <header>
            <img src="swg.png" alt="Similar Words Generator For Morrowind"> <!--Font credits: Author: NZdawghaus, Source: Nexusmods -->
        </header>
        <div id="main">
                <form action="/seeds" method="get">
            <section>
                <div id="parameters">
                    <form action="/seeds" method="get">
                        <fieldset>
                            <legend><h2>Generator parameters:</h2></legend>
                            <div class="input">
                                <label for="name">Location:</label>
                                <div class="custom-select">
                                    <select name="name" id="name">
                                        <option>${model["seedsList"][0]}</option>
                                        <#list model["seedsList"] as seed>
                                            <option <#if seed == model.name>selected</#if>>
                                                ${seed}
                                            </option>
                                        </#list>
                                    </select>
                                </div>
                            </div>
                            <div class="input">
                                <label for="words">Number of words:</label>
                                <input name="words" id="words" value=${model.wordsNumber}>
                            </div>
                            <div class="input">
                                <label for="firstSignAsInInput">Put first sign as in input?</label>
                                <input type="checkbox" name="firstSignAsInInput" id="firstSignAsInInput" value="true" ${model.ifFirstChecked}>
                            </div>
                            <div class="input">
                                <label for="lastSignAsInInput">Put last sign as in input?</label>
                                <input type="checkbox" name="lastSignAsInInput" id="lastSignAsInInput" value="true" ${model.ifLastChecked}>
                            </div>
                            <div class="input">
                                <label for="sorted">Sort output?</label>
                                <input type="checkbox" name="sorted" id="sorted" value="true" ${model.ifSortedChecked}>
                            </div>
                            <div class="input">
                                <label for="minWordLength">Min. word length:</label>
                                <input name="minWordLength" id="minWordLength" value=${model.minWordLength}>
                            </div>
                            <div class="input">
                                <label for="maxWordLength">Max. word length:</label>
                                <input name="maxWordLength" id="maxWordLength" value=${model.maxWordLength}>
                            </div>
                            <div class="input">
                                <input type="submit" value="Generate words">
                                <button type="button" onclick="resetForm();">Reset</button>
                            </div>
                        </fieldset>
                    </form>
                </div>
                <div id="output">
                    <#list model["words"] as word>
                        ${word}<br>
                    </#list>
                </div>
            </section>
            <aside id="side_bar">
                <p><label for="useful_links">Useful links:</label></p>
                <ul id="useful_links">
                    <li><a href="https://github.com/wsz82/SimilarWordsGenerator_web_application_Spring" target="_blank">Project repository</a></li>
                    <li><a href="https://www.nexusmods.com/morrowind/mods/47050" target="_blank">Desktop version</a></li>
                    <li><a href="https://www.tamriel-rebuilt.org/" target="_blank">Tamriel Rebuilt</a></li>
                </ul>
            </aside>
        </div>
        <footer>
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="https://similarwordsgenerator.herokuapp.com/api/v1/seeds" target="_blank">API</a></li>
            </ul>
        </footer>
        <script type="text/javascript" src="javascript-reset-form.js"></script>
        <script type="text/javascript" src="javascript-custom-select.js"></script>
    </body>
</html>
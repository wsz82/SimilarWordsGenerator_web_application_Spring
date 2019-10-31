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
        <header>
            <img src="swg.png" alt="Similar Words Generator For Morrowind"> <!--Font credits: Author: NZdawghaus, Source: Nexusmods -->
        </header>
        <div id="main">
            <section>
                <div id="error">
                <p>${model.time}</p>
                <p>Error status code: ${model.errorStatusCode}</p>
                <p>Probably you put invalid type of input in form or address.</p>
                </div>
            </section>
            <aside id="side_bar">
                <p><label for="useful_links">Useful links:</label></p>
                <ul id="useful_links">
                    <li><a href="https://similarwordsgenerator.herokuapp.com/api/v1/seeds" target="_blank">API</a></li>
                    <li><a href="https://github.com/wsz82/SimilarWordsGenerator_web_application_Spring" target="_blank">Project repository</a></li>
                    <li><a href="https://www.nexusmods.com/morrowind/mods/47050" target="_blank">Desktop version</a></li>
                    <li><a href="https://www.tamriel-rebuilt.org/" target="_blank">Tamriel Rebuilt</a></li>
                </ul>
            </aside>
        </div>
        <footer>
            <ul>
                <li><a href="/">Home</a></li>
            </ul>
        </footer>
    </body>
</html>
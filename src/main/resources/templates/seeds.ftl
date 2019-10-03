<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html lang="en">
    <head>
        <title>Similar Words Generator</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="This is an application for generating words similar to given input" />
        <meta name="keywords" content="name generator, words generator, morrowind" />
        <link rel="icon" type="image/png" href="/favicon.png">
        <link rel="stylesheet" href="styles.css">
    </head>
    <body>
        <header id="header">
            <p><h1>Similar Words Generator</h1></p>
        </header>
        <div id="main">
            <section id="container">
                <ul style="list-style-type:none;">
                <#list model["words"] as word>
                    <li>${word}</li>
                </#list>
                </ul>
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
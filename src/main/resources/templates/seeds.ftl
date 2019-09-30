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
    <ul style="list-style-type:none;">
    <#list model["words"] as word>
        <li>${word}</li>
    </#list>
    </ul>
</div>
<div id="side-bar">

</div>
<div id="footer">

</div>
</body>
</html>
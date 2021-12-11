<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Code</title>
    <link type="text/css" rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" target="_blank"
        href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/default.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<span id="load_date">${snippet.formatDate()}</span>
<#if snippet.isViewRestricted()>
<p><span id="views_restriction">${snippet.views}</span> more views allowed</p>
</#if>
<#if snippet.isTimeRestricted()>
<p>The code will be available for <span id="time_restriction">${snippet.time}</span> seconds</p>
</#if>
<pre id="code_snippet"><code>${snippet.code}</code></pre>
</body>
</html>
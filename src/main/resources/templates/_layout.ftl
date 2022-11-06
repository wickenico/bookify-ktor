<#macro header>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <link rel="stylesheet" href="/static/style.css" />
        <link href="/static/favicon.ico" rel="shortcut icon" type="image/x-icon" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Bookify - Digitalize your bookshelf.</title>

    </head>
    <body style="text-align: center; font-family: sans-serif" onload="loadImage()">
    <header>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-dark bg-primary border-bottom shadow">
            <div class="container">
                <a class="navbar-brand"> <img src="/static/favicon-16x16.png" /> Bookify</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse d-sm-inline-flex flex-sm-row-reverse">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/books">Books</a>
                        </li>
                        <#--<li class="nav-item">
                            <a class="nav-link" asp-area="" asp-page="/Imprint">Imprint</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" asp-area="" asp-page="/Privacy">Privacy</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" asp-area="" asp-page="/Changelog">Changelog</a>
                        </li>-->
                        <li class="nav-item">
                            <a class="nav-link" href="/search">Search</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <#--<img src="/static/ktor_logo.png">
    <h1>Kotlin Ktor Journal </h1>
    <p><i>Powered by Ktor & Freemarker!</i></p>
    <hr>-->
    <#nested>
    <a href="/">Back to the main page</a>
    <footer class="border-top footer bg-teal text-light text-center fixed-bottom">
        <div class="container">
            &copy; 2022 - Bookify • Digitalize your bookshelf.
        </div>
    </footer>
    </body>
    </html>
</#macro>
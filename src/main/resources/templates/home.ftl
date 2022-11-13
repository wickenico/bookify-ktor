<#import "_layout.ftl" as layout />
<@layout.header>

    <br><br>

    <div class="container">
        <div class="row justify-content-center">

            <div class="col-sm">
                <div class="card border-primary" style="width: 18rem;">
                    <img class="card-img-top" src="static/library.jpg" alt="Books" />
                    <div class="card-body">
                        <h5 class="card-title">API</h5>
                        <p class="card-text">Go to your library.</p>
                        <a class="btn btn-outline-primary" href="/books">Go to Library</a>
                    </div>
                </div>
            </div>

            <div class="col-sm">
                <div class="card border-primary" style="width: 18rem;">
                    <img class="card-img-top" src="static/search2.jpg" alt="Card image cap" />
                    <div class="card-body">
                        <h5 class="card-title">Search</h5>
                        <p class="card-text">Search and add a new Book.</p>
                        <a class="btn btn-outline-primary" href="/search">Go to Search</a>
                    </div>
                </div>
            </div>

            <div class="col-sm">
                <div class="card border-primary" style="width: 18rem;">
                    <img class="card-img-top" src="static/computer.jpg" alt="Card image cap" />
                    <div class="card-body">
                        <h5 class="card-title">Homepage</h5>
                        <p class="card-text">Directly navigate to my website.</p>
                        <a href="https://nicowickersheim.dev" target="_blank" class="btn btn-outline-primary">Go to Homepage</a>
                    </div>
                </div>
            </div>

        </div>
    </div>

</@layout.header>
<#import "_layout.ftl" as layout />
<@layout.header>

    <br><br>

    <div class="container">
        <div class="row justify-content-center">

            <div class="col-sm">
                <div class="card border-primary" style="width: 18rem;">
                    <img class="card-img-top" src="static/library.jpg" alt="Books" />
                    <div class="card-body">
                        <h5 class="card-title text-dark">API</h5>
                        <p class="card-text text-dark">Go to your library.</p>
                        <a class="btn btn-outline-primary" href="/books"><i class="fa fa-book"></i> Go to Library</a>
                    </div>
                </div>
            </div>

            <div class="col-sm">
                <div class="card border-primary" style="width: 18rem;">
                    <img class="card-img-top" src="static/search2.jpg" alt="Card image cap" />
                    <div class="card-body">
                        <h5 class="card-title text-dark">Search</h5>
                        <p class="card-text text-dark">Search and add a new Book.</p>
                        <a class="btn btn-outline-primary" href="/search"><i class="fa fa-search"></i> Go to Search</a>
                    </div>
                </div>
            </div>

            <div class="col-sm">
                <div class="card border-primary" style="width: 18rem;">
                    <img class="card-img-top" src="static/computer.jpg" alt="Card image cap" />
                    <div class="card-body">
                        <h5 class="card-title text-dark">Homepage</h5>
                        <p class="card-text text-dark">Directly navigate to my website.</p>
                        <a href="https://nicowickersheim.dev" target="_blank" class="btn btn-outline-primary"><i class="fa fa-home"></i> Go to Homepage</a>
                    </div>
                </div>
            </div>

        </div>

        <br>

        <div class="row justify-content-center">
            <div class="col-sm">
                <div class="card border-primary" style="width: 18rem;">
                    <img class="card-img-top" src="static/update.jpg" alt="Card image cap" />
                    <div class="card-body">
                        <h5 class="card-title text-dark">What's new</h5>
                        <p class="card-text text-dark">Read the changelog.</p>
                        <a class="btn btn-outline-primary" href="/changelog"><i class="fa fa-history"></i> Go to Changelog</a>
                    </div>
                </div>
            </div>
        </div>

    </div>

</@layout.header>
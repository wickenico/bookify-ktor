<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <!-- // style="border:1px solid red; -->
        <div class="container d-flex align-items-center justify-content-center ">
            <div class="text-center">
                <h1 class="display-1 fw-bold"><i class="fa fa-exclamation-triangle" aria-hidden="true" style="color:red"></i> Error ${status.code}</h1>
                <!-- <p class="fs-3"> <span class="text-danger">Opps!</span> Page not found.</p> -->
                <p class="lead"> ${status.message} </p>
                <iframe src="https://giphy.com/embed/Awa5Y73PQNUS7HEdyu" width="200" height="200" frameBorder="0" class="giphy-embed" allowFullScreen></iframe><p><a href="https://giphy.com/gifs/VOXTUR-voxtur-Awa5Y73PQNUS7HEdyu"></a></p>
                <p><a href="/" class="btn btn-outline-primary shadow"><i class="fa fa-home"></i> Go Home</a></p>
                <p><a href="/" class="btn btn-outline-primary shadow"><i class="fa fa-book"></i> Go To Books</a></p>
                <p><a href="/" class="btn btn-outline-primary shadow"><i class="fa fa-search"></i> Go To Search</a></p>
            </div>
        </div>
    </div>
</@layout.header>
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <div class="text-center">
            <h1 class="display-4">Search</h1>
        </div>
        <!-- // style="border:1px solid red; -->
        <div class="container" onload="docReady()">
            <div class="row">
                <div class="form-group has-search">
                    <span class="fa fa-search form-control-feedback"></span>
                    <form action="/search/field" method="get">
                    <input id="searchField" type="number" class="form-control" name="isbn">
                    </form>
                </div>
            </div>

            <br><br><br>
            <div class="row">

                <button type="submit" class="btn btn-outline-primary" onclick="resetScan()" style="width: 500px; margin: 0 auto;"><i class="fa fa-refresh"></i> New Scan</button>
                <br>
                <div id="qr-reader" style="width:500px;"></div>
                <div id="qr-reader-results"></div>

            </div>

        </div>
    </div>
</@layout.header>
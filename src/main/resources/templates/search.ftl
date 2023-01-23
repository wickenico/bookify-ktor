<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container">
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

                <button id="liveToastBtn" type="submit" class="btn btn-outline-primary" onclick="resetScan()" style="width: 500px; margin: 0 auto;"><i class="fa fa-refresh"></i> New Scan</button>

                <div class="toast-container position-fixed bottom-0 end-0 p-3">
                    <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header">
                            <i class="fa fa-circle fa-2x" aria-hidden="true" style="color:red;"></i>
                            <strong class="me-auto">Bootstrap</strong>
                            <small>11 mins ago</small>
                            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                        <div class="toast-body">
                            Hello, world! This is a toast message.
                        </div>
                    </div>
                </div>
                <br>
                <div id="qr-reader" style="width:500px;"></div>
                <div id="qr-reader-results"></div>

            </div>

        </div>
    </div>
    <script type="text/javascript">
        const toastTrigger = document.getElementById('liveToastBtn')
        const toastLiveExample = document.getElementById('liveToast')
        if (toastTrigger) {
            toastTrigger.addEventListener('click', () => {
                const toast = new bootstrap.Toast(toastLiveExample)

                toast.show()
            })
        }
    </script>
</@layout.header>
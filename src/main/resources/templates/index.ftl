<#-- @ftlvariable name="books" type="kotlin.collections.List<com.nw.models.Book>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container-fluid">
        <h1 class="display-1 fw-bold">Your Books</h1>
        <div class="row justify-content-center">
            <#list books?reverse as book>
                <hr>
                <div class="card mb-2" style="max-width: 540px;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img data-book-cover-src="${book.imageUrl}" class="img-fluid" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">${book.title}</h5>
                                <p class="card-text">${book.author}</p>
                                <p class="card-text"><small class="text-muted">Hinzugefügt am "${book.addedOnDate.toLocalDate()}</small></p>
                                <a href="/books/${book.id}" class="btn btn-outline-primary" style="display:inline-block; vertical-align:middle;">
                                    <i class="fa fa-info-circle"></i> Go to Details
                                </a>
                                <#if book.readStatus == "READ">
                                    <i class="fa fa-check-circle fa-2x" aria-hidden="true" style="color:green;display:inline-block; vertical-align:middle;"></i>
                                <#elseif book.readStatus == "READING">
                                    <i class="fa fa-hourglass-half fa-2x" aria-hidden="true" style="color:goldenrod;display:inline-block; vertical-align:middle;"></i>
                                <#elseif book.readStatus == "UNREAD">
                                    <i class="fa fa-circle fa-2x" aria-hidden="true" style="color:red;display:inline-block; vertical-align:middle;"></i>
                                </#if>
                            </div>
                        </div>
                    </div>
                </div>

            </#list>
            <div aria-live="polite" aria-atomic="true" class="bg-body-secondary position-relative bd-example-toasts rounded-3">
                <div class="toast-container p-3" id="toastPlacement">
                    <div class="toast">
                        <div class="toast-header">
                            <img src="..." class="rounded me-2" alt="...">
                            <strong class="me-auto">Bootstrap</strong>
                            <small>11 mins ago</small>
                        </div>
                        <div class="toast-body">
                            Hello, world! This is a toast message.
                        </div>
                    </div>
                </div>
            </div>

    </div>
    </div>
    <script type="text/javascript">
        document
            .querySelectorAll('img[data-book-cover-src]')
            .forEach(elmNode => {
                elmNode.src = elmNode.dataset.bookCoverSrc;
                elmNode.onerror = function () {
                    this.src = 'https://via.placeholder.com/128x203';
                }
            });
    </script>
</@layout.header>
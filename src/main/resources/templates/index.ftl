<#-- @ftlvariable name="books" type="kotlin.collections.List<com.nw.models.Book>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list books?reverse as book>
<div class="container-fluid">
    <hr>
        <div class="row justify-content-center">
        <div class="card shadow p-3 mb-5 bg-white rounded" style="width: 18rem;">
            <img data-book-cover-src="${book.imageUrl}" class="card-img-top" src="https://via.placeholder.com/128x209.png">
            <div class="card-body">
                <h5 class="card-title">${book.title}</h5>
                <p class="card-text">${book.author}</p>
                <a href="/books/${book.id}" class="btn btn-outline-primary"><i class="fa fa-info-circle"></i> Go to Details</a>
            </div>
        </div>
        </div>
</div>
    </#list>

    <script type="text/javascript">
        document
            .querySelectorAll('img[data-book-cover-src]')
            .forEach(elmNode =>
            {
                elmNode.src = elmNode.dataset.bookCoverSrc;
                elmNode.onerror = function() {
                    this.src = '/static/500x900.png';
                }
            });
    </script>

    <hr>
    <p>
        <a href="/books/new">Create book</a>
    </p>
</@layout.header>
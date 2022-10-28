<#-- @ftlvariable name="books" type="kotlin.collections.List<com.nw.models.Book>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list books?reverse as book>
        <#--<div>
            <hr>
            <h3>
                <a href="/books/${book.id}">${book.title}</a>
            </h3>
            <p>
                ${book.author}
            </p>
            <p>
                ${book.publisher}
            </p>
            <p>
                ${book.pages}
            </p>
        </div>-->
<div class="container-fluid">
    <hr>
        <div class="row justify-content-center">
        <div class="card" style="width: 18rem;">
            <img class="card-img-top" src="https://via.placeholder.com/286x180" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">${book.title}</h5>
                <p class="card-text">${book.author} /n ${book.publisher}</p>
                <a href="/books/${book.id}" class="btn btn-outline-primary">Go to Book</a>
            </div>
        </div>
        </div>
</div>

    </#list>
    <hr>
    <p>
        <a href="/books/new">Create book</a>
    </p>
</@layout.header>
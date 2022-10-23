<#-- @ftlvariable name="books" type="kotlin.collections.List<com.nw.models.Book>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <#list books?reverse as book>
        <div>
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
        </div>
    </#list>
    <hr>
    <p>
        <a href="/books/new">Create book</a>
    </p>
</@layout.header>
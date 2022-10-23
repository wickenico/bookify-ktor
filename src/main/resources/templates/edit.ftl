<#-- @ftlvariable name="book" type="com.nw.models.Book" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Edit book</h3>
        <form action="/books/${book.id}" method="post">
            <p>
                <input type="text" name="title" value="${book.title}">
            </p>
            <p>
                <input type="text" name="author" value="${book.author}">
            </p>
            <p>
                <input type="text" name="publisher" value="${book.publisher}">
            </p>
            <p>
                <input type="number" name="pages" value="${book.pages}">
            </p>
            <p>
                <input type="submit" name="_action" value="update">
            </p>
        </form>
    </div>
    <div>
        <form action="/books/${book.id}" method="post">
            <p>
                <input type="submit" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>

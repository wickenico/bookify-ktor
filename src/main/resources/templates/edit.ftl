<#-- @ftlvariable name="book" type="com.nw.models.Book" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container text-center">
        <h3>Edit book</h3>

        <div class="row">
            <div class="col">

        <form action="/books/${book.id}" method="post">
            <div class="mb-3">
                <label for="disabledTextInput" class="form-label">Titel</label>
                <input type="text" class="form-control" name="title" value="${book.title}">
            </div>
            <div class="mb-3">
                <label for="disabledTextInput" class="form-label">Autor</label>
                <input type="text" class="form-control" name="author" value="${book.author}">
            </div>
            <div class="mb-3">
                <label for="disabledTextInput" class="form-label">Verlag</label>
                <input type="text" class="form-control" name="publisher" value="${book.publisher}">
            </div>
            <div class="mb-3">
                <label for="disabledTextInput" class="form-label">Seitenanzahl</label>
                <input type="number" class="form-control" name="pages" value="${book.pages}">
            </div>
            <div class="mb-3">
                <label for="disabledTextInput" class="form-label">Image</label>
                <input type="text" id="img-url" class="form-control" name="imageUrl" value="${book.imageUrl}">
                <br>
                <img src="" id="img-book"/>
            </div>
            <p>
                <input type="submit" class="btn btn-outline-primary" name="_action" value="update">
            </p>
        </form>
            </div>
            </div>
    </div>
    <div>
        <form action="/books/${book.id}" method="post">
            <p>
                <input type="submit" class="btn btn-outline-primary" name="_action" value="delete">
            </p>
        </form>
    </div>
</@layout.header>

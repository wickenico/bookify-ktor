<#-- @ftlvariable name="book" type="com.nw.models.Book" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container text-center">
        <#--<h3>
            ${book.title}
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
        <hr>-->
        <h1> Details </h1>

        <hr>

        <div class="row">
            <div class="col">

        <form>
            <fieldset disabled>
                <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Titel</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${book.title}">
                </div>
                <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Autor</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${book.author}">
                </div>
                <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Verlag</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${book.publisher}">
                </div>
                <div class="mb-3">
                    <label for="disabledTextInput" class="form-label">Seitenanzahl</label>
                    <input type="text" id="disabledTextInput" class="form-control" placeholder="${book.pages}">
                </div>
            </fieldset>
        </form>

            </div>
        </div>
        <p>
            <button type="submit" class="btn btn-outline-primary" onclick="location.href='/books/${book.id}/edit'">Edit book</button>
        </p>
    </div>
</@layout.header>

<#-- @ftlvariable name="book" type="com.nw.models.Book" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container text-center">
        <h1> ${book.title} </h1>
        <!-- <hr> -->
        <div class="shadow p-3 mb-5 bg-white rounded">
            <form>
                <fieldset disabled>
                    <div class="row">
                        <div class="col-sm-1">
                            <label for="disabledTextInput" class="col-form-label">Title</label>
                        </div>
                        <div class="col-sm-4">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.title}">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-1">
                            <label for="disabledTextInput" class="col-form-label">Autor</label>
                        </div>
                        <div class="col-sm-4">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.author}">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-1">
                            <label for="disabledTextInput" class="col-form-label">Verlag</label>
                        </div>
                        <div class="col-sm-4">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.publisher}">
                        </div>
                    </div>
                    <br>
                    <div class="row">
                        <div class="col-sm-1">
                            <label for="disabledTextInput" class="col-form-label">Seitenanzahl</label>
                        </div>
                        <div class="col-sm-4">
                            <input type="number" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.pages?c}">
                        </div>
                    </div>
                    <br>
                    <div class="col-sm-2">
                        <input type="hidden" id="img-url" class="form-control" placeholder="${book.imageUrl}">
                        <br>
                        <img class="shadow rounded" src="" id="img-book"/>
                    </div>
                </fieldset>
            </form>
        </div>
        <p>
            <button type="submit" class="btn btn-outline-primary shadow" onclick="location.href='/books/${book.id}/edit'">Edit book</button>
        </p>
    </div>
    <script type="text/javascript">
        function loadImage() {

            let a1 = document.getElementById("img-url").getAttribute("placeholder");
            const image = document.getElementById("img-book");
            image.src = a1;
        }
    </script>
</@layout.header>
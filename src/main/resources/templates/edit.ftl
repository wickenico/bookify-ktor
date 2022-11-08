<#-- @ftlvariable name="book" type="com.nw.models.Book" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container text-center">

        <br>

        <button type="submit" class="btn btn-outline-danger shadow" onclick="location.href='/books/${book.id}'"><i class="fa fa-arrow-left"></i> Back</button>

        <br>
        <br>

        <h1 class=fw-bold">${book.title}</h1>
        <h2 class="fw-light">${book.subtitle}</h2>

        <br>

        <div class="shadow p-3 mb-5 bg-white rounded">
        <div class="row justify-content-center">
            <div class="col-5">

            <form action="/books/${book.id}" method="post">

<#--            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Titel</label>
                </div>
                <div class="col-sm-6">
                <input type="text" class="form-control shadow rounded" name="title" value="${book.title}">
                </div>
            </div>

            <br>-->

            <input type="hidden" class="form-control shadow rounded" name="title" value="${book.title}">

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Autor</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="author" value="${book.author}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Verlag</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="publisher" value="${book.publisher}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">ISBN10</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="isbn10" value="${book.isbn10}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">ISBN13</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="isbn13" value="${book.isbn13}">
                </div>
            </div>

            <br>

<#--            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Subtitle</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="subtitle" value="${book.subtitle}">
                </div>
            </div>

            <br>-->

                <input type="hidden" class="form-control shadow rounded" name="subtitle" value="${book.subtitle}">

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Selflink</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="selfLink" value="${book.selfLink}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Published Date</label>
                </div>
                <div class="col-sm-6">
                    <input type="date" class="form-control shadow rounded" name="publishedDate" value="${book.publishedDate}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Description</label>
                </div>
                <div class="col-sm-6">
                    <textarea class="form-control shadow rounded" rows="3" name="description">${book.description}</textarea>
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Print Type</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="printType" value="${book.printType}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Category</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="category" value="${book.category}">
                </div>
            </div>

        </div>

        <div class="col">
            <input type="hidden" id="img-url" class="form-control" name="imageUrl" value="${book.imageUrl}">
            <img src="" id="img-book"/>
        </div>

        <div class="col-5">

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">FSK</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="maturityRating" value="${book.maturityRating}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Language</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="language" value="${book.language}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Infolink</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="infoLink" value="${book.infoLink}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Rating</label>
                </div>
                <div class="col-sm-6">
                    <input type="number" class="form-control shadow rounded" name="rating" value="${book.rating?c}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Comment</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="comment" value="${book.comment}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Read Status</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="readStatus" value="${book.readStatus}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Added On</label>
                </div>
                <div class="col-sm-6">
                    <input type="date" class="form-control shadow rounded" name="addedOnDate" value="${book.addedOnDate}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Tags</label>
                </div>
                <div class="col-sm-6">
                    <input type="text" class="form-control shadow rounded" name="tags" value="${book.tags}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-2">
                    <label for="disabledTextInput" class="col-form-label">Seiten</label>
                </div>
                <div class="col-sm-6">
                    <input type="number" class="form-control" name="pages" value="${book.pages?c}">
                </div>
            </div>

            <br>

            <div class="row">
                <div class="col-sm-5">
                    <input type="hidden" id="img-url" class="form-control" name="imageUrl" value="${book.imageUrl}">
                    <img src="" id="img-book"/>
                </div>
            </div>

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
    <script type="text/javascript">
        function loadImage() {

            let a1 = document.getElementById("img-url").getAttribute("value");
            const image = document.getElementById("img-book");
            image.src = a1;
        }
    </script>
</@layout.header>

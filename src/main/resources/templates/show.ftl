<#-- @ftlvariable name="book" type="com.nw.models.Book" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container text-center">
        <h1 class=fw-bold">${book.title}</h1>
        <h2 class="fw-light">${book.subtitle}</h2>

        <br>
        <!-- <hr> -->
        <div class="shadow p-3 mb-5 bg-white rounded">
        <div class="row justify-content-center">

            <div class="col-5">

                <form>
                    <fieldset disabled>
                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Title</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.title}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Autor</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.author}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Verlag</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.publisher}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">ISBN10</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.isbn10}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">ISBN13</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.isbn13}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Selflink</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.selfLink}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Published Date</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="date" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.isbn13}">
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
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.printType}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Category</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.category}">
                        </div>
                    </div>

                    </fieldset>
                </form>

                </div>

                <div class="col">
                    <input type="hidden" id="img-url" class="form-control" placeholder="${book.imageUrl}">
                    <br>
                    <img class="shadow rounded" src="" id="img-book"/>
                </div>

                <div class="col-5">

                    <form>
                        <fieldset disabled>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">FSK</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.maturityRating}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Language</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.language}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Infolink</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.infoLink}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Rating</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="number" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.rating}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Comment</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.comment}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Read Status</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.readStatus}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Added on</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="date" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.addedOnDate}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Tags</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="text" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.tags}">
                        </div>
                    </div>

                    <br>

                    <div class="row">
                        <div class="col-sm-2">
                            <label for="disabledTextInput" class="col-form-label">Seiten</label>
                        </div>
                        <div class="col-sm-6">
                            <input type="number" id="disabledTextInput" class="form-control shadow rounded" placeholder="${book.pages?c}">
                        </div>
                    </div>
                        </fieldset>
                    </form>
                </div>

            </div>
        </div>
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
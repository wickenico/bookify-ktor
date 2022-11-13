<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <div class="text-center">
            <h1 class="display-4">Search</h1>
        </div>
        <!-- // style="border:1px solid red; -->
        <div class="container">
            <div class="row">
                <div class="form-group has-search">
                    <span class="fa fa-search form-control-feedback"></span>
                    <form action="/search/field" method="get">
                    <input type="number" class="form-control" name="isbn">
                    </form>
                </div>
            </div>
           <br><br><br>
         <#-- <div class="row">
                <div class="col-sm-3">
                    <div class="img"><img src="/static/500x900.png" class="img-fluid" alt="Responsive image"></div>
                </div>
                <div class="col-sm-9">
                    <div class="row">
                        <div class="col-8 col-sm-6">

                        </div>
                        <div class="col-4 col-sm-6">
                            <form>
                                <fieldset disabled>
                                    <legend>Book Information</legend>
                                    <div class="mb-3">
                                        <label for="disabledTextInput" class="form-label">Titel</label>
                                        <input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
                                    </div>
                                    <div class="mb-3">
                                        <label for="disabledTextInput" class="form-label">Author</label>
                                        <input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
                                    </div>
                                    <div class="mb-3">
                                        <label for="disabledTextInput" class="form-label">Publisher</label>
                                        <input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
                                    </div>
                                    <div class="mb-3">
                                        <label for="disabledTextInput" class="form-label">Pages</label>
                                        <input type="text" id="disabledTextInput" class="form-control" placeholder="Disabled input">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Save</button>
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>-->
        </div>
    </div>
</@layout.header>
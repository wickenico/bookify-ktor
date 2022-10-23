<#import "_layout.ftl" as layout />
<@layout.header>
    <div>
        <h3>Create book</h3>
        <form action="/books" method="post">
            <p>
                <input type="text" name="title">
            </p>
            <p>
                <input type="text" name="author">
            </p>
            <p>
                <input type="text" name="publisher">
            </p>
            <p>
                <input type="number" name="pages">
            </p>
            <p>
                <input type="submit">
            </p>
        </form>
    </div>
</@layout.header>

<#-- @ftlvariable name="tag" type="com.nw.models.Tag" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container mt-5">
        <h1 class="text-center">Tags</h1>
        <form action="/tags" method="post">
            <label for="name">Name:</label>
            <#if tag?? && tag.name?has_content>
                <input type="text" class="form-control shadow rounded" id="name" name="name" required value="${tag.name}">
            <#else>
                <input type="text" class="form-control shadow rounded" id="name" name="name" required>
            </#if>
            <input type="submit" class="btn btn-outline-primary" value="save">
        </form>
    </div>
</@layout.header>
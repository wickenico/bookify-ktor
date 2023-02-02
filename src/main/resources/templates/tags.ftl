<#-- @ftlvariable name="tags" type="kotlin.collections.List<com.nw.models.Tag>" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container mt-5">
        <h1 class="text-center">Tags</h1>
        <br>
        <#list tags as tag>
            <hr>
            <span class="badge rounded-pill text-bg-primary" style="font-size: 15px; padding: 10px 15px;">
                ${tag.name}
            </span>
        </div>
        </#list>
    </div>
</@layout.header>
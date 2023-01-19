<#-- @ftlvariable name="user" type="com.nw.models.User" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container mt-5">
        <h1 class="text-center">User</h1>
        <main class="form-signin w-100 m-auto">
            <form action="/user" method="post">
                <label for="name">Name:</label>
                <input type="text" class="form-control shadow rounded" id="name" name="name" required value="${user.name}">
                <br>
                <label for="email">Email:</label>
                <input type="email" class="form-control shadow rounded" id="email" name="email" required value="${user.email}">
                <br>
                <label for="isEmailVerified">Is Email Verified:</label>
                <input type="text" class="form-control shadow rounded" id="isEmailVerified" name="isEmailVerified" value="${user.emailVerified?c}">
                <br>
                <label for="username">Username:</label>
                <input type="text" class="form-control shadow rounded" id="username" name="username" autocomplete="one-time-code" required value="${user.username}">
                <br>
                <label for="password">Password:</label>
                <input type="password" class="form-control shadow rounded" id="password" name="password" autocomplete="one-time-code" required value="${user.password}">
                <br>
                <input type="submit" class="btn btn-outline-primary" value="save">
            </form>

        </main>
    </div>
</@layout.header>
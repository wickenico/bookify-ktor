<#-- @ftlvariable name="user" type="com.nw.models.User" -->
<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container mt-5">
        <h1 class="text-center">Registration</h1>
        <main class="form-signin w-100 m-auto">
            <form action="/registration" method="post">
                <label for="name">Name:</label>
                <input type="text" class="form-control shadow rounded" id="name" name="name" required>
                <br>
                <label for="email">Email:</label>
                <input type="email" class="form-control shadow rounded" id="email" name="email" required>
                <br>
                <label for="isEmailVerified">Is Email Verified:</label>
                <input type="text" class="form-control shadow rounded" id="isEmailVerified" name="isEmailVerified">
                <br>
                <label for="username">Username:</label>
                <input type="text" class="form-control shadow rounded" id="username" name="username" autocomplete="one-time-code" required>
                <br>
                <label for="password">Password:</label>
                <input type="password" class="form-control shadow rounded" id="password" name="password" autocomplete="one-time-code" required>
                <br>
                <input type="submit" class="btn btn-outline-primary" value="submit">
                <input type="reset" class="btn btn-outline-primary" value="clear">
            </form>

        </main>
    </div>
</@layout.header>
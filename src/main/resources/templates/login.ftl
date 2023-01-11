<#import "_layout.ftl" as layout />
<@layout.header>
    <div class="container mt-5">
        <main class="form-signin w-100 m-auto">
<form>
    <img class="mb-4" src="static/bootstrap-logo.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
        <input type="text" class="form-control" id="floatingInput" name="username" placeholder="name@example.com">
        <label for="floatingInput">Email address</label>
    </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" name="password" placeholder="Password">
        <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <form action="/login" method="post" name="auth-form">
        <p>
            <input type="submit" class="btn btn-outline-primary" value="Login">
        </p>
        </form>

</form>
</main>
</div>
</@layout.header>
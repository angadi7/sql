<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Login</title>
</head>
<body>
  <h2>User Login Form</h2>
  <form action="/login" method="POST">
    <div>
      <label for="login-username">Username or Email:</label>
      <input type="text" id="login-username" name="login-username" required>
    </div>
    <div>
      <label for="login-password">Password:</label>
      <input type="password" id="login-password" name="login-password" required>
    </div>
    <button type="submit">Login</button>
  </form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>管理員登入 Login</title>
    <link rel="stylesheet" href="style/application.css" />
    <style>
      .screen {
        display: flex;
        height: 100vh;
        flex-direction: column;
      }

      .title {
        width: 30%;
        margin: 5% auto auto auto;
        font-size: 24px;
        line-height: 2em;
        text-align: center;
        border-radius: 5px;
        box-shadow: 10px 10px 10px grey;
      }

      .box {
        display: flex;
        flex-direction: column;
        width: 30%;
        padding: 3%;
        margin: auto;
        text-align: center;
        border-radius: 5px;
        box-sizing: border-box;
        box-shadow: 10px 10px 10px grey;
      }

      .box label {
        display: inline-block;
        width: 40%;
        margin-right: 3%;
        margin-bottom: 5%;
        text-align: right;
      }

      .box input {
        width: 40%;
        height: 100%;
        padding-left: 1%;
        border-width: 1px;
        border-style: solid;
        border-radius: 5px;
      }

      .box .btn {
        margin: auto;
        padding: 1%;
        border: none;
        border-radius: 5px;
      }

      div .temp {
        width: 40%;
        margin-top: 0.5%;
        margin-left: 22%;
        border-radius: 5px;
      }

      div a {
        display: inline-box;
        padding-left: 15%;
      }

      .alert {
        color: red;
        position: fixed;
        top: 40%;
        left: 36%;
      }
    </style>
  </head>

  <body>
    <div class="screen">
      <form action="login" method="post">
        <div class="title">管理員登入 / Admin Login</div>
        <nav class="box">
          <div>
            <label for="acc">帳號 / Account</label>
            <input
              id="acc"
              type="text"
              name="acc"
              autocomplete="new-text"
              autofocus
              required
            />
          </div>
          <div>
            <label for="passwd">密碼 / Password</label>
            <input id="passwd" type="password" name="passwd" required />
          </div>
          <br />
          <input class="btn" type="submit" value="提交 / Submit" />
        </nav>
        <div class="temp">
          <a class="temp" href="Test9876"
            ><img src="images/test.png" title="測試session"
          /></a>
        </div>
      </form>
    </div>
  </body>
</html>

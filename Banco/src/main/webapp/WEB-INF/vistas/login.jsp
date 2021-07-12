<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>UTN BANK | Log in</title>

  <!-- Google Font: Source Sans Pro -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&amp;display=fallback">
  <link rel="stylesheet"   href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

  <!-- Font Awesome -->
  <link rel="stylesheet" href="content/login/font-awesome.min.css">
 
  <!-- icheck bootstrap -->
  <link rel="stylesheet" href="content/login/icheck-bootstrap.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="content/login/adminlte.min.css">
  
  <!-- Bootstrap CSS -->
  <script src="content/nav/icons.js"></script>
   
  <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
  
    
    <!-- SweetAlert2 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/fullcalendar@5.5.1/main.min.css">
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.5.1/main.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.5.1/locales-all.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
</head>
<body class="hold-transition login-page" background="content/images/fondo.jpg" style="background-size: cover">
<div class="login-box">
  <div class="login-logo">
    <a href=""><b>UTN</b>&nbsp;Bank</a>
    <div class= "col-md-12">
    	<img src="content/images/logo.png" width="160px" height="160px"></img>
    </div>

  </div>
  <!-- /.login-logo -->
  <div class="card" >
    <div class="card-body login-card-body" style="border-radius: 44px">
      <p class="login-box-msg">Completa tus datos para iniciar sesión</p>

      <form method="POST" action="login.html">

		<div class="input-group mb-3">
          <input name="dni" type="number" class="form-control" placeholder="DNI">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fa fa-id-card"></span>
            </div>
          </div>
        </div>
        
     	<div class="input-group mb-3">
			<input name="nombreUsuario" type="password" class="form-control"
				placeholder="Usuario">
			<div class="input-group-append">
				<div class="input-group-text">
					<span class="fa fa-user"></span>
				</div>
			</div>
		</div>
        
        <div class="input-group mb-3">
          <input name="contrasenia" type="password" class="form-control" placeholder="Contraseña">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fa fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          
          <!-- /.col -->
          <div class="col-md-6">
            <button type="submit" class="btn btn-primary btn-block">Iniciar sesion
            <span class="fa fa-sign-in"></span>
            </button>
          </div>
          <!-- /.col -->
        </div>
      </form>
<br>
      
      <!-- /.social-auth-links -->

      <p class="mb-1">
        <a href="emailpassword.jsp">Olvide mi contraseña</a>
      </p>
     
    </div>
    <!-- /.login-card-body -->
  </div>
</div>

<!--      
<script type="text/javascript">
   console.log('paso 1');
    $('#login').submit(function(e) {
   console.log('paso 2');
        $.ajax({
            url: './test.html',
            type: 'POST',
            data: {
            	nombreUsuario: $('#nombreUsuario').val(), 
                contrasenia: $('#contrasenia').val(), 
                dni: $('#dni').val()
            },
            //processData: false,
            contentType: "application/json"
        });
   console.log('paso 3');
        e.preventDefault();
    });
</script>
-->

    
    <c:if test="${!empty error}">
	    <script>
			Swal.fire({
			  icon: 'error',
			  title: 'Ups...',
			  text: '${error}',
			});
		</script>
	</c:if>

</body>
</html>
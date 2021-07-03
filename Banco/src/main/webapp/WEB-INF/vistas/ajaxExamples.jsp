<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ejemplos AJAX</title>

 <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  
</head>
<body style="background-color: gray;">
        
<form id="params" action="#">
	DNI: <input type="number" name="dni" id="dni"> <br>
	Nombre de usuario: <input type="text" name="nombreUsuario" id="nombreUsuario"> <br>
	Contraseña: <input type="password" name="contrasenia" id="contrasenia"> <br>
<input type="submit" value="Ajax por parámetros">
</form>

<hr>
        
<form id="obj" action="#">
	DNI: <input type="number" name="dni2" id="dni2"> <br>
	Nombre de usuario: <input type="text" name="nombreUsuario2" id="nombreUsuario2"> <br>
	Contraseña: <input type="password" name="contrasenia2" id="contrasenia2"> <br>
<input type="submit" value="Ajax por objeto">
</form>


<script type="text/javascript">
   	$(function () {

		$('#params').submit(function(e){
			e.preventDefault();
			
	   		var data = {
	 			nombreUsuario: $('#nombreUsuario').val(),
	 			contrasenia: $('#contrasenia').val(),
	 			dni: $('#dni').val()
	   		};
	   		
	        $.ajax({
	            url: './ajaxParams.html',
	            type: 'POST',
	            data: data,
	            success: function (result) {
	                alert(result);
	            },
	            error: function(xhr, ajaxOptions, thrownError) {
	            	console.dir(xhr);
	            	var errorMsg = 'Error ' + xhr.status + '\r\n' + xhr.responseText;
	                alert(errorMsg);
	            }
	        });			
			
		});

		$('#obj').submit(function(e){
			e.preventDefault();
			
	   		var data = {
		 		nombreUsuario: $('#nombreUsuario2').val(),
		 		contrasenia: $('#contrasenia2').val(),
	 			cliente: {
		 			dni: $('#dni2').val()
	 			}
	   		};
	   		
	        $.ajax({
	            url: './ajaxObj.html',
	            type: 'POST',
	            data: JSON.stringify(data),
	            contentType: "application/json;charset=utf-8",
	            dataType: 'json',
	            success: function (response) {
	                console.dir(response);
	            },
	            error: function(xhr, ajaxOptions, thrownError) {
	            	var errorMsg = 'Error ' + xhr.status + '\r\n' + xhr.responseText;
	                alert(errorMsg);
	            }
	        });	        
			
		});

   		
   	});
</script>

</body>
</html>
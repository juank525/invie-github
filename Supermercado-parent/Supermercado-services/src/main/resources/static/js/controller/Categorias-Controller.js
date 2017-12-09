/**
 * 
 */
app.controller('categoriasController', function($scope, $http) {

	console.log("Inicio Consumo servicio categorias")

	$scope.fnListarCategorias = function() {
		$http.get("/rest/servicio/categorias").then(function(response) {
			$scope.listCategorias = response.data;
			console.log($scope.listCategorias);
		})
	};

	$scope.fnLlenarModificar = function(id) {
		$scope.varMod = true;
		console.log("Llenar datos");
		console.log("ID CATEGORIA" + id);
		$scope.nombre = "";
		$scope.descripcion = "";

		var url = "/rest/servicio/categorias/" + id;
		$http.get(url).then(function(response) {
			$scope.nombreCategoria = response.data.nombre;
			$scope.descripcionCategoria = response.data.descripcion;
		});
	};

	$scope.fnLimpiarModal = function() {
		$scope.varMod = false;
		$scope.nombreCategoria = "";
		$scope.descripcionCategoria = "";
	};

	$scope.fnGuardarCategorias = function() {
		data = {
			"nombre" : $scope.nombreCategoria,
			"descripcion" : $scope.descripcionCategoria
		};

		console.log("Inicio llamado metodo Post");
		$http.post("/rest/servicio/categorias/addCategoria", data).then(
				function(response) {
					console.log("Respuesta metodo post:" + response);
					$scope.fnListarCategorias();
				});

	};

});
function ProductListController($scope, $http, $routeParams) {

	$scope.urlProducto = "http://" + document.location.hostname + ":"
			+ document.location.port + "/ticket-monster/rest/producto/get";
	$scope.datos = null;
	$scope.query = "";
	$scope.jsonToShow = null;
	var oTable = null;
	$scope.combo=[
                   {name:'Todos', url:'http://' + document.location.hostname + ":"
           				+ document.location.port + '/ticket-monster/rest/producto/list?titulo='},
                   {name:'Sofware', url:'http://' + document.location.hostname + ":"
               			+ document.location.port + '/ticket-monster/rest/producto/software/list?titulo='},
                   {name:'Discos', url:'http://' + document.location.hostname + ":"
                   		+ document.location.port + '/ticket-monster/rest/producto/disco/list?titulo='},
                   {name:'Peliculas', url:'http://' + document.location.hostname + ":"
                   		+ document.location.port + '/ticket-monster/rest/producto/pelicula/list?titulo='}
                 ];
	$scope.url = $scope.combo[0].url;
	

	$scope.armarTabla = function() {

		oTable = $('.dataTable').dataTable({
				"bProcesing" : true,
		 	 	"bDestroy": true,
		 	 	"bLenthChange" : false,				
				"sAjaxSource" : $scope.url + $scope.query,
				"sAjaxDataProp" : "",
				"fnServerData" : function(sSource, aoData, fnCallback) {
		 	 		$.getJSON( sSource, aoData, function (json) {
		                fnCallback(json);
		 		});
		 	 	},
		 	 	"fnDrawCallback": function( oSettings ) {
					setupRowActions();
			    },
		        
		        "aoColumns" : [{
					"mData" : "id"
				}, {
					"mData" : "codigo"
				}, {
					"mData" : "precio"
				}, {
					"mData" : "titulo"
				}, {
					"mData" : "descripcion"		
				}, {
					"mData" : function (oObj)                              
		                  {
		                      // call Modal
						var a = "<a data-toggle='modal' class='btn btn-primary' idButton='modalId' role='button' href='#myModal1'>Ver</a>";
						return a;
		                  }
		                  }
				]
			  });
		};

	$scope.buscarWs = function() {

		$scope.armarTabla();
		
	};
	
	setupRowActions = function() {
		$("a[role~='button'][idButton='modalId']").unbind("click");
		$("a[role~='button'][idButton='modalId']")
				.click(
						function(evt) {
							var rowIndex = oTable.fnGetPosition($(evt.target)
									.closest('tr').get(0));
							var record = oTable.fnGetData(rowIndex);
							$("#myModal1").find(".modal-body").empty();
							console.info(record.codigo);
							$http({method: 'GET', url: $scope.urlProducto + "/" + record.codigo}).
						      success(function(status) {
						    	  string = JSON.stringify(status);
						    	  string = replaceAll("{", "", string);
						    	  string = replaceAll("}", "", string);
						    	  string = replaceAll(",", "<br/>", string);
						    	  string = replaceAll(":", "= ", string);
						    	  string = replaceAll('"', "", string);
						    	  
						    	  $("#myModal1").find(".modal-body").append(
						    			  string);
						    	  console.info(status);
						        }).
						        error(function(status) {
						          $scope.status = status.mensaje;
						      });
							
						});

	};
	
	function replaceAll(find, replace, str) 
    {
      while( str.indexOf(find) > -1)
      {
        str = str.replace(find, replace);
      }
      return str;
    }
	

}

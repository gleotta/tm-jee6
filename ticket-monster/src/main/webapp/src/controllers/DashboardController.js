function DashboardController($scope,  $http, $routeParams) {
	
	$scope.url = "http://" + document.location.hostname + ":"
	+ document.location.port + '/pathfinder/rest/findeventsstatistics';
	$scope.pieData = null;
	$scope.barChartData = null;
	var myPie = null;
	var myLine = null;

	$http({ method: 'GET', url: $scope.url}).
	  success(function (data, status, headers, config) {
		  $scope.pieData = [
		          			{
		          				//processed
		        				value: data.processedEventQuantity,
		        				color:"#F38630"
		        			},
		        			{
		        				//unprocessed
		        				value : data.unProcessedEventQuantity,
		        				color : "#E0E4CC"
		        			}
		        			];
		  
			myPie = new Chart(document.getElementById("canvas").getContext("2d")).Pie($scope.pieData);

			processed = new Array();
			unprocessed = new Array();
			days = new Array();
			var i = 0;
			for(i=0; i<data.dayWrapper.length;i++){
				processed[i] = data.dayWrapper[i].processed;
				unprocessed[i] = data.dayWrapper[i].unProcessed;
				days[i] = moment(data.dayWrapper[i].date).format(
				'DD/MM');
			}
			
			$scope.barChartData = {
					labels : days,
					datasets : [
						{
							fillColor : "rgba(220,220,220,0.5)",
							strokeColor : "rgba(220,220,220,1)",
							data : processed
						},
						{
							fillColor : "rgba(151,187,205,0.5)",
							strokeColor : "rgba(151,187,205,1)",
							data : unprocessed
						}
					]
				};
			console.info(processed);
			console.info(unprocessed);
			console.info(days);
			myLine = new Chart(document.getElementById("canvas2").getContext("2d")).Bar($scope.barChartData);	

			
			
	  }).
	  error(function (data, status, headers, config) {
	    // ...
	  });
	 
	
		
		$scope.armarPie = function() {
		}
	
}

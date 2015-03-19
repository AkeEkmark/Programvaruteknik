angular.module("calcApp", []).controller("CalcCtrl", function ($scope) {
		$scope.displayValue = 0;
		$scope.memory = null;
		$scope.result = 0;
		$scope.operation = null;
		$scope.firstValue = true;
		$scope.addText = function(value) {
			if ($scope.firstValue) {
				$scope.displayValue = value;
				$scope.firstValue = false;
			}
			else {
				$scope.displayValue += value;
			}
			
		};
		$scope.saveInMemory = function() {
			if ($scope.memory == null) {
				$scope.memory = parseFloat($scope.displayValue);
			}
		};
		$scope.setOperator = function (operator) {
			$scope.saveInMemory();
			$scope.operation = operator;
			$scope.displayValue = 0;  
			$scope.firstValue = true;
		};
		$scope.clear = function () {
			$scope.displayValue = 0;
			$scope.memory = null;
			$scope.result = 0;
			$scope.operation = null;
			$scope.firstValue = true;
		};
		$scope.sum = function () {
			if ($scope.operation == "+"){
				$scope.result = parseFloat($scope.memory) + parseFloat($scope.displayValue);
			}
			else if ($scope.operation == "-"){
				$scope.result = parseFloat($scope.memory) - parseFloat($scope.displayValue);
			}
			else if ($scope.operation == "*"){
				$scope.result = parseFloat($scope.memory) * parseFloat($scope.displayValue);
			}
			else if ($scope.operation == "/"){
				$scope.result = parseFloat($scope.memory) / parseFloat($scope.displayValue);
			}
 
			$scope.memory = $scope.result;
			$scope.displayValue = $scope.result;
		};
	});
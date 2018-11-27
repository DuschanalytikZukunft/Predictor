var app = angular.module("predictor", []);

app.controller('AppCtrl', function ($scope, $http) {
    $http({
        method: 'GET',
        url: 'http://localhost:8090/api/predictor'
    }).then(function (response) {
        $scope.websites = response.data;
    }, function (error) {
        console.log("error = " + error.status);
    });
});
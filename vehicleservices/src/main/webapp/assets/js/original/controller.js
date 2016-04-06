var app = angular.module('app', ['ngRoute', 'model']);

app.controller('loginCtrl', ['$scope', '$http', '$location', 'model', function ($scope, $http, $location, model) {
    $scope.model = model;
    $scope.customers = [];

    $http({
        cache: false,
        url: "/school/api/customers/all",
        method: 'GET'
    }).success(function (result) {
        console.log(result);
        model.setCustomers(result);
        $scope.customers = result;
    });

    //bound to input for login
    $scope.user;
    $scope.$watch('user', function (newValue, oldValue) {
        model.setCurrentUser(newValue);
    });

    $scope.password;
    $scope.loggedIn = false;

    $scope.loginFailed = false;

    $scope.registerNewAccountClicked = function () {
        $location.path('/register');
    };

    $scope.loginClicked = function () {
        for (var i = 0; i < $scope.customers.length; i++) {
            if ($scope.customers[i].userName === $scope.user && $scope.customers[i].password === $scope.password) {
                $scope.loggedIn = true;
                $scope.loginFailed = false;
                model.setLoggedIn(true);
                $location.path('/home');
                console.log('login successful');
                return;
            }
        }
        console.log('login failed');
        $scope.loginFailed = true;
        $scope.password = "";
        $scope.user = "";
    };
}]);

app.controller('homeCtrl', ['$scope', '$http', '$location', 'model', function ($scope, $http, $location, model) {
    $scope.model = model;

    $scope.home = true;
    $scope.addingVehicle = false;



    $scope.customers = model.getCustomers();
    $scope.customerInfo;

    if (model.getLoggedIn() == false) {
        $location.path('/login');
    }
    for (var i = 0; i < $scope.customers.length; i++) {
        if($scope.customers[i].userName == model.getCurrentUser()){
            $scope.customerInfo = $scope.customers[i];
            console.log($scope.customerInfo);
        }
    }

    $scope.logout = function () {
        model.setLoggedIn(false);

        $location.path('/login');
    };

    $scope.showAddVehicle = function(){
        $scope.addingVehicle = true;
    };

    $scope.make ="";
    $scope.model ="";
    $scope.mileage ="";
    $scope.year ="";
    $scope.condition ="";
    $scope.addVehicle = function(){
        $http({
            cache: false,
            url: "/school/api/vehicle/add",
            method: 'POST',
            data: {
                make:$scope.make,
                model:$scope.model,
                mileage:$scope.mileage,
                year:$scope.year,
                condition:$scope.condition,
                customerId:$scope.customerInfo.customerId
            },
            transformResponse: function (data, headersGetter, status) {
                //This was implemented since the REST service is returning a plain/text response
                //and angularJS $http module can't parse the response like that.
                return {data: data};
            }
        }).success(function (result) {

        });
    };
}]);

app.controller('registerCtrl', ['$scope', '$http', '$location', 'model', function ($scope, $http, $location, model) {
    $scope.model = model;
    $scope.registerFailed = false;
    $scope.user = "";
    $scope.password = "";
    $scope.fName = "";
    $scope.lName = "";
    $scope.email = "";
    $scope.phone = "";

    //go back to login page
    $scope.loginClicked = function () {
        $location.path('/login');
    };

    //put username info in database
    $scope.registerClicked = function () {
        if($scope.user.length == 0 ||$scope.password.length == 0 || $scope.fName.length == 0 || $scope.lName.length == 0 || $scope.email.length == 0 || $scope.phone.length == 0){
            $scope.registerFailed = true;
            return;
        }
        $scope.registerFailed = false;
        model.setCurrentUser($scope.user);
        model.setLoggedIn(true);
        $http({
            cache: false,
            url: "/school/api/customers/add",
            method: 'POST',
            data: {
                userName:$scope.user,
                password:$scope.password,
                firstName:$scope.fName,
                lastName:$scope.lName,
                email:$scope.email,
                phone:$scope.phone
            },
            transformResponse: function (data, headersGetter, status) {
                //This was implemented since the REST service is returning a plain/text response
                //and angularJS $http module can't parse the response like that.
                return {data: data};
            }
        }).success(function (result) {
            $http({
                cache: false,
                url: "/school/api/customers/all",
                method: 'GET'
            }).success(function (result) {
                model.setCustomers(result);
                $scope.customers = result;
                $location.path('/home');
            }).error(function () {
                $scope.registerFailed = true;
            });
        });
    };

}]);

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when("/login", {
        templateUrl: '/angular/login',
        controller: 'loginCtrl',
        reloadOnSearch: true
    }).when("/register", {
        templateUrl: '/angular/register',
        controller: 'registerCtrl',
        reloadOnSearch: true
    }).when("/home", {
        templateUrl: '/angular/home',
        controller: 'homeCtrl',
        reloadOnSearch: true
    }).otherwise({
        redirectTo: "/login"
    });
}]);
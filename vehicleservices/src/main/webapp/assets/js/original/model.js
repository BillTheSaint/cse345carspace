var model = angular.module('model', []);

model.factory("model", [function () {
    var currentUser;
    var loggedIn = false;
    var customers;

    return {
        'getCurrentUser':function(){
            return currentUser;
        },
        'setCurrentUser':function(value){
            currentUser = value;
        },
        'getLoggedIn':function(){
            return loggedIn;
        },
        'setLoggedIn':function(value){
            loggedIn = value;
        },
        'getCustomers':function(){
            return customers;
        },
        'setCustomers':function(value){
            customers = value;
        }
    };
}]);
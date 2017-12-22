(function () {
  'use strict';

  angular.module('Onews')
    .controller('homeController', ['$scope', '$rootScope', 'CategoryService', function ($scope, $rootScope, CategoryService) {

      // $scope.message = 'test';
      var self = this;

      self.$onInit = onInit;

      function onInit() {

        if ($rootScope.globals.currentUser) {
          $scope.user = angular.copy($rootScope.globals.currentUser);
        }

        CategoryService.GetByLevel(1)
          .then(function (response) {
            if (response.success) {
              $scope.categories = angular.copy(response.category_list);
            }
          });
      }
    }]);
})();
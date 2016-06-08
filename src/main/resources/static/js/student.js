angular.module('com.igumnov.assignment2', ['ui.bootstrap', 'ngResource'])


    .factory('Student', ['$resource', function ($resource) {
        return $resource('/api/student/', {
        }, {
            get: {
                method: 'GET',
                cache: false,
                isArray: true
            }
        });
    }])
    .factory('Location', ['$resource', function ($resource) {
        return $resource('/api/student/:id/location', {
            id: '@id'
        }, {
            set: {
                method: 'PUT',
                cache: false,
                isArray: false
            }
        });
    }])



    .controller('StudentCtrl', function ($scope, Student, $modal) {

        $scope.reloadStudents = function () {
            Student.get({}, function (data) {
                $scope.students = data;
            });
        }

        $scope.reloadStudents();

        $scope.setLocation = function (student) {

            var modalInstance = $modal.open({
                templateUrl : '/ng-templates/setlocation',
                controller : 'SetLocationModalCtrl',
                size : 'sm',
                resolve: {
                    student: function () {
                        return student;
                    }
                }
            });

            modalInstance.result.then(function() {
                    $scope.reloadStudents();
                },

                function() {
                    $scope.reloadStudents();
                });
        }

    })


    .controller('SetLocationModalCtrl', function($scope, $modalInstance, student, Location) {

        $scope.student = {
            name: student.name,
            latitude: student.latitude,
            longitude: student.longitude

        };

        $scope.save = function () {
            Location.set(
                {id: student.id},
                {
                    latitude: $scope.student.latitude,
                    longitude: $scope.student.longitude
                }, function(data) {
                    $modalInstance.close();
                }
            )
        }

    })

;
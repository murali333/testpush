App.factory('UserService', ['$http', '$q', function($http, $q){
	var user = {
		userName: ''
	};
	var Id ={
		id:4
	}
	var id =4;
	var productList = [];
	return {

	     getUser : function(user){
                    return $http.post('http://localhost:8080/user/login', angular.toJson(user))
                            .then(
                                    function(response){
										//alert(JSON.stringify(response.data));
										//user=response.data;
										user.userName=response.data.userName;
										productList.push(user.userName);
										console.log("username::"+user.userName);
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while getting response');
                                        return $q.reject(errResponse);
                                    }
                            )
            },
			
			
			shareUser : function(){
				console.log("share user's username::"+user.userName);
				return productList;
			},
			
			
			deleteUser : function(id){
				alert("Inside delete service")
                   /* return $http.delete('http://localhost:8080/user/delete', JSON.stringify(id))
                            .then(
                                    function(response){
										
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while getting response');
                                        return $q.reject(errResponse);
                                    }
                            )*/
							
							
							/*return $http({
                                 method: 'DELETE',
                                  url: 'http://localhost:8080/user/delete',
                               data: {
                                   id: 4
                                   },
                         headers: {
                              'Content-type': 'application/json;'
                                  }
                        })
                  .then(function(response) {
    console.log(response.data);
          }, function(rejection) {
    console.log(rejection.data);
                });*/
				
				
				return $http({
                                 method: 'DELETE',
                                  url: 'http://localhost:8080/user/'+id,
								    headers: {
                              'Content-type': 'text/plain'
                                  }
                              
                        })
                  .then(function(response) {
    console.log(response.data);
          }, function(rejection) {
    console.log(rejection.data);
                });
            },
			
			
			
			uploadFileToUrl: function(file){
				var fd = new FormData();
               fd.append('file', file);
            
               $http.post("http://localhost:8080/user/fileupload", fd, {
                  transformRequest: angular.identity,
                  headers: {'Content-Type':undefined}
               })
            
               .success(function(){
				   alert("success");
               })
            
               .error(function(){
				   alert("error");
               });
               
               
             /*  $http({
                   method: 'POST',
                   url: "http://localhost:8080/user/fileupload",
                   headers: {'Content-Type': 'multipart/form-data'},
                   data: fd,
                   transformRequest: function(data, headersGetterFunction) {
                                   return data;
                    }
                })
               .success(function(data, status) {   
                               alert("success");
                })*/
				
			},
            
            getCity:function(){
            	
            	  return $http.get('http://localhost:8080/user/city')
                  .then(
                          function(response){
								alert(JSON.stringify(response.data));
                              return response.data;
                          }, 
                          function(errResponse){
                              console.error('Error while getting response');
                              return $q.reject(errResponse);
                          }
                  )
            	
            }
            
			
			
			 };
			 return userService;
			 
}]);
	

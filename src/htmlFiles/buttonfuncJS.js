// Anders Kaae Pedersen


        function showAll() {
            $.get("http://localhost:8088/person", function(data) {
                var output = "<table><tr><th>id</th><th>email</th><th>firstName</th><th>lastName</th><th>phone</th></tr>";
                
                for(var i = 0; i < data.length; i++) {
                    output += "<tr><td>" + data[i].id +"</td><td>"+ data[i].email +"</td><td>" + data[i].firstName +"</td><td>"+ data[i].lastName +"</td><td>"+ data[i].phone + "</td></tr>";
                   
                }
                output += "</table>";
                    $("#findAllresult").html(output);
            });
        }
        
        function findPerson() {
            var id = $("#personInput").val();
                $.ajax({
                    url: "http://localhost:8088/person/" + id,
                    type: 'GET',
                    success: function(data) {
                        $("#personSearchResult").html(
                            "firstName: " + data.firstName + "<br> lastName: " + data.lastName); 
                    },
                    error: function(data, textStatus, jqXHR) {
                        var jsonResponse = JSON.parse(data.responseText);
                        alert(jsonResponse.error);
                    }
                });
        }
        
        function addPerson() {}
        
        function deletePerson() {}
        
        function assignRole(){}
        
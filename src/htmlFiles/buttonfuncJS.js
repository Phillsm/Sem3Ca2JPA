// Anders Kaae Pedersen


function showAll() {
$.get("http://localhost:8088/person", function(data) {
var output = "<table><tr><th>id</th><th>email</th><th>firstName</th><th>lastName</th><th>phone</th></tr>";
        for (var i = 0; i < data.length; i++) {
output += "<tr><td>" + data[i].id + "</td><td>" + data[i].email + "</td><td>" + data[i].firstName + "</td><td>" + data[i].lastName + "</td><td>" + data[i].phone + "</td></tr>";
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

function addPerson() {
    var firstName = $("#firstNameInput").val();
    var lastName = $("#lastNameInput").val();
    var email = $("#emailInput").val();
    var phone = $("#phoneInput").val();
    
    var person = {};
    person.firstName = firstName;
    person.lastName = lastName;
    person.email = email;
    person.phone = phone;
        console.log(person);
        
        $.ajax({
                url: "http://localhost:8088/person",
                type: 'POST',
                data: JSON.stringify(person),
                success: function(){
                    alert("Person inserted");
                    
                }
                
        });
        };
        
        
        function deletePerson() {
        var id = $("#deleteID").val();
        
        $.ajax({
           url:"http://localhost:8088/person/" + id,
           type : 'DELETE',
           success : function(){
               alert("Person deleted");
           }
        });
        }
        

function assignRole(){}
        
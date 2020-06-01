
function functioncall() {

var form = document.forms["formStudent"];

var requestParameters =
	"id=" + form["txtId"].value +
	"&lastname=" + form["txtlastName"].value + 
	"&firstname=" + form["txtfirstName"].value + 
	"&street=" + form["txtStreet"].value + 
	"&postcode=" + form["txtPostcode"].value + 
	"&postoffice=" + form["txtPostoffice"].value;

var url = "http://localhost:8080/WebAppExercises/addStudent?";

postDataToServer(url,requestParameters, processAddResponse);

}

function processAddResponse(status) {
	if (status.errorCode === 0) { 
		alert("Student added.");
	}
	else if (status.errorCode === 1) {
		alert("Cannot add the student. The id is already in use!");
	} else {
		alert("The database is temporarily unavailable. Please try again later.");
	} 
}

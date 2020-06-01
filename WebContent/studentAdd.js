
function main() {
	var studentList = postDataToServer();
}

function printStudent(studentList)  {

var form = document.forms["formStudent"];

var requestParameters =
	"id=" + form["txtId"].value +
	"&lastname=" + form["txtlastName"].value + 
	"&firstname=" + form["txtfirstName"].value + 
	"&street=" + form["txtStreet"].value + 
	"&postcode=" + form["txtPostcode"].value + 
	"&postoffice=" + form["txtPostoffice"].value;

}

main();
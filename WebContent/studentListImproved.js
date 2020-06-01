
function main() {
	
	var studentList = getDataFromServer();
	
}


function printStudent(studentList) {
	
	
	var studentArray = studentList;
	console.log(studentArray);
	
	var outputText = "";
	var outputText2 = "";
	
	
	var bodyStudent = document.getElementById("tbody_student");
	
	for (var i =0; i <studentArray.length; i++) { 
		
		
		outputText = "<td>" + studentArray[i].id + "</td>" + "<td>" + studentArray[i].lastname + "</td>" + "<td>" + studentArray[i].firstname + "</td>" + "<td>" + studentArray[i].streetaddress + "</td>" + "<td>" + studentArray[i].postcode + "</td>" + "<td>" + studentArray[i].postoffice + "</td>";
		outputText2 = `<td>${studentArray[i].id}</td><td>${studentArray[i].lastname}</td><td>${studentArray[i].firstname}</td><td>${studentArray[i].streetaddress}</td><td>${studentArray[i].postcode}</td><td>${studentArray[i].postoffice}</td>`

		
		var newRow = document.createElement("tr");
		newRow.innerHTML = outputText2;
		
		bodyStudent.appendChild(newRow);
		
	}
	
}

main();

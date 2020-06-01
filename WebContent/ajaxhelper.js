
function getDataFromServer() {
	
	fetch("http://localhost:8080/WebAppExercises/students")
		.then(response => {
			if (response.ok) {
				return response.json();
			} else {
				throw "HTTP status code is " + response.status;
			}
		})
	.then(studentList => printStudent(studentList))
	.catch(errorText => alert("getDataFromServer failed: " + errorText));
}


function postDataToServer(url, requestParameters, processAddResponse) {
	 
	fetch( url + requestParameters, {method:"POST"})
	.then(response => {
		if (response.ok) {
			return response.json();
		} else {
			throw "HTTP status code is " + response.status;
		}
	})
.then(status => processAddResponse(status))
.catch(errorText => alert("postDataToServer failed: " + errorText));
	
}
	
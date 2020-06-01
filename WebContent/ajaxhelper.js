
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


function postDataToServer() {
	
	fetch("http://localhost:8080/WebAppExercises/addStudent")
	.then(response => {
		if (response.ok) {
			return response.json();
		} else {
			throw "HTTP status code is " + response.status;
		}
	})
.then(studentList => printStudent(studentList))
.catch(errorText => alert("postDataToServer failed: " + errorText));
}
	



/*function getDataFromServer() {
	
	fetch("http://localhost:8080/WebAppExercises/students")
	.then(response => response.json())
	.then(studentList => printStudent(studentList))
	.catch(errorText => alert("getDataFromServer failed: " + errorText));
	
}
*/


function showUpdateForm(id,f_name,l_name,email,mobile,addr,gender, password) {
           
           	document.getElementById("empId").value = id;
            document.getElementById("empFName").value = f_name;
			document.getElementById("empLName").value = l_name;
			document.getElementById("empEmail").value = email;
			document.getElementById("mobile").value = mobile;
			document.getElementById("Address").value =addr;
			if(gender==="male")
            document.getElementById("male").checked=true;
			else
			document.getElementById("female").checked=true;
			document.getElementById("password").value = password;
			document.getElementById("updateForm").style.display = "block";
			document.getElementById("overlay").style.display = "block";
			}
			
function hideUpdateForm() {
  document.getElementById('updateForm').style.display = 'none';
   // Hide the form
   document.getElementById("overlay").style.display = "block";
}
function deleteEmployee(id)
{
	
}
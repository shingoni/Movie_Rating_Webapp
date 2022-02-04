<#include "mrheader.ftl">

<b>Welcome to our little demonstration on the MR Webapp</b><br><br>

<form method="POST" action="uugui?action=registerUser">
	<fieldset id="registeruser">
		<legend>Required Information</legend>
		<div>
			<label>name</label>
			<input type="text" name="name">
	    </div>

		<div>
			<label>email</label>
			<input type="email" name="email">
	    </div>

		<div>
			<label>age</label>
			<input type="number" name="age" required min = "18">
	    </div>
	    
	</fieldset>
	<button type="submit" id =Register name="register" value="Register">
	Register</button>
</form>
<#include "footer.ftl">
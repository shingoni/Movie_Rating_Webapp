<#include "mrheader.ftl">

<b>Welcome to our little demonstration on the VR Webapp</b><br><br>

<form method="POST" action="rugui?action=addMovie">
	<fieldset id="addmovie">
		<legend>Required Information</legend>
		<div>
			<label>Title</label>
			<input type="text" name="title" >
	    </div>

		<div>
			<label>director</label>
			<input type="text" name="director">
	    </div>
		<div>
			<label>mainactor</label>
			<input type="text" name="mainactor">
	    </div>
	    <div>
	    	<label>publishdate</label>
	    	<input type="number" name="publishdate">
	    </div>
	</fieldset>
	<button type="submit" id="submit">Submit</button>
</form>
<#include "footer.ftl">
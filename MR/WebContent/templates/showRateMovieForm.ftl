<#include "mrheader.ftl">

<b>Welcome to our little demonstration on the VR Webapp</b><br><br>

<form method="POST" action="rugui?action=rateMovie">
	<fieldset id="ratemovie">
		<legend>Required Information</legend>
		<div>
			<label>Title</label>
			<input type="text" name="title" >
	    </div>
		<div>
			<label>Comment</label>
			<input type="text" name="comment" >
	    </div>

		<div>
			<label>Score</label>
			<input type="number" min=1 max=10 name="score">
	    </div>
	</fieldset>
	<button type="submit" id="submit">Submit</button>
</form>
<#include "footer.ftl">
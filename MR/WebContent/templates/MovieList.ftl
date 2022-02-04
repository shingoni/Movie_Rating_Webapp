<#include "mrheader.ftl">

<b>Welcome to our little demonstration on the MR Webapp</b>

<table id="Movies">
	<tr>
		<th>title</th>
		<th>director</th>
		<th>main Actor</th>
		<th>Publish Date</th>
		
	</tr>
	<#list movielist as ml>
	<tr>
		<td>${ml.title}</td>
		<td>${ml.director}</td>
		<td>${ml.mainactor}</td>
		<td>${ml.publishdate}</td>
	</tr>
	</#list>
</table>
<#include "footer.ftl">
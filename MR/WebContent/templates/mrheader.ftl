<!DOCTYPE HTML>
<html lang='de' dir='ltr'>
<head>
	<meta charset="utf-8" />
	<title>Movie Rating App - ${pagetitle}</title>
	<link type="text/css" href="css/style.css" rel="stylesheet" media="screen" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" />
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  	
</head>
<body>
<div id="wrapper">
	<div id="logo">Movie Rating App<br>Software Engineering Group 02</div>
	<ul id="navigation">


        <#if navtype == "User">
            <li><a href="index" >View Homesite</a></li>
             <li><a href="rugui?action=addMovie" >Add Movie</a></li>
            <li><a href="rugui?action=showMovie">Show Movies List</a></li>
             <li><a href="rugui?action=rateMovie">Rate Movie</a></li>


        <#else>
            <li><a href="defaultWebpageuu" >Register</a></li>

        </#if>

    </ul>
	<div id="content">
	
	
	
	
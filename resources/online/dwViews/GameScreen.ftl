<html>

	<head>
		<!-- Web page title -->
    	<title>Top Trumps</title>
    	
    	<!-- Import JQuery, as it provides functions you will probably find useful (see https://jquery.com/) -->
    	<script src="https://code.jquery.com/jquery-2.1.1.js"></script>
    	<script src="https://code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
    	<link rel="stylesheet" href="https://code.jquery.com/ui/1.11.1/themes/flick/jquery-ui.css">

		<!-- Optional Styling of the Website, for the demo I used Bootstrap (see https://getbootstrap.com/docs/4.0/getting-started/introduction/) -->
		<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/TREC_IS/bootstrap.min.css">
    	<script src="http://dcs.gla.ac.uk/~richardm/vex.combined.min.js"></script>
    	<script>vex.defaultOptions.className = 'vex-theme-os';</script>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex.css"/>
    	<link rel="stylesheet" href="http://dcs.gla.ac.uk/~richardm/assets/stylesheets/vex-theme-os.css"/>
    	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

	</head>

    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
		<style>
			body {
			display: flex;
			flex-direction: column;
			justify-content: baseline;
			align-items: center;
			color: #666;
			font-size: 1.3em;
			font-family: sans-serif;
			background-color: #d6dadf;
			}
			.header{ 
			width:100%;
			text-align:center;
			margin-top:20px;
			}
			.container { 
			padding 2px 16px;
			text-align: left;
			font-family: Times;
			}
			.button {
			width: 170px;
			height: 35px;
			display: block;
			color: #000;
			border-radius: 25px; 
			rgba(0,0,0,0.3);
			white-space: nowrap;
			cursor: pointer;
			}
			.nextButton{
			background: #D3D3D3;
			color:#696969;
			position: absolute;
				right: 0;
				bottom: 100;
				left: 200;
			width: 200px;
			height: 40px;
			display: block;
			font: Times;
			border-radius: 25px; 
			text-align: center;
			cursor: pointer;
			} 
			.card { 
			background-color:#d6dadf;
			box-shadow: 1px 1px 8px #454545;
			border-radius: 25px; 
			rgba(0,0,0,0.2);
			width: 16%;
			height:50%;
			display:inline-block;
			margin: 8px;
			margin-top:30px;
			}
			img {
			border-radius: 8px;
			}
       </style>
    	<div class="container">

			<!-- Add your HTML Here -->
		<div class="header"> 
        <div> 
        <h2 class="header" style="text-align:center";> The Game Start Now! The active user is YOU </h2>
        </div> 
        <button type="button" style="margin-top:30px";id="nextButton" onclick="updateGame();" class="btn btn-primary btn-lg;">Next</button>
        <div class="buttons"> 
             <button class="buttons" style="margin-top:30px";> Choose Category</button>
          </div>
       <div class="buttons" style="margin-top:30px";> 
             <button class="buttons">Size</button>
             <button class="buttons">Speed</button>
             <button class="buttons">Range </button>
             <button class="buttons">Firepower</button>
             <button class="buttons">Cargo</button>
          </div>
        <div class="card" style="width: 11rem;"style="margin-top:30px";>
  <div class="card-body">
    <h5 class="card-title">You(User)</h5>
        <p class="card-text">Atrributes</p>
    	         <ul>
    	           <li id="attribute1"></li>
    	           <li id="attribute2"></li>
    	           <li id="attribute3"></li>
    	           <li id="attribute4"></li>
    	           <li id="attribute5"></li>
    	        </ul>
    	   </div>
    	</div>
    	
    <div class="card" style="width: 10rem;">
  <div class="card-body">
    <h5 class="card-title">AI Player 1</h5>
        <p class="card-text">Atrributes</p>
    	         <ul>
    	           <li id="attribute1"></li>
    	           <li id="attribute2"></li>
    	           <li id="attribute3"></li>
    	           <li id="attribute4"></li>
    	           <li id="attribute5"></li>
    	        </ul>
    	   </div>
    	</div>
    <div class="card" style="width: 10rem;">
   <div class="card-body">
      <h5 class="card-title">AI Player 2</h5>
        <p class="card-text">Atrributes</p>
    	         <ul>
    	           <li id="attribute1"></li>
    	           <li id="attribute2"></li>
    	           <li id="attribute3"></li>
    	           <li id="attribute4"></li>
    	           <li id="attribute5"></li>
    	        </ul>
    	   </div>
    	</div>
     <div class="card" style="width: 10rem;">
   <div class="card-body">
      <h5 class="card-title">AI Player 3</h5>
        <p class="card-text">Atrributes</p>
    	         <ul>
    	           <li id="attribute1"></li>
    	           <li id="attribute2"></li>
    	           <li id="attribute3"></li>
    	           <li id="attribute4"></li>
    	           <li id="attribute5"></li>
    	        </ul>
    	   </div>
    	</div>
    <div class="card" style="width: 10rem;">
   <div class="card-body">
      <h5 class="card-title">AI Player 4</h5>
        <p class="card-text">Atrributes</p>
    	         <ul>
    	           <li id="attribute1"></li>
    	           <li id="attribute2"></li>
    	           <li id="attribute3"></li>
    	           <li id="attribute4"></li>
    	           <li id="attribute5"></li>
    	        </ul>
    	   </div>
    	</div>
		</div>
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				
				// For example, lets call our sample methods
			startGame();
			player1Card();
             player2Card();
             player3Card();
             player4Card();
             player5Card();
             getCommunalPile();
             getActivePlayer();
             getRoundNumber();
			}
			
			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------
		
			// This is a reusable method for creating a CORS request. Do not edit this.
			function createCORSRequest(method, url) {
  				var xhr = new XMLHttpRequest();
  				if ("withCredentials" in xhr) {

    				// Check if the XMLHttpRequest object has a "withCredentials" property.
    				// "withCredentials" only exists on XMLHTTPRequest2 objects.
    				xhr.open(method, url, true);

  				} else if (typeof XDomainRequest != "undefined") {

    				// Otherwise, check if XDomainRequest.
    				// XDomainRequest only exists in IE, and is IE's way of making CORS requests.
    				xhr = new XDomainRequest();
    				xhr.open(method, url);

 				 } else {

    				// Otherwise, CORS is not supported by the browser.
    				xhr = null;

  				 }
  				 return xhr;
			}
		
		</script>
		
		<!-- Here are examples of how to call REST API Methods -->
		<script type="text/javascript">
		
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloJSONList() {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloJSONList"); // Request type and URL
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}
			
			// This calls the helloJSONList REST method from TopTrumpsRESTAPI
			function helloWord(word) {
			
				// First create a CORS request, this is the message we are going to send (a get request in this case)
				var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/helloWord?Word="+word); // Request type and URL+parameters
				
				// Message is not sent yet, but we can check that the browser supports CORS
				if (!xhr) {
  					alert("CORS not supported");
				}

				// CORS requests are Asynchronous, i.e. we do not wait for a response, instead we define an action
				// to do when the response arrives 
				xhr.onload = function(e) {
 					var responseText = xhr.response; // the text of the response
					alert(responseText); // lets produce an alert
				};
				
				// We have done everything we need to prepare the CORS request, so send it
				xhr.send();		
			}

		</script>
		
		</body>
</html>
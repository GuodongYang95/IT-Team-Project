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
		<script  type="text/javascript">

			//This method will be called when SelectionScreen html "onload"
			function startGame(){
				var xhr = new XMLHttpRequest();
				xhr.open("get","/toptrumps/gamestart");
				xhr.send(null);
				var jsonStr = 0;
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){
					jsonStr = xhr.responseText;
					//the attribute in userDataObject: Rountcount, userIsOut, activePlayer, ownedCardDescription
					//									userCardPileSize
					userDataObject = JSON.parse(jsonStr);

					//the attribute in userCardObject: Size, Speed, Range, Firepower, Cargo
					userCardObject = JSON.parse(userDataObject.ownedCardCategory);
					//add the function that how content changed in html below
					

					}
				}
				
			}

			//This method will be called when need to select category
			// But there are two cases
			function selectCategory(){
				var xhr = new XMLHttpRequest();
				xhr.open("get","/toptrumps/gamestart/categoryselect");
				xhr.send(null);
				var jsonStr = 0;
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){
					jsonStr = xhr.responseText;
					
					selectedCategoryObject = JSON.parse(jsonStr);
					if(selectedCategoryObject.getSelected == "0"){
						//This means the active player is User
						//Then we should display the button that let User category
						//add function here




					}else if(selectedCategoryObject.getSelected == "1"){
						//This means active Player is not User
						//can use selectedCategoryObject.selectedCategory to get selectedCategory name


						//can other user details
						//userObject stores playerName,playerIsOut,isActive,ownedCardDescription
						userObject = JSON.parse(selectedCategoryObject.player1);
						//userCard stores Size, Speed, Range, Firepower, Cargo
						userCard = JSON.parse(userObject.ownedCardCategory);

						ai1Object = JSON.parse(selectedCategoryObject.player2);
						ai1Card = JSON.parse(ai1Object.ownedCardCategory);

						ai2Object = JSON.parse(selectedCategoryObject.player3);
						ai2Card = JSON.parse(ai2Object.ownedCardCategory);

						ai3Object = JSON.parse(selectedCategoryObject.player4);
						ai3Card = JSON.parse(ai3Object.ownedCardCategory);

						ai4Object = JSON.parse(selectedCategoryObject.player5);
						ai4Card = JSON.parse(ai4Object.ownedCardCategory);

						//add the update function below

						}
					}
				}
				
			}
			//This method will be called when "user" need to select category
			function userSelectedCategory(){
				var xhr = new XMLHttpRequest();
				xhr.open("get","/toptrumps/gamestart/userCategoryselect");
				xhr.send(null);
				var jsonStr = 0;
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){
					jsonStr = xhr.responseText;

					selectedCategoryObject = JSON.parse(jsonStr);
					
					//userObject stores playerName,playerIsOut,isActive,ownedCardDescription,playerCardPileSize
					userObject = JSON.parse(selectedCategoryObject.player1);
					//userCard stores Size, Speed, Range, Firepower, Cargo
					userCard = JSON.parse(userObject.ownedCardCategory);

					ai1Object = JSON.parse(selectedCategoryObject.player2);
					ai1Card = JSON.parse(ai1Object.ownedCardCategory);

					ai2Object = JSON.parse(selectedCategoryObject.player3);
					ai2Card = JSON.parse(ai2Object.ownedCardCategory);

					ai3Object = JSON.parse(selectedCategoryObject.player4);
					ai3Card = JSON.parse(ai3Object.ownedCardCategory);

					ai4Object = JSON.parse(selectedCategoryObject.player5);
					ai4Card = JSON.parse(ai4Object.ownedCardCategory);

					//add the update function

					}
				}
				
			}

			//This method will be called after user click show result button
			function showResult(){
				var xhr = new XMLHttpRequest();
				xhr.open("get","/toptrumps/gamestart/showresult");
				xhr.send(null);
				var jsonStr = 0;
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){
					jsonStr = xhr.responseText;
					//the attribute in resultObject: winPlayer, cardPileNumber ,GameWinner
						//cardPileNumber: this attribute shows the number of common cardPile.
						//winPlayer: if the round is draw, then this should be null. else: player name
						//GameWinner: this attributes is none normally, it will be player name when get game winner
					resultObject = JSON.parse(jsonStr);

					//add the update function

					}
				}
				
			}

			function nextRound(){
				var xhr = new XMLHttpRequest();
				xhr.open("get","/toptrumps/gamestart/newRound");
				xhr.send(null);
				var jsonStr = 0;
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){
					jsonStr = xhr.responseText;
					//the attribute in userDataObject: Rountcount, userIsOut, activePlayer, ownedCardDescription
					//								   userCardPileSize, playerCardPileSize
						userDataObject = JSON.parse(jsonStr);
						userCardObject = JSON.parse(userDataObject.ownedCardCategory);
					//add the update function

					}
				}
				
			}

		</script>

    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
    	
    	<div class="container">

			<!-- Add your HTML Here -->
			<button id = "test" onclick = "startGame()"> testButton </button>

		</div>
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				
				// For example, lets call our sample methods
				helloJSONList();
				helloWord("Student");
				
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
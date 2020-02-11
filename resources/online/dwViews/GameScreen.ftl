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
 		<meta name="viewport" 
        content="width=device-width, initial-scale=1"> 
        <style>
                body {
                display: flex;
                flex-direction: column;
                justify-content: baseline;
                align-items: center;
                color: #666;
                font-size: 1.3em;
                font-family: sans-serif;
                background:url(./images/slide04.jpg)  no-repeat center center;
                background-size:cover;
                background-attachment:fixed;
                }

                .header{ 
                 width:100%;
                 text-align:center;
                 margin-top:20px;
                 }

                 .button {
                 width: 170px;
                 height: 35px;
                 display: block;
                 color: #000;
                 border-radius: 25px; 
                 position: relative;
                 padding: 1em;
                 }


                .nextButton{
                background: #D3D3D3;
                color:#696969;
                position: relative;
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
                position: relative;
                flex: 0 0 240px;
                width: 240px;
                height: 320px;
                background-color:aliceblue;
                overflow: hidden;
                border-radius: 10px;
                display:inline-block;
                margin: 8px;
                margin-top:30px;      
                }  

                .card-info {
                padding: 20px;
                position: fixed;
                bottom: 0;
                color: #666;
                font-size: 1em;
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                transform: translateY(40%);
                transition: 0.6s 1.6s cubic-bezier(0.215, 0.61, 0.355, 1);
                }

                .pic {
                border-radius: 100%;
                position: -webkit-sticky;
                margin: auto;
                z-index: 1;
                max-width: 100px;
                -webkit-transition: all 0.4s;
                        transition: all 0.4s;
                }

                .box {
                position: relative;
                width: 250px;
                height: 450px;
                overflow: hidden;
                border-radius: 10px;
                display:inline-block;
                margin: 10px;
                margin-top:30px;
                }
                #nextRound{
                  display:none;
                }
                #resultButton{
                  display:none;
                }
                #userSelCategory{
                  display:none;
                }
                .playerAI1{
                  display:none;
                }
                .playerAI2{
                  display:none;
                }
                .playerAI3{
                  display:none;
                }
                .playerAI4{
                  display:none;
                }

               </style>

  <script type="text/javascript">
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
                var userDataObject = JSON.parse(jsonStr);

                //the attribute in userCardObject: Size, Speed, Range, Firepower, Cargo
                var CardObject = JSON.parse(userDataObject.ownedCardCategory);
                //add the function that how content changed in html below

                document.getElementById('activePlayer').innerHTML="The active player of this round is " + userDataObject.activePlayer;
                document.getElementById('numCard1').innerHTML="Cards: " +userDataObject.ownedCardDescription;
                //document.getElementById('cardName1').innerHTML = (userObject.cardName);
                document.getElementById('you1').innerHTML ="Size: "+ (CardObject.Size);
                document.getElementById('you2').innerHTML ="Speed: "+ (CardObject.Speed);
                document.getElementById('you3').innerHTML ="Range: "+ (CardObject.Range);
                document.getElementById('you4').innerHTML ="Firepower: "+ (CardObject.Firepower);
                document.getElementById('you5').innerHTML ="Cargo: "+ (CardObject.Cargo);

                //Round Number
                var roundNumber = userDataObject.Rountcount
                document.getElementById('roundNumber').innerHTML="Round Number: " +roundNumber + " Players have Drawn their cards";
                // document.getElementById('announce2').innerHTML="";
                }
              }
            }

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
              document.getElementById('nextSelectCategory').style.display = "none";
              // showButtons();

              document.getElementById('userSelCategory').style.display = "block";

        }else if(selectedCategoryObject.getSelected == "1"){
          //This means active Player is not User
          //can use selectedCategoryObject.selectedCategory to get selectedCategory name
          //can other user details
          //userObject stores playerName,playerIsOut,isActive,ownedCardDescription
          userObject = JSON.parse(selectedCategoryObject.player0);
          //userCard stores Size, Speed, Range, Firepower, Cargo
          userCard = JSON.parse(userObject.ownedCardCategory);

          ai1Object = JSON.parse(selectedCategoryObject.player1);
          ai1Card = JSON.parse(ai1Object.ownedCardCategory);

          ai2Object = JSON.parse(selectedCategoryObject.player2);
          ai2Card = JSON.parse(ai2Object.ownedCardCategory);

          ai3Object = JSON.parse(selectedCategoryObject.player3);
          ai3Card = JSON.parse(ai3Object.ownedCardCategory);

          ai4Object = JSON.parse(selectedCategoryObject.player4);
          ai4Card = JSON.parse(ai4Object.ownedCardCategory);

          //add the update function below
          playerSelectedCategory(selectedCategoryObject,userObject,userCard,ai1Object,ai1Card,ai2Object,ai2Card,
                                            ai3Object,ai3Card,ai4Object,ai4Card)
            }
          }

          
          }
    
    }

    function userSelectedCategory(object){

      selection = getSelectedCategory(object);

      var xhr = new XMLHttpRequest();
      //use "/gamestart/userCategoryselect?gategory=speed
      xhr.open("get","/toptrumps/gamestart/userCategoryselect?gategory="+selection);
      xhr.send(null);
      var jsonStr = 0;
      xhr.onreadystatechange = function(){
        if(xhr.readyState==4){
        jsonStr = xhr.responseText;

        selectedCategoryObject = JSON.parse(jsonStr);
        
        //userObject stores playerName,playerIsOut,isActive,ownedCardDescription,playerCardPileSize
        userObject = JSON.parse(selectedCategoryObject.player0);
        //userCard stores Size, Speed, Range, Firepower, Cargo
        userCard = JSON.parse(userObject.ownedCardCategory);

        ai1Object = JSON.parse(selectedCategoryObject.player1);
        ai1Card = JSON.parse(ai1Object.ownedCardCategory);

        ai2Object = JSON.parse(selectedCategoryObject.player2);
        ai2Card = JSON.parse(ai2Object.ownedCardCategory);

        ai3Object = JSON.parse(selectedCategoryObject.player3);
        ai3Card = JSON.parse(ai3Object.ownedCardCategory);

        ai4Object = JSON.parse(selectedCategoryObject.player4);
        ai4Card = JSON.parse(ai4Object.ownedCardCategory);

        //add the update function
        playerSelectedCategory(selectedCategoryObject,userObject,userCard,ai1Object,ai1Card,ai2Object,ai2Card,
                                            ai3Object,ai3Card,ai4Object,ai4Card)

        // document.getElementById('announce').innerHTML="You have chosen " +(selectedCategoryObject.selectCategory);
        }
      }
  }


  function playerSelectedCategory(selectedCategoryObject,userObject,userCard,ai1Object,ai1Card,ai2Object,ai2Card,
                                            ai3Object,ai3Card,ai4Object,ai4Card){
            //hideButtons();
          document.getElementById('userSelCategory').style.display = "none";
          document.getElementById('nextSelectCategory').style.display = "none";
          document.getElementById('resultButton').style.display = "block";
          // 	document.getElementById('activePlayer').innerHTML="The active player is " + ".";
          //  document.getElementById('showButton').style.visibility = "visible";
          document.getElementById('announce').innerHTML="The chosen gategory is " + selectedCategoryObject.selectedCategory;

        document.getElementById('numCard1').innerHTML="Cards: " +userObject.ownedCardDescription;
                  //document.getElementById('cardName1').innerHTML = (userObject.cardName);
                  document.getElementById('you1').innerHTML ="Size: "+ (userCard.Size);
                  document.getElementById('you2').innerHTML ="Speed: "+ (userCard.Speed);
                  document.getElementById('you3').innerHTML ="Range: "+ (userCard.Range);
                  document.getElementById('you4').innerHTML ="Firepower: "+ (userCard.Firepower);
                  document.getElementById('you5').innerHTML ="Cargo: "+ (userCard.Cargo);
        if(ai1Object.playerIsOut == "false"){
        document.getElementsByClassName('playerAI1')[0].style.display = "inline-block";
        document.getElementById('numCard2').innerHTML="Cards: " +(ai1Object.ownedCardDescription);
                  //document.getElementById('cardName2').innerHTML = (ai1Object.cardName);
                  document.getElementById('ai1_1').innerHTML ="Size: "+ (ai1Card.Size);
                  document.getElementById('ai1_2').innerHTML ="Speed: "+ (ai1Card.Speed);
                  document.getElementById('ai1_3').innerHTML ="Range: "+ (ai1Card.Range);
                  document.getElementById('ai1_4').innerHTML ="Firepower: "+ (ai1Card.Firepower);
                  document.getElementById('ai1_5').innerHTML ="Cargo: "+ (ai1Card.Cargo);
        }
        if(ai2Object.playerIsOut == "false"){
        document.getElementsByClassName('playerAI2')[0].style.display = "inline-block";
        document.getElementById('numCard3').innerHTML="Cards: " +(ai2Object.ownedCardDescription);
                  //document.getElementById('cardName3').innerHTML = (ai2Object.cardName);
                  document.getElementById('ai2_1').innerHTML ="Size: "+ (ai2Card.Size);
                  document.getElementById('ai2_2').innerHTML ="Speed: "+ (ai2Card.Speed);
                  document.getElementById('ai2_3').innerHTML ="Range: "+ (ai2Card.Range);
                  document.getElementById('ai2_4').innerHTML ="Firepower: "+ (ai2Card.Firepower);
                  document.getElementById('ai2_5').innerHTML ="Cargo: "+ (ai2Card.Cargo);
        }

        if(ai3Object.playerIsOut == "false"){
          document.getElementsByClassName('playerAI3')[0].style.display = "inline-block";
        document.getElementById('numCard4').innerHTML="Cards: " +(ai3Object.ownedCardDescription);
                  //document.getElementById('cardName4').innerHTML = (ai3Object.cardName);
                  document.getElementById('ai3_1').innerHTML ="Size: "+ (ai3Card.Size);
                  document.getElementById('ai3_2').innerHTML ="Speed: "+ (ai3Card.Speed);
                  document.getElementById('ai3_3').innerHTML ="Range: "+ (ai3Card.Range);
                  document.getElementById('ai3_4').innerHTML ="Firepower: "+ (ai3Card.Firepower);
                  document.getElementById('ai3_5').innerHTML ="Cargo: "+ (ai3Card.Cargo);
        }
        if(ai4Object.playerIsOut == "false"){
          document.getElementsByClassName('playerAI4')[0].style.display = "inline-block";
        document.getElementById('numCard5').innerHTML="Cards: " +(ai4Object.ownedCardDescription);
                  //document.getElementById('cardName5').innerHTML = (ai4Object.cardName);
                  document.getElementById('ai4_1').innerHTML ="Size: "+ (ai4Card.Size);
                  document.getElementById('ai4_2').innerHTML ="Speed: "+ (ai4Card.Speed);
                  document.getElementById('ai4_3').innerHTML ="Range: "+ (ai4Card.Range);
                  document.getElementById('ai4_4').innerHTML ="Firepower: "+ (ai4Card.Firepower);
                  document.getElementById('ai4_5').innerHTML ="Cargo: "+ (ai4Card.Cargo);
        }
          
              }
      function getSelectedCategory(object){
        var selectCategoryDes = object.innerHTML;
        return selectCategoryDes;
      }

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
              // hiede and display button first
                // document.getElementById('nextRound').style.display = "block";
                document.getElementById('resultButton').style.display = "none";

            if(resultObject.GameWinner == "none"){
              //this means then round will continue
              document.getElementById('nextRound').style.display = "block";
              if(resultObject.winPlayer == "none"){
                //this means this round is draw
                document.getElementById('announce2').innerHTML=
                "the result of this round is a draw. The common pile has " + resultObject.cardPileNumber + " cards" ;
              }else{
                //means this round has winner
                document.getElementById('nextRound').style.display = "block";
                document.getElementById('announce2').innerHTML=
                "the winner of this round is "+resultObject.winPlayer;
                }
              }else{
                //one of player win this Game

                    }
    
            
              }	
            }
          }

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

      function nextRound(){
        var xhr = new XMLHttpRequest();
				xhr.open("get","/toptrumps/gamestart/newround");
				xhr.send(null);
				var jsonStr = 0;
				xhr.onreadystatechange = function(){
					if(xhr.readyState==4){
					jsonStr = xhr.responseText;
					//the attribute in userDataObject: Rountcount, userIsOut, activePlayer, ownedCardDescription
					//								   userCardPileSize, playerCardPileSize
						userDataObject = JSON.parse(jsonStr);
						CardObject = JSON.parse(userDataObject.ownedCardCategory);
					//add the update function
                document.getElementById('nextRound').style.display = "none";
                document.getElementById('nextSelectCategory').style.display = "block";

                document.getElementById('activePlayer').innerHTML="The active player of this round is " + userDataObject.activePlayer;
                document.getElementById('numCard1').innerHTML="Cards: " +userDataObject.ownedCardDescription;
                //document.getElementById('cardName1').innerHTML = (userObject.cardName);
                document.getElementById('you1').innerHTML ="Size: "+ (CardObject.Size);
                document.getElementById('you2').innerHTML ="Speed: "+ (CardObject.Speed);
                document.getElementById('you3').innerHTML ="Range: "+ (CardObject.Range);
                document.getElementById('you4').innerHTML ="Firepower: "+ (CardObject.Firepower);
                document.getElementById('you5').innerHTML ="Cargo: "+ (CardObject.Cargo);

                //Round Number
                var roundNumber = userDataObject.Rountcount
                document.getElementById('roundNumber').innerHTML="Round Number: " +roundNumber + " Players have Drawn their cards";

                resetContent();

          }
        }
      }

      function resetContent(){
        document.getElementById('announce').innerHTML='';
        document.getElementById('announce2').innerHTML='';
        document.getElementsByClassName('playerAI1')[0].style.display = "none";
        document.getElementsByClassName('playerAI2')[0].style.display = "none";
        document.getElementsByClassName('playerAI3')[0].style.display = "none";
        document.getElementsByClassName('playerAI4')[0].style.display = "none";
      }



 </script>
</head>

    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
    	
    	<div class="container">
                    <div class="header"> 
                    <div> 
                    <h1 style="text-align:center";> Top Trumps Game</h1>
                    <h4 style="text-align:center"; id = "activePlayer"> The Game Start Now! The active player is You</h4>
                    <h4 id="roundNumber"> </h4>
                    <h4 id="announce"> </h4>
                    <h4 id = "announce2"></h4>
                  <div class="box">
                    <div class="button" id="nextSelectCategory" > 
                    <button class="button" style="margin-top:30px" id="nextButton" onclick = "selectCategory()" class="btn btn-primary btn-lg">Next: Select Category</button>
                    </div>
                      <div class="button" id = "userSelCategory";> 
                         <button class="button" style="margin-top:30px";> Choose Category</button>
                      
                          <div class="button" style="margin-top:30px" ;> 
                            <button class="button" style="margin-top:10px" onclick = "userSelectedCategory(this)">Size</button>
                            <button class="button" style="margin-top:10px" onclick = "userSelectedCategory(this)";>Speed</button>
                            <button class="button" style="margin-top:10px" onclick = "userSelectedCategory(this)";>Range </button>
                            <button class="button" style="margin-top:10px" onclick = "userSelectedCategory(this)";>Firepower</button>
                            <button class="button" style="margin-top:10px" onclick = "userSelectedCategory(this)";>Cargo</button>
                          </div>
                      </div>
                      <div>
                        <button class="button" id = "resultButton" onclick = "showResult()"> Show Winner</button>
                      </div>
                      <div>
                        <button class="button" id = "nextRound" onclick = "nextRound()"> Next Round</button>
                      </div>
                  </div>
                     
                    <div class="card playerYou" style="width: 11rem;"style="margin-top:30px";>
                    <h4 class="card-info">You(User)</h4>
                    <p class="card-text" id = "numCard1">Atrributes</p>
                             <ul>
                               <li id="you1"></li>
                               <li id="you2"></li>
                               <li id="you3"></li>
                               <li id="you4"></li>
                               <li id="you5"></li>
                            </ul>
                            <img class="pic" src="./images/orange.png">
                       </div>
                  
                <div class="card playerAI1" style="width: 10rem;">
              <div class="card-body " >
                <h4 class="card-info" >AI Player 1</h4>
                    <p class="card-text" id = "numCard2">Atrributes</p>
                             <ul>
                               <li id="ai1_1"></li>
                               <li id="ai1_2"></li>
                               <li id="ai1_3"></li>
                               <li id="ai1_4"></li>
                               <li id="ai1_5"></li>
                            </ul>
                            <img class="pic" src="./images/cyan.png">
                       </div>
                    </div>
                <div class="card playerAI2" style="width: 10rem;">
               <div class="card-body ">
                  <h4 class="card-info" >AI Player 2</h4>
                    <p class="card-text" id = "numCard3">Atrributes</p>
                             <ul>
                               <li id="ai2_1"></li>
                               <li id="ai2_2"></li>
                               <li id="ai2_3"></li>
                               <li id="ai2_4"></li>
                               <li id="ai2_5"></li>
                            </ul>
                            <img class="pic" src="./images/smokygray.png">
                       </div>
                    </div>
                 <div class="card playerAI3" style="width: 10rem;">
               <div class="card-body ">
                  <h4 class="card-info" >AI Player 3</h4>
                    <p class="card-text" id = "numCard4">Atrributes</p>
                             <ul>
                               <li id="ai3_1"></li>
                               <li id="ai3_2"></li>
                               <li id="ai3_3"></li>
                               <li id="ai3_4"></li>
                               <li id="ai3_5"></li>
                            </ul>
                            <img class="pic" src="./images/yellow.png">
                       </div>
                    </div>
                <div class="card playerAI4" style="width: 10rem;">
               <div class="card-body">
                  <h4 class="card-info" >AI Player 4</h4>
                    <p class="card-text" id = "numCard5">Atrributes</p>
                             <ul>
                               <li id="ai4_1"></li>
                               <li id="ai4_2"></li>
                               <li id="ai4_3"></li>
                               <li id="ai4_4"></li>
                               <li id="ai4_5"></li>
                            </ul>
                            <img class="pic" src="./images/yellow2.png">
		
		</div>
		
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				startGame();
				// For example, lets call our sample methods

				
			}
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
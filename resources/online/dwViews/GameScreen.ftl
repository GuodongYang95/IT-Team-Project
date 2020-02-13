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
               *{
                  margin: 0 ;
                  padding: 0 ;
                  list-style: none;
                  
                }
                body {
                display: flex;
                flex-direction: column;
                justify-content: baseline;
                align-items: center;
                color: #666;
                font-size: 1.3em;
                font-family: sans-serif;
                background:url(/assets/slide04.jpg)  no-repeat center center;
                background-size:cover;
                background-attachment:fixed;
                }

                .header{ 
                 width:100%;
                 text-align:center;
                 margin-top:20px;
                 }

                 .button {
                 
                 height: 35px;
                 display: block;
                 color: #000;
                 border-radius: 25px; 
                 position: relative;
                 padding:5px;
                 line-height:35px;
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
                <#--  .card-body{
                  position:relative;
                }  -->
                .card-info {
                padding: 20px;
                position: fixed;
                bottom: 10px;
                
                color: #666;
                font-size: 1em;
                font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
                transform: translateY(40%);
                transition: 0.6s 1.6s cubic-bezier(0.215, 0.61, 0.355, 1);
                }

                .card-text{
                  font-size:1em;
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
                display:flex;
                position: relative;
                float:left;
                height: 300px;
                overflow: hidden;
                border-radius: 10px;
                margin-top:30px;
                justify-content: center;
                }
                .cardBox{
                  position:relative;
                  float:left;

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
                document.getElementById('numCard1').innerHTML= userDataObject.ownedCardDescription;
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

        document.getElementById('numCard1').innerHTML= userObject.ownedCardDescription;
                  //document.getElementById('cardName1').innerHTML = (userObject.cardName);
                  document.getElementById('you1').innerHTML ="Size: "+ (userCard.Size);
                  document.getElementById('you2').innerHTML ="Speed: "+ (userCard.Speed);
                  document.getElementById('you3').innerHTML ="Range: "+ (userCard.Range);
                  document.getElementById('you4').innerHTML ="Firepower: "+ (userCard.Firepower);
                  document.getElementById('you5').innerHTML ="Cargo: "+ (userCard.Cargo);
        if(ai1Object.playerIsOut == "false"){
        document.getElementsByClassName('playerAI1')[0].style.display = "inline-block";
        document.getElementById('numCard2').innerHTML= (ai1Object.ownedCardDescription);
                  //document.getElementById('cardName2').innerHTML = (ai1Object.cardName);
                  document.getElementById('ai1_1').innerHTML ="Size: "+ (ai1Card.Size);
                  document.getElementById('ai1_2').innerHTML ="Speed: "+ (ai1Card.Speed);
                  document.getElementById('ai1_3').innerHTML ="Range: "+ (ai1Card.Range);
                  document.getElementById('ai1_4').innerHTML ="Firepower: "+ (ai1Card.Firepower);
                  document.getElementById('ai1_5').innerHTML ="Cargo: "+ (ai1Card.Cargo);
        }
        if(ai2Object.playerIsOut == "false"){
        document.getElementsByClassName('playerAI2')[0].style.display = "inline-block";
        document.getElementById('numCard3').innerHTML= (ai2Object.ownedCardDescription);
                  //document.getElementById('cardName3').innerHTML = (ai2Object.cardName);
                  document.getElementById('ai2_1').innerHTML ="Size: "+ (ai2Card.Size);
                  document.getElementById('ai2_2').innerHTML ="Speed: "+ (ai2Card.Speed);
                  document.getElementById('ai2_3').innerHTML ="Range: "+ (ai2Card.Range);
                  document.getElementById('ai2_4').innerHTML ="Firepower: "+ (ai2Card.Firepower);
                  document.getElementById('ai2_5').innerHTML ="Cargo: "+ (ai2Card.Cargo);
        }

        if(ai3Object.playerIsOut == "false"){
          document.getElementsByClassName('playerAI3')[0].style.display = "inline-block";
        document.getElementById('numCard4').innerHTML= (ai3Object.ownedCardDescription);
                  //document.getElementById('cardName4').innerHTML = (ai3Object.cardName);
                  document.getElementById('ai3_1').innerHTML ="Size: "+ (ai3Card.Size);
                  document.getElementById('ai3_2').innerHTML ="Speed: "+ (ai3Card.Speed);
                  document.getElementById('ai3_3').innerHTML ="Range: "+ (ai3Card.Range);
                  document.getElementById('ai3_4').innerHTML ="Firepower: "+ (ai3Card.Firepower);
                  document.getElementById('ai3_5').innerHTML ="Cargo: "+ (ai3Card.Cargo);
        }
        if(ai4Object.playerIsOut == "false"){
          document.getElementsByClassName('playerAI4')[0].style.display = "inline-block";
        document.getElementById('numCard5').innerHTML= (ai4Object.ownedCardDescription);
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
                document.getElementById('numCard1').innerHTML= userDataObject.ownedCardDescription;
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

    <body onload="startGame()">  <!-- Call the initalize method when the page loads -->
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
                    <div class="header"> 
                    <div> 
                    <h1 style="text-align:center";> Top Trumps Game</h1>
                    <h4 style="text-align:center"; id = "activePlayer"> The Game Start Now! The active player is You</h4>
                    <h4 id="roundNumber"> </h4>
                    <h4 id="announce"> </h4>
                    <h4 id = "announce2"></h4>
                  <div class="box">
                    <div class="button" id="nextSelectCategory" > 
                    <button class="button"  id="nextButton" onclick = "selectCategory()" class="btn btn-primary btn-lg">Next: Select Category</button>
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
                     <div class = "cardBox">
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
                            <img class="pic" src="assets/orange.png">
                       </div>
                  
                <div class="card playerAI1" style="width: 10rem;">
              
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

<<<<<<< HEAD
			<!-- Add your HTML Here -->
		<div class="header"> 
        <div> 
		<h3 class="header" style="text-align:center";> Top Trumps </h3>
		<h3 id="activePlayer"></h3>
		<p id="communalPile"></p>
		<p id="roundNumber"></p>
		<div class="card-body text-center">
			<h5 id="announce"></h5><br/>
			<p id="announce2"></p>
		</div>        
	</div> 
		<#--  <div>
		 <button type="showbutton" style="margin-top:30px" id="showButton" onclick="showresult();" class="btn btn-primary btn-lg;">SHOW WINNER</button>
		 </div>  -->
        <button type="button" style="margin-top:30px" id="nextButton" onclick="updateGame();" class="btn btn-primary btn-lg;">Next</button>
        <#--  <div class="buttons"> 
             <button class="buttons" style="margin-top:20px";> Choose Category</button>
          </div>  -->
       <div class="categoryButtons" id= "categoryButtons" style="margin-top:15px";> 
             <button class="sizeButton" onclick="response(0); userCategory();">Size</button>
             <button class="speedButton" onclick="response(1); userCategory();">Speed</button>
             <button class="rangeButton" onclick="response(2); userCategory();">Range </button>
             <button class="fireButton" onclick="response(3); userCategory();">Firepower</button>
             <button class="cargoButtons" onclick="response(4); userCategory();">Cargo</button>
          </div>
         
        <div class="card" style="width: 11rem;"style="margin-top:30px";>
		<h5 class="card-title">You(User)</h5>
		<p id="numCard1"></p>
	<div class="card-name text-center">
		<h5 id="cardName1"></h5>
		</div>
		<div class="card-body">
		
			<p class="card-attributes">
    	         <ul>
    	           <li id="attributeA1"></li>
    	           <li id="attributeA2"></li>
    	           <li id="attributeA3"></li>
    	           <li id="attributeA4"></li>
    	           <li id="attributeA5"></li>
				</ul>
		</p>
    	   </div>
    	</div>
    	
		<div class="card" style="width: 11rem;"style="margin-top:30px";>
			<h5 class="card-title">AI Player 1</h5>
			<p id="numCard2"></p>
		<div class="card-name text-center">
			<h5 id="cardName2"></h5>
			</div>
			<div class="card-body">
			
				<p class="card-attributes">
					 <ul>
					   <li id="attributeB1"></li>
					   <li id="attributeB2"></li>
					   <li id="attributeB3"></li>
					   <li id="attributeB4"></li>
					   <li id="attributeB5"></li>
					</ul>
			</p>
			   </div>
			</div>
	
		<div class="card" style="width: 11rem;"style="margin-top:30px";>
			<h5 class="card-title">AI Player 2</h5>
			<p id="numCard3"></p>
		<div class="card-name text-center">
			<h5 id="cardName3"></h5>
			</div>
			<div class="card-body">
				
				<p class="card-attributes">
					 <ul>
					   <li id="attributeC1"></li>
					   <li id="attributeC2"></li>
					   <li id="attributeC3"></li>
					   <li id="attributeC4"></li>
					   <li id="attributeC5"></li>
					</ul>
				</p>
		   </div>
		</div>
	
		<div class="card" style="width: 11rem;"style="margin-top:30px";>
			<h5 class="card-title">AI Player 3</h5>
			<p id="numCard4"></p>
		<div class="card-name text-center">
			<h5 id="cardName4"></h5>
			</div>
			<div class="card-body">
			
				<p class="card-attributes">
					 <ul>
					   <li id="attributeD1"></li>
					   <li id="attributeD2"></li>
					   <li id="attributeD3"></li>
					   <li id="attributeD4"></li>
					   <li id="attributeD5"></li>
					</ul>
			</p>
		</div>
		</div>

		<div class="card" style="width: 11rem;"style="margin-top:30px";>
			<h5 class="card-title">AI Player 4</h5>
			<p id="numCard5"></p>
		<div class="card-name text-center">
			<h5 id="cardName5"></h5>
			</div>
			<div class="card-body">
			
				<p class="card-attributes">
					 <ul>
					   <li id="attributeE1"></li>
					   <li id="attributeE2"></li>
					   <li id="attributeE3"></li>
					   <li id="attributeE4"></li>
					   <li id="attributeE5"></li>
					</ul>
			</p>
			   </div>
			</div>

=======
                <div class="card playerAI2" style="width: 10rem;">
     
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
                 <div class="card playerAI3" style="width: 10rem;">

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
                <div class="card playerAI4" style="width: 10rem;">
          
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
                </div>
>>>>>>> origin/Ken
		<script type="text/javascript">
		
			// Method that is called on page load
			function initalize() {
			
				// --------------------------------------------------------------------------
				// You can call other methods you want to run when the page first loads here
				// --------------------------------------------------------------------------
				startGame();
				// For example, lets call our sample methods
<<<<<<< HEAD
			startGame();
			
			}
			
			// -----------------------------------------
			// Add your other Javascript methods Here
			// -----------------------------------------
		
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

					document.getElementById('activeplayer').innerHTML="The active player is " + userDataObject.activePlayer;
					document.getElementById('numCard1').innerHTML="Cards: " +userDataObject.ownedCardCategory;
                    //document.getElementById('cardName1').innerHTML = (userObject.cardName);
                    document.getElementById('attributeA1').innerHTML ="Size: "+ (userCard.size);
                    document.getElementById('attributeA2').innerHTML ="Speed: "+ (userCard.speed);
                    document.getElementById('attributeA3').innerHTML ="Range: "+ (userCard.range);
                    document.getElementById('attributeA4').innerHTML ="Firepower: "+ (userCard.firepower);
                    document.getElementById('attributeA5').innerHTML ="Cargo: "+ (userCard.cargo);

					//Round Number
					var roundNumber = userDataObject.Rountcount
                    document.getElementById('roundNumber').innerHTML="Round Number: " +roundNumber + "Players have Drawn their cards";
                    document.getElementById('announce2').innerHTML="";
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
					document.getElementById('nextButton').style.visibility = "hidden";
                    showButtons();
                    document.getElementById('activePlayer').innerHTML="The active player is you.";
                    

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
						hideButtons();
                    	document.getElementById('nextButton').style.visibility = "hidden";
                   // 	document.getElementById('activePlayer').innerHTML="The active player is " + ".";
				   		document.getElementById('showButton').style.visibility = "visible";
                   		document.getElementById('announce').innerHTML="The AI player has chosen " + selectedCategoryObject.selectCategory;
					document.getElementById('numCard1').innerHTML="Cards: " +userDataObject.ownedCardCategory;
                    //document.getElementById('cardName1').innerHTML = (userObject.cardName);
                    document.getElementById('attributeA1').innerHTML ="Size: "+ (userCard.size);
                    document.getElementById('attributeA2').innerHTML ="Speed: "+ (userCard.speed);
                    document.getElementById('attributeA3').innerHTML ="Range: "+ (userCard.range);
                    document.getElementById('attributeA4').innerHTML ="Firepower: "+ (userCard.firepower);
                    document.getElementById('attributeA5').innerHTML ="Cargo: "+ (userCard.cargo);

					document.getElementById('numCard2').innerHTML="Cards: " +(ai1Object.ownedCardCategory);
                    document.getElementById('cardName2').innerHTML = (ai1Object.cardName);
                    document.getElementById('attributeB1').innerHTML ="Size: "+ (ai1Card.size);
                    document.getElementById('attributeB2').innerHTML ="Speed: "+ (ai1Card.speed);
                    document.getElementById('attributeB3').innerHTML ="Range: "+ (ai1Card.range);
                    document.getElementById('attributeB4').innerHTML ="Firepower: "+ (ai1Card.firepower);
                    document.getElementById('attributeB5').innerHTML ="Cargo: "+ (ai1Card.cargo);

					document.getElementById('numCard3').innerHTML="Cards: " +(ai2Object.ownedCardCategory);
                    document.getElementById('cardName3').innerHTML = (ai2Object.cardName);
                    document.getElementById('attributeC1').innerHTML ="Size: "+ (ai2Card.size);
                    document.getElementById('attributeC2').innerHTML ="Speed: "+ (ai2Card.speed);
                    document.getElementById('attributeC3').innerHTML ="Range: "+ (ai2Card.range);
                    document.getElementById('attributeC4').innerHTML ="Firepower: "+ (ai2Card.firepower);
                    document.getElementById('attributeC5').innerHTML ="Cargo: "+ (ai2Card.cargo);

					document.getElementById('numCard4').innerHTML="Cards: " +(ai3Object.ownedCardCategory);
                    document.getElementById('cardName4').innerHTML = (ai3Object.cardName);
                    document.getElementById('attributeD1').innerHTML ="Size: "+ (ai3Card.size);
                    document.getElementById('attributeD2').innerHTML ="Speed: "+ (ai3Card.speed);
                    document.getElementById('attributeD3').innerHTML ="Range: "+ (ai3Card.range);
                    document.getElementById('attributeD4').innerHTML ="Firepower: "+ (ai3Card.firepower);
                    document.getElementById('attributeD5').innerHTML ="Cargo: "+ (ai3Card.cargo);

					document.getElementById('numCard5').innerHTML="Cards: " +(ai4Object.ownedCardCategory);
                    document.getElementById('cardName5').innerHTML = (ai4Object.cardName);
                    document.getElementById('attributeE1').innerHTML ="Size: "+ (ai4Card.size);
                    document.getElementById('attributeE2').innerHTML ="Speed: "+ (ai4Card.speed);
                    document.getElementById('attributeE3').innerHTML ="Range: "+ (ai4Card.range);
                    document.getElementById('attributeE4').innerHTML ="Firepower: "+ (ai4Card.firepower);
                    document.getElementById('attributeE5').innerHTML ="Cargo: "+ (ai4Card.cargo);
					
						}
					}
				}
				
			}
			//This method will be called when "user" need to select category
			function userSelectedCategory( selection){
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
					hideButtons();
			   		document.getElementById('nextButton').style.visibility = "visible";
					var chosenCard = selectedCategoryObject.selectCategory;
					if (chosenCard == null) {
				   document.getElementById('announce').innerHTML="";
				   }
				   else {
				   document.getElementById('announce').innerHTML="You have chosen " +(selectedCategoryObject.selectCategory);
				   }
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
					var GameOver = resultObject.gameFinished;
					
					var responseText= JSON.parse(xhr.response)

					var playercard=responseText.player.playerCardPileSize;
					var player2card=responseText.player.playerCardPileSize;				
					var player3card=responseText.player.playerCardPileSize;					
					var player4card=responseText.player.playerCardPileSize;					
					var player5card=responseText.player.playerCardPileSize;					
					//add the update function
					
					if ((GameOver == true) && (playerCard == 0)) {
			   
					hideButtons();
					document.getElementById('nextButton').style.visibility = "hidden";
					alert("The game is over and the winner is " +resultObject.GameWinner+ "And the 
					". Thanks for playing!");
					}
					else if ((GameOver = true) && (player2Card == 0) && (player3Card == 0) && (player4Card == 0) && (player5Card == 0)){
					hideButtons();
					document.getElementById('nextButton').style.visibility = "hidden";
					alert("Congratulations, the User won!");
					}	
					}
				}
				
			}

			function update(){
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
					//getcommunalpile
					resultObject = JSON.parse(jsonStr);
					var communalPile = resultObject.cardPileNumber
                    document.getElementById('communalPile').innerHTML="Cards in Communal Pile: " +(communalPile);

					resultObject = JSON.parse(jsonStr);
					 var responseText = JSON.parse(xhr.response); // the text of the response
					 var roundOver = responseText.roundHasBeenResolved;
					 var roundWinnerIndex = responseText.roundWinnerIndex;
					 if ((roundWinnerIndex == -1) && (roundOver== true)) {
					 
					 document.getElementById('announce2').innerHTML="This round is over and the result is a draw.";
					 
					 } else if ((roundWinnerIndex > 0)  && (roundOver== true)){
					 
					 document.getElementById('announce2').innerHTML="This round is over and the winner is " + resultObject.winPlayer;
					 
					 } else if ((resultObject.winPlayer == "User(You)")  && (roundOver== true)) {
					 document.getElementById('announce2').innerHTML="This round is over and you won the round.";
					 }
					 else {
					 document.getElementById('announce2').innerHTML=" ";
					 }
					  gameOver();  
					}
				}
				 player1Card();
			  player2Card();
			  player3Card();
			  player4Card();
			  player5Card();
			  getCommunalPile();
			  getActivePlayer();
			  getRoundNumber();
			}

			function hideButtons() {
                
                document.getElementById('categoryButtons').style.visibility = "hidden";
            }
			
			
			function showButtons() {
                
                document.getElementById('categoryButtons').style.visibility = "visible";
            }

			<#--  function getCommunalPile() {
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getCommunalPile"); // Request type and URL
                if (!xhr) {
                    alert("CORS not supported");
                }
                xhr.onload = function(e) {
                    var resultObject = JSON.parse(xhr.response); // the text of the response
					var communalPile = resultObject.cardPileNumber
                    document.getElementById('communalPile').innerHTML="Cards in Communal Pile: " +(communalPile);
                    
                };
                xhr.send();
			}
			
			function getRoundNumber() {
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/getRoundNumber"); // Request type and URL
                if (!xhr) {
                    alert("CORS not supported");
                }
                xhr.onload = function(e) {
                    var userDataObject = JSON.parse(xhr.response); // the text of the response
					var roundNumber = userDataObject.Rountcount
                    document.getElementById('roundNumber').innerHTML="Round Number: " +(roundNumber);
                    
                };
                xhr.send();
                
			}	  -->


=======

				
			}
>>>>>>> origin/Ken
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
		
		<#--  function player1Card() {
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/response?update=false"); // Request type and URL
                if (!xhr) {
                    alert("CORS not supported");
                }
                xhr.onload = function(e) {
                    var responseText = JSON.parse(xhr.response); // the text of the response
                    document.getElementById('numCard1').innerHTML="Cards: " +(userCard.ownedCardCategory);
                    document.getElementById('cardName1').innerHTML = (userCard.cardName);
                    document.getElementById('attributeA1').innerHTML ="Size: "+ (userCard.size);
                    document.getElementById('attributeA2').innerHTML ="Speed: "+ (userCard.speed);
                    document.getElementById('attributeA3').innerHTML ="Range: "+ (userCard.range);
                    document.getElementById('attributeA4').innerHTML ="Firepower: "+ (userCard.firepower);
                    document.getElementById('attributeA5').innerHTML ="Cargo: "+ (userCard.cargo);
                };
                xhr.send();
            }
		function player2Card() {
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/response?update=false"); // Request type and URL
                if (!xhr) {
                    alert("CORS not supported");
                }
                xhr.onload = function(e) {
                    var responseText = JSON.parse(xhr.response); // the text of the response
                    document.getElementById('numCard1').innerHTML="Cards: " +(responseText.player2.ownedCardCategory);
                    document.getElementById('cardName1').innerHTML = (responseText.player2.cardName);
                    document.getElementById('attributeA1').innerHTML ="Size: "+ (responseText.player2.size);
                    document.getElementById('attributeA2').innerHTML ="Speed: "+ (responseText.player2.speed);
                    document.getElementById('attributeA3').innerHTML ="Range: "+ (responseText.player2.range);
                    document.getElementById('attributeA4').innerHTML ="Firepower: "+ (responseText.player2.firepower);
                    document.getElementById('attributeA5').innerHTML ="Cargo: "+ (responseText.player2.cargo);
                };
                xhr.send();
            }
			function player3Card() {
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/response?update=false"); // Request type and URL
                if (!xhr) {
                    alert("CORS not supported");
                }
                xhr.onload = function(e) {
                    var responseText = JSON.parse(xhr.response); // the text of the response
                    document.getElementById('numCard1').innerHTML="Cards: " +(responseText.player3.ownedCardCategory);
                    document.getElementById('cardName1').innerHTML = (responseText.player3.cardName);
                    document.getElementById('attributeA1').innerHTML ="Size: "+ (responseText.player3.size);
                    document.getElementById('attributeA2').innerHTML ="Speed: "+ (responseText.player3.speed);
                    document.getElementById('attributeA3').innerHTML ="Range: "+ (responseText.player3.range);
                    document.getElementById('attributeA4').innerHTML ="Firepower: "+ (responseText.player3.firepower);
                    document.getElementById('attributeA5').innerHTML ="Cargo: "+ (responseText.player3.cargo);
                };
                xhr.send();
            }
			function player4Card() {
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/response?update=false"); // Request type and URL
                if (!xhr) {
                    alert("CORS not supported");
                }
                xhr.onload = function(e) {
                    var responseText = JSON.parse(xhr.response); // the text of the response
                    document.getElementById('numCard1').innerHTML="Cards: " +(responseText.player4.ownedCardCategory);
                    document.getElementById('cardName1').innerHTML = (responseText.player4.cardName);
                    document.getElementById('attributeA1').innerHTML ="Size: "+ (responseText.player4.size);
                    document.getElementById('attributeA2').innerHTML ="Speed: "+ (responseText.player4.speed);
                    document.getElementById('attributeA3').innerHTML ="Range: "+ (responseText.player4.range);
                    document.getElementById('attributeA4').innerHTML ="Firepower: "+ (responseText.player4.firepower);
                    document.getElementById('attributeA5').innerHTML ="Cargo: "+ (responseText.player4.cargo);
                };
                xhr.send();
            }
				function player5Card() {
                var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/response?update=false"); // Request type and URL
                if (!xhr) {
                    alert("CORS not supported");
                }
                xhr.onload = function(e) {
                    var responseText = JSON.parse(xhr.response); // the text of the response
                    document.getElementById('numCard1').innerHTML="Cards: " +(responseText.player5.ownedCardCategory);
                    document.getElementById('cardName1').innerHTML = (responseText.player5.cardName);
                    document.getElementById('attributeA1').innerHTML ="Size: "+ (responseText.player5.size);
                    document.getElementById('attributeA2').innerHTML ="Speed: "+ (responseText.player5.speed);
                    document.getElementById('attributeA3').innerHTML ="Range: "+ (responseText.player5.range);
                    document.getElementById('attributeA4').innerHTML ="Firepower: "+ (responseText.player5.firepower);
                    document.getElementById('attributeA5').innerHTML ="Cargo: "+ (responseText.player5.cargo);
                };
                xhr.send();
            }  -->
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
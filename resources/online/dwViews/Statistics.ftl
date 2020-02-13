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
		 <style>
                 body {
                display: flex;
                flex-direction: column;
                justify-content: baseline;
                align-items: center;
                color: #666;
                font-size: 1.5em;
                font-family: sans-serif;
<<<<<<< HEAD
                background:url(./images/slide04.jpg)  no-repeat center center;
                background-size:cover;
                background-attachment:fixed;
                }
=======
                background:url(assets/slide04.jpg)  no-repeat center center;
                background-size:cover;
                background-attachment:fixed;
                }

>>>>>>> origin/Ken
                .button  {
                padding: 1em 2.5em;
                position:absolute;
                 right: 420;
                 bottom: 100;
                 left: 420;
                color: #666;
                font-weight: bold;
                text-align: center;
                text-decoration: none;
                white-space: nowrap;
                background-color: #fff;
                background-image: linear-gradient(180deg, #fbfbfb, #c7c7c7);
                border: 0.0625em solid #d7d7d7;
                border-radius: 0.5em;
                box-shadow: 0 0.125em 0.5em rgba(0,0,0,0.3);
                cursor: pointer; 
                }
<<<<<<< HEAD
=======

>>>>>>> origin/Ken
                .table { 
                font-size:20;
                text-align:center;
                margin-right: 20px;
                margin-top:50px;
                cursor: pointer; 
                }
                    </style>
	</head>

<<<<<<< HEAD
<body onload="initalize()">
  <!-- Call the initalize method when the page loads -->
  
  <div class="container">
    <table class="table" id="table1">
      <thead>
        <tr>
          <th scope="col">Number of Games</th>
          <th scope="col">Number of Human Wins</th>
          <th scope="col">Number of AI Wins</th>
          <th scope="col">Average Draws Per Game</th>
          <th scope="col">Max Round per Game</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td><strong id="totalGameCount"></strong></td>
          <td><strong id="totalHumanWins"></strong></td>
          <td><strong id="totalAIWins"></strong></td>
          <td><strong id="averageDraws"></strong></td>
          <td><strong id="maxRound"></strong></td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="row bottom">
    <div class="col"></div>
    <div class="col centerButtons">
      <a class="btn btn-lg btn-light" href="/toptrumps/" id="backButton">Go Back to Game Screen</a>
    </div>
    <div class="col"></div>
  </div>

        <script type="text/javascript">
          
          // Method that is called on page load
          function initalize() {
          
            // --------------------------------------------------------------------------
            // You can call other methods you want to run when the page first loads here
            // --------------------------------------------------------------------------
            
            // For example, lets call our sample methods
            // helloJSONList();
            // helloWord("Student");
            totalGameCount();
            totalHumanWins();
            totalAIWins();
            averageDraws();
            maxRound();
          }
          
          // -----------------------------------------
          // Add your other Javascript methods Here
          // -----------------------------------------
        
          function totalGameCount() {
            var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/totalGames");
            if (!xhr) {
                alert("CORS is not supported");
            }
            xhr.onload = function(e) {
                var responseText = JSON.parse(xhr.response);
                $('#totalGames').text(responseText);
            };
            xhr.send();
        }
         function totalHumanWins() {
            var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/totalHumanWins");
            if (!xhr) {
                alert("CORS is not supported");
            }
            xhr.onload = function(e) {
                var responseText = JSON.parse(xhr.response);
                $('#totalHumanWins').text(responseText);
            };
            xhr.send();
        }

        function totalAIWins() {
            var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/totalAIWins");
            if (!xhr) {
                alert("CORS is not supported");
            }
            xhr.onload = function(e) {
                var responseText = JSON.parse(xhr.response);
                $('#totalAIWins').text(responseText);
            };
            xhr.send();
        }

        function averageDraws() {
            var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/averageDraws");
            if (!xhr) {
                alert("CORS is not supported");
            }
            xhr.onload = function(e) {
                var responseText = JSON.parse(xhr.response);
                $('#averageDraws').text(responseText);
            };
            xhr.send();
        }

        function maxRound() {
            var xhr = createCORSRequest('GET', "http://localhost:7777/toptrumps/maxRound");
            if (!xhr) {
                alert("CORS is not supported");
            }
            xhr.onload = function(e) {
                var responseText = JSON.parse(xhr.response);
                $('#maxRound').text(responseText);
            };
            xhr.send();
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
=======
    <body onload="initalize()"> <!-- Call the initalize method when the page loads -->
    	
    	<div class="container">

                 <table class="table" id="table1">
                  <thead>
                  <tr>
                    <th scope="col">No. of Games</th>
                    <th scope="col">No. of User Wins</th>
                    <th scope="col">No. of AI Wins</th>
                    <th scope="col">Average Draws</th>
                    <th scope="col">Longest Round</th>
                  </tr>
               
                  </thead>
                  <tbody>
                    <tr>
                        <td><strong id="totalGames"></strong></td>
                        <td><strong id="userWins"></strong></td>
                        <td><strong id="AIWins"></strong></td>
                        <td><strong id="averageDraws"></strong></td>
                        <td><strong id="longestRound"></strong></td>
                    </tr>
                  </tbody>
                    </table>    
                     <a class="button" href= "http://localhost:7777/toptrumps">Back To Game Selection</a>
		
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
>>>>>>> origin/Ken

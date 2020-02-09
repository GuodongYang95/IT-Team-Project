# 01/19/2020 4:00AM   --Junhao Huang
  1. merge all the staff of the version end of today.
  2. Create User Class
  3. Create AI Class
  4. Modify the attributes of the DBConnected Class
  5. add some comment in the GameManager Class
  6. Change the type of cardPile to ArrayList< Card >.
  7. Modify the takeCard() method in Player Class
  8. Modify the name of isactive() and setactive in Player class. It should be isActive() and setActive()
  9. Delete the method: giveCard() in Player Class.
  10. Card Class: we need to use Reflection to get the attribute and its value from each instance, this might be hard, but it is worth learing, please have a look.(important)
  11. Card Class: There are some method used to find max value in the category (important)
  12. Written getSelectedCategoryValue(), findBiggestCategory() method in Card Class.
  13. Finish judge draw method, activePlayerSelector() function.

# 01/19/2020 10:30 AM  --Junhao Huang 
1. Updated User Selected method: User should selected the number of the category, but not the category name.
2. Finish roundStart() function
3. Doing in showRoundResultFunction 
   1. add selectWinner function
   2. add distribute card method

# 01/20/2020 13:00 PM --Junhao Huang
## List the things might be changed.
      1. add .gitignore file
            need to ignore the .classpath and .project
            because this two file is related to the personal jdk in the PC, if not, it will cause jdk missing when pull the branch.
      2. might not connect to DataBase, when drag the card.
      3. change to MVC structure. 

# 01/23/2020 01:05 AM --Junhao Huang
1. Separated the Model class
2. Add initializeCard() function which can gain the card from the file "./StarCitizenDeck.txt"
      Test successfully!
      and it can acquire 40 cards in total from the file, and print the card in a right way!
3. Modified several function, such as selectCategory() in AI and User.

4. Important change:  the card information which is gained from database is now changed, see (1).
5. Warning: write Log function needed. 
      
# 01/24/2020 01:00 AM --Junhao Huang

1. Finish overall model (will modify if needed)
   There might some point:
      how to generate each model; (Contributor needed)

2. Try to add Controller and Listener
   Chanllenges: how to actually use it to wait user's input, and then call method.

# 01/25/2020 04:00 AM --Junhao HUang
1. fixed some bug in Model Part.
       can select the category correctly
2. gennerate the controller.
3. the CML mode is now can run, but still some bugs:
            the card cannot show correctly at each round
4. log function need to be added
5. database connection to be added.

# 01/25/2020 2:33 PM --Junhao Huang

## fixed bug:
      1. accidently select and reset active player at the same time:    Model_RoundManager line:128
     
          fixed: it is commented. (deleted)

      2. accidently pick the card again when select category: Class:    Model_Player line:149 
   
          fixed: it is commented (deleted)

      3. did't reset winPlayerList after active player select the category  
   
            fixed at : Model_RoundManager line:90
      
      4. the game will throw error when user is out
   
            fixed at: Model_RoundManager line:190~203
## Add function
      Player now can end game at each time
      Add at :   Model_GameManager line 40~65

## needed:
      1. log function need to be added
      2. database connection to be added.
   
# 01/29  Meeting details:
      1.commandLine mode will be completede after finishing log function and database connection.
      2. Understand the working step of online mode
      3. Confirm that the knowledges of online mode needed: Jax,  Html , JavaScripts, CSS
      4. Spend one week to master these language.

# 02/03/2020 1:13 AM --Junhao Huang
## Complete log function
      1. the log function can be controlled by argument which is -t
      2. the log function will be covered when a new game start
      3. it recored the total cardpile, each player cardpile at each round, the owned card of each player at each round, the selected category, the round winner, the overall winner. 


# 02/05   Meeting details:
      1. divide the task of online mode into three parts: JS, Html, Jax
      2. start to write Story card
      3. Goes into Sprint 2 --- Online Version

# 02/05/2020 3.21 P.M. -- Junhao Huang
      1.Log function improvement:
            the log now can be written following the game is contining.
               add write.flush()
      2.Game improvement. The game will not end until user input 3 from the Game menu;
            the number: 3 in GameMenu is Exit Game.

# 02/09/2020 3.03 A.M. -- Junhao Huang
      1. our website can get information from backend right now;
            the type between client and server is json String type.
            Js will have method to convert it into Json object.
      2. the game bankend part connection is nearly finished,
            need Js to show details to the User.
            here is the response url:
            /toptrumps/gamestart
            /toptrumps/gamestart/categoryselect
            /toptrumps/gamestart/userCategoryselect
            /toptrumps/gamestart/showresult
            /toptrumps/gamestart/newround

# 02/09/2020 2:18 P.M  --Junhao Huang
      1.in SelectionScreen.ftl   line: 22~172
            Add the Js function which can get data from backend
      2.each will be called when load the page or click the button
            see comment
      
# 17/01/2020 LOG
## JunhaoHuang / GuodongYang
    Start doing Game Manager Class, including startGame(), cardDistribute(). 
    Also, Card class and DBConnected class were created with the function of randomCard().

# 18/01/2020 LOG
## Guodong Yang
    Focus on gameOrStatistics(), statistics(), infoRecord(), winOrOut(), endGame().

# 22/01/2020 LOG
## Guodong Yang
    Based on MVC structure, a package named view was created with a CommonLineView class in it.
    The CommonLineView class contains the following methods:

        1. gameOrStatstics() //The view of asking user whether playing a game or showing the past game statistics
   
        2. numOfAi() //The view of asking user to choose how many AI players 


        3. statstics() //The view of past game statistics


        4. roundStart() //The view of the round started


        5. selectCategory() //The view of game results 


        6. endGame() //The view of displaying players' final score

# 27/01/2020 LOG
## GuodongYang
    1. Improve the game process that if user is out, then this game will be over.
        Solution: rewrite winOrOut() in RoundManager Class. If the user is out, this game will be continued until one of AI player wins the game.

    2. Add a method that outputing "You have lost!" when the user is out.
        Thought: When user has only one card on his card pile, the next round should not display the number of his card pile. Meanwhile, if user lose the next round again, the user will be out the game with no more card information.
        Solution: create oneCardLeft() and oneCardLeftLose() in RoundManager class which were called by userHaveLost() in GameManager class.
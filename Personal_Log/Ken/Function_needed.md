# CLI mode

## GameManager Class
    GameManager is going to control the game. Store the data to the Database or fetch the data from Database.
### Attribute Needed:
#### Totalcard (int)
    this should be 40 cards totally.
#### roundCount (int)
    record the round
####  drawTimes (int)
    record how many times of draw happened during a game.
####  userWin (boolean)
    true/false attribute. if it is true, it means user wins at a game. false means AI win the game.
#### players (Player[n])
    this is player array, store the user object and AI object. n is decided by user.
#### commonCardPile (Card arraylist)
    this attribute will store card while a draw round.

### function: startGame()
    this method will create the AI player. 
    Player[n]:it will put the user at index[0], AI will behind these index.

### function: cardHandOut(DBConnected db)
    this method will hand out the card averagely according to the number of Players. it will also get the property of each card from DBConnected instance. And put them into Player's cardPile.
### function: infoRecord(DBConnected db)
    this method will store the information to the DBConnected instance. Basically store 
    roundCount; drawtimes; userwin.
### function: showPastResult(DBConnected db)
    this method will fetch the information from the database, and show it to the user.

### function: activePlayerSelect()
    do at the beginner of a round
    GameManager will select a active player.
    if it is round 1 game, randomly choose a active player.
    if a player win at the round, let him active next round. 
    if isDraw(), then GameManger will monitor whether the user is included.
        if included, let user active. player[0]=true;
        if not, randomly choose AI active.
### function: winOrOut()
    if a player has 40 cards on his pile, then he win the game. game over! infoRecord()
    if a player got 0 cards on his pile, then he is out.
### function: isDraw()
    this function is used to judge whether the max value of selected catagory has mutiple player.
        if has, put them in a list
        if not, return null
    giveCardToCommonPile()

    return list.
    
### function: categoryCompare()
    this function find the max value.
    return player list.

### function: giveCardToCommonPile()
    put all card into common pile.

### function: giveCard()
    give the card to the winner player. Do not forget the card in the common pile.

### function: drewCard()
    this will romdomly pick (actually reduce the amout of player's cardPile) a card from user or AI card piles and store it to the object.cardHold. 

### function: GameReset()
    this function will reset all the game data for the new game.

## Player Class
### Attribute needed
#### cardPile (arrayList)
    this arraylist will be used to store the card gotten from GameManager. 

#### cardHold (Card)
    card hold by player in a round. 

#### active (boolean)
    this attribute will present whether a player is active or not.
#### isOut (boolean)
    default is true.
    this will be false depending on the function winOrOut(Player object) in Gamemanager Class. 
    this attributed is needed when deal with html.

## User Class extends Player

### function: numberOfAI()        
    this function is going to let user to deside how many AI he wants to play with.

### function: startgame()
    this is a function that user can start his game.

### function: showPastResult()
    this function is going to connect to the database which can show the past result.

### function: chooseCategory()
    if user is active, he can select a category used to compare with AI, set the active false.
    if not, choose the category which is chosen by active player.
  
### function: endGame()
    this function can let user end his game even the game does not finish.

## AI Class extends Player

### function: chooseCategory()
    if AI is active, choose the highest value which the Category has, set the active false.
    if AI is not active, then choose the category which is chosen by active player.
    
## Card Class 

### Attriute needed

#### speed, cargo, size , range


## DBConnected Class
    this class is used to connect with Database and exchange the game data.
### Attriute needed
#### GameCount (int)
#### MaxRound (int)
#### AverageDraw (int)
#### NumberOfAIWin (int)
#### NumberOfHumanWin (int)
#### cards (Card[40])
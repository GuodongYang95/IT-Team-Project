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

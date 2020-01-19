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
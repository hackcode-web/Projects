Tic Tac Toe

1)board
2)display board
3)handle turn
4)flip player  use a global variable called current player
5)main function called play game in this all mini functions will be called
6) check if game over(winner,tie)

-->put an while loop for playgame so that it will gonna repeat by asking next move

-->now lets go for checking the winner

-->winner:Check rows
       Check columns 
  	         Check diagonals

-->For the case of winner u put an function by named check_for_winner
    In this check_ for_winner we will get 3 sub functions called    row_winner 
     Column_winner and diagonal_winner .

-->we will create 3 functions called row_winner column_winner and diagonal_winner

-->check_rows(): in this we will check 3 rows and then with the help of global variable game_still_going we wil assgn whether it is true or false by using an if condition

-->check_column():in this we will check all thge 3 columns with the help of an global variable game_still_going we wll assign whether it is true or false by using an if condition

-->check_diagonals():in this we will check all the 3 diagonals with the help of an global variable game_still_goin we will assign whether it is true or false by using an if conition 

--> and we added two important things in this first is to handle when an user entered an wrong position number 

-->if user entered wrong number then we will handle that error by using an while loop and an valid statement

-->the other thing is that if user want to enter the position that hae already occupied we have handled that b using the if-else statements in the same while loop.

-->and with this we have succesfully build an Tic Tac Toe prject.

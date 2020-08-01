
#global variable
current_player="X"

#global variable
winner=None

#global variable
game_still_going=True

board=["-","-","-",
       "-","-","-",
       "-","-","-"]


#main important function
def play_game():
    global winner

    display_board()
    while game_still_going:

        handle_turn(current_player)
        check_if_game_over()
        flip_player()


    if winner == "X" or winner== "o":
        print(winner+" u won")
    elif winner==None:
        print("tie")


#displaying board function
def display_board():

    print("\n")
    print(board[0] + " | " + board[1] + " | " + board[2] + "     1 | 2 | 3")
    print(board[3] + " | " + board[4] + " | " + board[5] + "     4 | 5 | 6")
    print(board[6] + " | " + board[7] + " | " + board[8] + "     7 | 8 | 9")
    print("\n")




def handle_turn(current_player):

    valid=False

    while not valid:
        #this loop will break if the while codition is true
        #thats the meaning of not valid(true) if any condition fails then loop will repeat
        print(current_player + "'s turn:")
        position = input("enter the position which u want to insert into :")

        while position not in["1","2","3","4","5","6","7","8","9"]:

            position=input("please enter numbers from 1-9:")



        position=int(position)-1

        if board[position]=="-":

            valid=True
        else:
            print("you cant go there bcz that position was already occupied :")

    board[position]=current_player
    display_board()

#check for winner or or tie
def check_if_game_over():
    check_for_winner()
    check_for_tie()

def check_for_winner():

    global winner
    row_winner=check_rows()
    column_winner=check_columns()
    diagonal_winner=check_diagonals()


    if row_winner:
        winner=row_winner
    elif column_winner:
        winner=column_winner
    elif diagonal_winner:
        winner=diagonal_winner
    else:
        winner=None



def check_rows():
    global game_still_going

    row_1=board[0]==board[1]==board[2] != "-"
    row_2=board[3] == board[4] == board[5] != "-"
    row_3=board[6] == board[7] == board[8] != "-"

    if row_1 or row_2 or row_3:
        game_still_going=False

    if row_1:
        #if row1 won we dont know which letter so thats why board[0] means which letter is there in that
        #it will return that letter
        return board[0]
    elif row_2:
        return board[3]
    elif row_3:
        return board[6]
        # Or return None if there was no winner
    else:
        return None


def check_columns():
    global game_still_going

    column_1=board[0]==board[3]==board[6] !="-"
    column_2 = board[1] == board[4] == board[7] != "-"
    column_3 = board[2] == board[5] == board[8] != "-"

    if column_1 or column_2 or column_3:
        game_still_going=False

    if column_1:
        # if row1 won we dont know which letter so thats why board[0] means which letter is there in that
        # it will return that letter
        return board[0]
    elif column_2:
        return board[1]
    elif column_3:
        return board[2]
        # Or return None if there was no winner
    else:
        return None


def check_diagonals():
    global game_still_going

    diagonal_1=board[0]==board[4]==board[8] !="-"
    diagonal_2 = board[2] == board[4] == board[6] != "-"

    if diagonal_1 or diagonal_2:
        game_still_going=False

    if diagonal_1:
        # if row1 won we dont know which letter so thats why board[0] means which letter is there in that
        # it will return that letter
        return board[0]
    elif diagonal_2:
        return board[2]
        # Or return None if there was no winner
    else:
        return None

def check_for_tie():
    global game_still_going

    if "-" not in board:
        game_still_going=False


    else:
        return True

def flip_player():

    #global variable
    global current_player

    if current_player == "X":

        current_player="o"

    elif current_player == "o":
        current_player="X"


play_game()



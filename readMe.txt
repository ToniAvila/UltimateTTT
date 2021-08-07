I created an Ultimate Tic Tac Toe game program, in which instead of having a single small regular
tic-tac-toe board to play on, we are playing on a 3x3 board of smaller tic-tac-toe boards. Essentially,
we are now playing on a 9x9 board, or a board which has 9 smaller boards within it. In implementing
this game, I learned about the importance of knowing how different objects and classes interact as a whole.
When the program begins to grow in lines of code and complexity, it becomes a bit harder to keep track of what
can interact with what. Using OOP principles like encapsulation, abstract implementation, and aggregation/
composition, it makes the process a bit easier as long as you keep track of it. 

I implemented all the processes and rules the pdf outlined, as well as the move list bonus. 
I also have input validation which verfies that a number the user entered is within the acceptable range, else the 
program will loop in asking the user for another number until it is range while also displaying a "try again" message.
I also have Player vs Player, Player vs AI, and AI vs AI as methods of playing.
The player selects a board and box through respective methods, the computer player does the same but 
with a random number generator within the range. Note that boxes and boards start at 0 and end at 8 as
max. When looking at a single board, the upper left corner is 0, the upper right corner is 2, etc.
Boxes and Boards are numbered as such: 0 1 2
				       3 4 5
                                       6 7 8

Note: If a player is sent to a board that is full, they have the option of freely selecting a board
to play on, as specified by rules. If a player is sent to a board that has been won but is still not
full, they have to play on that board still.



If I were to reimplement Ultimate Tic Tac Toe all over again I would
maybe change the way the game and board are made. Instead of making
another class which creates the ultimate board through a 2D array of regular
"OtherBoards" I would attempt to instead simply make a 9x9 board and see how I fare.
The way I implemented my current program, making a board of boards, made the most
sense to me personally. I could see how new methods would be made to check for a winner
or tie and I could see how the boards, players, and game would interact. Some parts were
tricky to implement and sometimes it was hard to keep track of what board I should
be using but in the end it worked out. 
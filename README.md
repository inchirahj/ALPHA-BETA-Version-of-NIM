# ALPHA-BETA-Version-of-NIM

Assignment
-----------

For this programming assignment, you should implement the ALPHA-BETA algorithm to play the game of NIM. Your program does not need to have any graphics or graphical user interface, but it should be obvious whose turn it is and how to enter a move.

This assignment is an updated version of the Game of NIM. 

Some notes about this assignment:
- You should change your code to ask the user to select the initial number of sticks in the
pile, as well as the maximum number of sticks that you can choose in a move. The computer should still make the first move, however.
- You should be able to implement the full version of ALPHA-BETA; you do not need to cut it short and use evaluation functions.
- If you select a large number of initial sticks (roughly 30 or more), the algorithm will take quite a while to finish. You can assume that I will not test it on values that are too large.
- In NIM, it would make sense to have MIN-VALUE and MAX-VALUE to return integers instead of floats, since the only values possible are +1 and -1.
- Note that “state current” is just a placeholder for however you choose to represent the state of the game. In NIM that is as simple as an integer representing the number of sticks left.

                                    _   _             _                 
     /\                        /\  | | | |           | |                
    /  \   _ __ ___  __ _     /  \ | |_| |_ __ _  ___| | _____ _ __ ___ 
   / /\ \ | '__/ _ \/ _` |   / /\ \| __| __/ _` |/ __| |/ / _ \ '__/ __|
  / ____ \| | |  __/ (_| |  / ____ \ |_| || (_| | (__|   <  __/ |  \__ \
 /_/    \_\_|  \___|\__,_| /_/    \_\__|\__\__,_|\___|_|\_\___|_|  |___/
                                                                        
                                                                        

--------------------
Version 1
11/29/17

Created by:
Sarinda Samarasinghe
Josh Delgado
--------------------


Description:
Area Attackers is a 2D Side-Scrolling Space-themed Shooter.
That's a lot of S's. 
So in short, it's a space shoot-em-up. 
Even more S's. Yay.

Features:
Editable Levels
Custom Enemies:
	Health, Speed, Score, Spawn location/time


============================
User Guide:

1. Playing the Game
2. Edit/Create levels
  A. Overall Syntax
    a. Enemy Prefabrications
  B. Custom Enemy Syntax
============================


====================
1. Playing the Game
====================
Run the AreaAttackers.java file to play the game.
As the pink box at the bottom, your goal is to
destroy the enemies to prevent them from passing.
You get a certain amount of points for every
shot that hits each enemy, depending on the type
of enemy you hit. Compete for high scores!

Controls:
Left/Right Arrow: Movement
Up Arrow: Attack

Random Tip:
The player currently doesn't have a hitbox, so
don't worry about having the ships hit you. Just
keep on firing!

Note: You can only have one bullet on the screen
at a time. So effectively this means your fire
rate goes up as the enemies are closer, since the
bullet is on screen for shorter periods of time.


======================
2. Edit/Create Levels
======================
The text file "EnemyWave.txt" is the location of the
information for the enemy types.


|===A. Overall Syntax===|
The first line will have an integer N for the number of
waves.

Each wave will begin with an integer E for the number of
enemies in the wave. Optionally, there are comments
after the number of enemies to describe the wave. There
is no need for special formatting, as the code only
reads in the line, and reads in the first token, the integer
On the following E lines, there will be either an A)enemy 
prefabrication or a B)custom enemy, followed by the delay
in 10ms (100 = 1 second) after the previous enemy is spawned,
then the x Location of the enemy spawn.
If the x Location is outside of bounds, it will be randomly
spawned in the game frame.

Note: If it is a sine enemy, the random spawn may make
the enemy fly off the frame for half of it's oscillation.
Plan accordingly.


In picture format:
---------------------
numWaves
numEnemies
enemyType timeDelayBeforeSpawn(100 = 1 sec) xPositionForSpawn(0 = left)

etc.

---a. Enemy Prefabrications---
All enemyPrefabrications will end in a letter L that will
represent the health of the enemy, with A = 1.

For example: "SineC" refers to an enemy with the
prefab "Sine" that has 3 health.


Prefabrication Name  | 	Movement Type | Speed | Score
-----------------------------------------------------
Type			Straight Down	1	10
"" (Just letter L)	Straight Down	.5	10
s			Sine		1	100
Wall			Straight Down	.5	10
SlowWall		Straight Down	.3	10
SSlowWall		Straight Down	.1	100 //Super Slow Wall


|===B. Custom Enemy Syntax===|
Each line will have one of the following general syntaxes

new enemyMoveType health speed score delay xSpawn
new sine health speed score amplitude frequency delay xSpawn

enemyMoveType | Description
StraightDown	Moves straight down, speed pixels/second
Sine		Moves in a sine wave
Diagonal	Moves in a diagonal line, and bounces off walls.

Note: amplitude and frequency is pretty finicky.
Default: 5 .05
Recommended Values:
4 .08

Also, amplitude is not the number of pixels wide.
I just advice randomly playing with the numbers.










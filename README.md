# D-D-RPG

#### Description

This is a console game in which the user choose team of heroes
of particular Race (_Elf, Human, Dwarf_).

Each hero has some specific features.

In team _**one Hero is a leader**_, and others are team-members.

Hero start game from _**Level 1**_ with 10XP and can improve himself 
up to _**Level 10**_.

In one move character can do one action, which chosen from set of actions
for particular hero.

The team will be fight against monsters in some fabulous location.

_**Location is unique for each play and generated with 
[Prim's Algorithm](https://en.wikipedia.org/wiki/Prim%27s_algorithm).**_
For each play Team of heroes randomly placed in some part of our fabulous location
and start to discover locality, in which exist monsters... or not).

### Some information about maze concept
As mentioned above in this app used Prim's algorithm to create maze skeleton.
This one is a 2 dimensional int array (0 - WALL, 1 - PATH, etc.).

But in game user moves between Locations. Simply it's a class, which among
other things has _two_ essential fields: lineA and lineB. And based on that
each Location has _mainLine_ and _crossLine_.
_**LineA**_ its a List (LinkedList) in which elements stores from bottom to top,
and _**LineB**_ - from left to right.
                                   
So, _**Line type 'A'**_ its all vertical lines in maze, and _**line type 'B'**_
all horizontal lines. The game always started at position, where mainLine
matches with LineA, and crossLine matches with LineB.

Depends on further moves (which line type for current Location is main) user
can move in abstraction "straight", "back", "right", "left".

To handle movement logic in app created Interface 'Compass' which defines how 
user can move in current position. 

Game ends when the goal is reached (reach some Rabbit Hole to next location),
or when the Team's Leader dies.



#### Prerequisites:
- install [Maven](https://maven.apache.org/download.cgi). 

App better used in terminal full-screen mode in conventional terminal)

#### How to start up ?
- git clone
- build the maven project ```mvn package```
- start app with the below cmd
          
            java -cp target/D-D-RPG-1.0-SNAPSHOT.jar cursor.rybak.StartGame



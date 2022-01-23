# weForgot
## Kevin Li, Justin Mohabir, Jonathan Song
## Description
An RPG in which you spawn on a grid and are able to move around on it. You are represented with a **p**, monsters are represented with an **M**, the shopkeeper is presented with a **$**, and the boss is represented with a **B**. Move onto the tiles with a monster on them to start a battle. Obtain gold after defeating monsters and use it to buy items from the shopkeeper to help you on your journeys. Defeat all the monsters to summon the boss. Defeat the boss to win.
## Launch instructions
  - Go to the directory
    - `$ javac *.java`
    - `$ javac Woo.java`
  - In Grid.java, you can modify int monsterSize to increase your number of monster encounters
  - In Driver.java, you can modify the constructor for grid to increase the size of the grid. The constructor is grid(int length, int height)
  - type w, a, s, or d in lowercase, and then hit enter to move around on the grid

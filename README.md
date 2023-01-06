# HotStone
HotStone Game is a card-playing game.

Two players, each represents by a Hero, play against each other. 
Each Hero has their own Power, Health, and ManaProduction, representing how many Mana that they have.
Each Card has its own Power and ManaCost, representing how much Mana it costs to play the Card.
Each player has their own Hand, Deck, and both share a Field.
The cards are played between the Hand, Deck, and Field.
The program includes the designs for multiple versions of the game, named from AlphaStone to ThetaStone.

The program uses Minidraw as its UI framework.

When trying to run gradle tasks that show a GUI from your WSL container,  you will get an error about headless mode and X Server not set/cannot be connected to.

Steps to fix:

Download and install XMing: https://sourceforge.net/projects/xming/files/Xming/6.9.0.31/

This will  automatically start XMing, right click on it in the process tray and exit

Right click on the icon for XMing and "Open file location"

Right click on the XMing shortcut and go to properties

Add -ac to the end of the Target field and click OK

Launch the shortcut

Run this in your WSL terminal (Ideally add it to your .bashrc):  export DISPLAY=$(cat /etc/resolv.conf | grep nameserver | awk '{print $2}'):0
gradle XYZ  should now open in its own window


# 2048

## Project Overview

2048 is a Java Swing implementation of the classic 2048 puzzle game,
developed as a Challenge-Based Learning (CBL) project for the 2IP90
course at Eindhoven University of Technology.

The objective is to combine tiles of equal value to reach 2048.
Our implementation includes a graphical user interface, keyboard and
on-screen controls, score tracking, persistent high scores, and a
stack-based Undo feature that allows players to reverse previous moves.

## Requirements

- **Java Development Kit (JDK) 26** — required to compile and run
  the project.
- **Apache NetBeans IDE 31** — used to open, build, and run the project.

The application uses Java Swing and standard Java libraries.
Apache NetBeans includes Maven, so a separate Maven installation
is not required.

## Installation and Setup

The application is designed to run on Windows, macOS, and Linux
using Java Swing.

### Step 1: Install Java Development Kit (JDK) 26

1. Visit the [Oracle Java Downloads](https://www.oracle.com/java/technologies/downloads/) website.
2. Locate **JDK 26**.
3. Download the installer or package appropriate for your operating
   system (Windows, macOS, or Linux).
4. Install JDK 26 following the instructions for your operating system.

### Step 2: Install Apache NetBeans IDE 31

1. Visit the [Apache NetBeans website](https://netbeans.apache.org/).
2. Download **Apache NetBeans IDE 31**.
3. Install or extract NetBeans following the instructions for your
   operating system.
4. Launch Apache NetBeans.

### Step 3: Open the 2048 Project

1. Extract the submitted `2048.zip` archive to a folder.
2. Launch Apache NetBeans.
3. Select **File > Open Project**.
4. Navigate to the extracted project folder containing `pom.xml`.
5. Select the project folder and click **Open Project**.
6. Ensure that JDK 26 is selected as the Java platform for the project.
   If necessary, right-click the project, select **Properties**,
   and choose JDK 26 under the Java platform settings.

### Step 4: Build and Run the Application

1. Locate the `2048` project in the NetBeans Projects window.
2. Right-click the project and select **Clean and Build**.
3. Wait until the Output window displays `BUILD SUCCESS`.
4. Right-click the project again and select **Run**.
5. The 2048 game window should open and be ready to play.

## How to Play

1. Launch the application using the instructions above.
2. Use the **arrow keys** or **on-screen directional buttons** to
   move all tiles up, down, left, or right.
3. When two tiles of the same value collide during a move,
   they merge into one tile with double the value.
4. Each successful merge increases the player's score by the
   value of the resulting tile.
5. After a valid move, a new tile appears on an empty cell.
6. Continue combining tiles to create a **2048 tile** and win.
7. The game ends when the board is full and no valid moves remain.

### Additional Controls

- **New Game** — starts a new game and resets the current score.
- **Undo** — reverses the previous valid move, restoring the
  board and score.
- **Highest Score** — displays the highest score saved across
  game sessions.

## Game Features

- **Graphical User Interface:** A Java Swing interface featuring
  a 4×4 game board with custom-designed tiles and controls.
- **Tile Movement and Merging:** Tiles move in four directions
  and merge when they have matching values.
- **Score Tracking:** The current score updates whenever tiles merge.
- **Persistent High Score:** The highest score is saved and
  retained between game sessions.
- **Undo System:** A stack-based system allows players to reverse
  previous valid moves, restoring the board and score.
- **New Game:** Players can restart the game at any time.
- **Victory Detection:** The game displays a victory message
  when a 2048 tile is created.
- **Game Over Detection:** The game identifies when no valid
  moves remain.
- **Multiple Input Methods:** Players can use keyboard arrow keys
  or on-screen directional buttons.

## Screenshots

![2048 Game Interface](screenshots/gameplay.png)

## Project Structure

The project follows the standard Maven directory structure.
All Java source files are located in `src/main/java/com/mycompany/`.

### Java Classes

- **App.java** — the application's entry point, which launches
  the game.
- **Game2048.java** — manages the game board, tile movement,
  merging, scoring, and win/loss conditions.
- **GameDisplay.java** — implements the Java Swing interface,
  processes player input, and updates the displayed game state.
- **GameHistory.java** — manages the stack-based Undo system,
  storing previous board states and scores.
- **TileGenerator.java** — generates new tiles in available
  board positions.
- **RoundedTile.java** — provides the custom appearance of
  an individual tile.
- **RoundedPanel.java** — provides custom rounded panel components.
- **CloudyPanel.java** — provides a custom panel used in the
  graphical interface.

### Other Project Files

- **pom.xml** — contains the Maven project configuration
  and build settings.
- **2IP90_checks.xml** — contains the course-specific
  Checkstyle rules.
- **README.md** — provides project documentation and instructions.
- **screenshots/** — contains the gameplay screenshot used
  in this README.
- **Project Backlog.pdf** — contains the final Product Backlog.
- **Reflection Paper.pdf** — contains the written reflection
  on the two independently researched advanced topics.

## Authors

Developed by:

- Zara Tasnim (Student number: 2450607)
- Selena Sirbu (Student number: 2472007)

Eindhoven University of Technology (TU/e)

Course: 2IP90 — Challenge-Based Learning (CBL) Project

Academic Year: 2026–2027
# 2048

## Project Overview

2048 is a Java Swing implementation of the classic 2048 puzzle game, developed
as a Challenge-Based Learning (CBL) project for the 2IP90 course at Eindhoven
University of Technology.

The objective is to combine tiles of equal value to reach 2048. Our
implementation includes a graphical user interface, keyboard and on-screen
controls, score tracking, persistent high scores, and a stack-based Undo feature
that allows players to reverse previous moves.

## Requirements

- **Java Development Kit (JDK) 26** — required to compile and run the project.
- **Apache Maven** — required for building and running the project using the
command-line instructions.
- **Apache NetBeans IDE 31 (optional)** — recommended for opening, building,
and running the project through an IDE. NetBeans includes Apache Maven.

The application uses standard Java libraries, including Swing, and does not
require additional third-party libraries.

## Installation and Setup

1. **Install Java Development Kit (JDK) 26**
    - Download and install JDK 26 for your operating system.
    - Verify the installation using `java --version` and `javac --version` in a
terminal.
    - Configure the `JAVA_HOME` environment variable to point to the JDK 26
installation directory.

2. **Install Apache Maven**
    - Install Apache Maven if you plan to build and run the project from the
command line.
    - Verify the installation using `mvn --version`.
    - A separate Maven installation is not required when using Apache NetBeans
IDE 31, as Maven is bundled with the IDE.

3. **Install Apache NetBeans IDE 31 (optional)**
    - Install Apache NetBeans IDE 31 if you prefer to build and run the project
through an IDE.
    - Ensure that NetBeans is configured to use JDK 26.

4. **Set Up the 2048 Project**
    - Download and extract the submitted ZIP file.
    - Locate the extracted project folder containing the `pom.xml` file.
    - If using NetBeans, select **File > Open Project** and open the extracted
project folder.
    - If using the command line, open a terminal in the extracted project folder.

No additional application-specific configuration is required.

## How to Run

### Option 1: Using Apache NetBeans

1. Open the `2048` project in Apache NetBeans.
2. Right-click the project in the Projects window.
3. Select **Clean and Build** and wait for `BUILD SUCCESS`.
4. Right-click the project again and select **Run** (or press `F6`).
5. The 2048 game window will open.

### Option 2: Using Apache Maven

1. Open a terminal in the extracted project folder containing `pom.xml`.
2. Ensure that JDK 26 and Apache Maven are installed and configured.
3. Build the project using:
    ```bash
    mvn clean package
    ```
4. Wait for `BUILD SUCCESS`.
5. Launch the game using:
    ```bash
    mvn exec:java -Dexec.mainClass=com.mycompany.App
    ```
6. The 2048 game window will open.

## How to Play

1. Start the game using either of the methods described above.
2. Use the **arrow keys** or the **on-screen directional buttons** to move all
tiles up, down, left, or right.
3. When two tiles of the same value collide during a move, they merge into one
tile with double the value.
4. Each successful merge increases the player's score by the value of the
resulting tile.
5. After a valid move, a new tile appears on an empty cell.
6. Continue combining tiles to create a **2048 tile** and win the game.
7. The game ends when the board is full and no valid moves remain.

### Additional Controls

- **New Game** — starts a new game and resets the current score.
- **Undo** — reverses the previous valid move, restoring the board and score.
- **Highest Score** — displays the highest score saved across game sessions.

## Game Features

- **Graphical User Interface:** A Java Swing interface featuring a 4×4 game board
with custom-designed tiles and controls.
- **Tile Movement and Merging:** Tiles move in four directions and merge when
they have matching values.
- **Score Tracking:** The current score updates whenever tiles merge.
- **Persistent High Score:** The highest score is saved and retained between
game sessions.
- **Undo System:** A stack-based system that allows players to reverse previous
valid moves, restoring the board and score.
- **New Game:** Players can restart the game at any time.
- **Victory Detection:** The game displays a victory message when a 2048 tile is
created.
- **Game Over Detection:** The game identifies when no valid moves remain.
- **Multiple Input Methods:** Players can either use keyboard arrow keys or
on-screen directional buttons.

## Screenshots

![2048 Game Interface](screenshots/gameplay.png)

## Project Structure

The project follows the standard Maven directory structure. All Java source files
are located in `src/main/java/com/mycompany/`.

### Java Classes

- **App.java** — the application's entry point, which launches the game.
- **Game2048.java** — manages the game board, tile movement, merging, scoring,
and win/loss conditions.
- **GameDisplay.java** — implements the Java Swing interface, processes player
input, and updates the displayed game state.
- **GameHistory.java** — manages the stack-based Undo system, storing previous
board states and scores.
- **TileGenerator.java** — generates new tiles in available board positions.
- **RoundedTile.java** — provides the custom appearance of an individual tile.
- **RoundedPanel.java** — provides custom rounded panel components.
- **CloudyPanel.java** — provides a custom panel used in the graphical interface.

### Other Project Files

- **pom.xml** — contains the Maven project configuration and build settings.
- **2IP90_checks.xml** — contains the course-specific Checkstyle rules.
- **README.md** — provides project documentation and instructions.
- **screenshots/** — contains the gameplay screenshot used in this README.

## Authors


Developed by:
- Zara Tasnim (Student number: 2450607)
- Selena Sirbu (Student number: 2472007)

Eindhoven University of Technology (TU/e)

Course: 2IP90 — Challenge-Based Learning (CBL) Project

Academic Year: 2026-2027
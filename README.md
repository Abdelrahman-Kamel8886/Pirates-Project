
# Mind Storm Game

**Mind Storm Game** is a feature-rich implementation of the classic "XO" game, enhanced with additional functionality and designed for both single-player and multiplayer experiences. The project integrates AI, local multiplayer, and online gameplay, making it an engaging choice for all types of players.

This project utilizes **[GameServerEngine](https://github.com/DaTaj-ai/GameServerEngine)** to handle all network requests. A callback method is used across all pages that require responses, allowing for efficient handling of data on a single thread. All requests and responses are handled using a unified model and parsed with Gson for easy data handling.

---

## Table of Contents

- [Features](#features)
- [Gameplay Flows](#gameplay-flows)
  - [Guest Mode](#guest-mode)
  - [User Mode](#user-mode)
- [Technologies Used](#technologies-used)
- [Setup Instructions](#setup-instructions)
- [Usage](#usage)
- [Contributing](#contributing)
- [Acknowledgments](#acknowledgments)
- [Team Members](#team-members)

---

## Features

- **Splash Screen**: Welcomes players with an engaging intro.
- **Authentication System**: Includes Login, Signup, and Guest modes.
- **Game Modes**:
  - Play against AI with three difficulty levels.
  - Play locally with a friend on the same machine.
  - Play online with other users through a server connection.
- **Recorded Games**:
  - Option to record gameplay sessions.
  - Records are saved in files for later access.
  - View a list of recorded games in the home screen.
  - Replay recorded games to analyze strategies or relive moments.
- **Mini-Games**: Includes a Snake game for additional entertainment.
- **User Settings**:
  - Change password.
  - Logout functionality.
- **Dynamic User List**: Displays a list of available users online, fetched from the server.
- **Invitation System**: Allows users to send invitations to other online users for online play.

---

## Gameplay Flows

### Guest Mode

- **Home Screen**:
  - Access single-player mode (play against AI with three difficulty levels).
  - Play with a friend locally on the same machine.
  - Record games during play.
  - View recorded games in a list and replay them.
  - Play the Snake mini-game.

### User Mode

- **Home Screen**:
  - All features available in Guest Mode.
  - View a list of available online users fetched from the server.
  - Send invitations to other users to play online.
- **Settings**:
  - Change your password.
  - Logout from the system.

---

## Technologies Used

- **Programming Language**: Java 8
- **Development Environment**: NetBeans 8.2
- **UI Framework**: JavaFX
- **Networking**: Custom implementation for client-server communication using the [GameServerEngine](https://github.com/DaTaj-ai/GameServerEngine).
- **AI**: Custom algorithms for three difficulty levels in single-player mode.
- **File System**: Used for storing game records.
- **CSS**: Used for styling and managing the UI design.
- **Libraries**:
  - **Gson**: Used for parsing JSON data in requests and responses.

---

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/Abdelrahman-Kamel8886/Pirates-Project.git
   ```
2. Navigate to the project directory:
   ```bash
   cd Pirates-Project
   ```
3. Open the project in NetBeans 8.2.
4. Ensure you have Java 8 installed on your system.
5. Build and run the project from NetBeans.

---

## Usage

1. Launch the application.
2. Choose your preferred mode:
   - **Login**: Enter your credentials to access the user-specific features.
   - **Signup**: Create a new account.
   - **Continue as Guest**: Play without creating an account.
3. Navigate through the Home screen to select your desired activity:
   - Play XO against AI or a friend locally.
   - Play Snake.
   - View or replay recorded games.
   - If logged in, invite users for online matches.
4. Adjust settings or logout as needed (User Mode only).

---

## Contributing

Contributions are welcome! If you have suggestions for improvements or new features, feel free to open an issue or submit a pull request.

---

### Acknowledgments

Special thanks to all contributors and testers who helped bring Mind Storm Game to life. Your support and feedback are invaluable!

### Team Members

- **Mohmamed Tag Eldin**
- **Abram Morris**
- **Nourhan Essam**
- **Jailan Medhat**
- **Abdelrahman Kamel**

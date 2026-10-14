# Assignment 4 — Facade Pattern

A Java console simulation of a Home Theater system using the Facade design pattern.

## Overview

The system contains five devices: a DVD player, amplifier, projector, screen, and lights.

The `Facade` class coordinates these devices through two public operations:

- `watchMovie(String movieTitle)` — prepares the devices and starts playback.
- `endMovie()` — stops playback and shuts down the movie session.

This project simulates device behavior through state changes and console messages. It does not play actual video files.

## Project Structure

- `src/hometheatre/app/Main.java` — client and demonstration scenarios.
- `src/hometheatre/config/Configuration.java` — creates devices and injects them into the facade.
- `src/hometheatre/facade/Facade.java` — coordinates the movie workflow.
- `src/hometheatre/subsystem/DvdPlayer.java` — movie loading and playback.
- `src/hometheatre/subsystem/Amplifier.java` — audio source and volume.
- `src/hometheatre/subsystem/Projector.java` — input source and widescreen mode.
- `src/hometheatre/subsystem/Screen.java` — screen position.
- `src/hometheatre/subsystem/Lights.java` — lighting brightness.

## Requirements

- JDK 17 or later.
- No external libraries are required.

## How to Run

### IntelliJ IDEA

1. Open the project.
2. Select JDK 17 as the project SDK.
3. Ensure `src` is marked as Sources Root.
4. Open `src/hometheatre/app/Main.java`.
5. Run `Main.main()`.

### Terminal

Run these commands from the project root:

```bash
javac -d out src/hometheatre/subsystem/*.java src/hometheatre/facade/*.java src/hometheatre/config/*.java src/hometheatre/app/*.java
java -cp out hometheatre.app.Main
```

## Usage

```java
Facade theater = Configuration.createHomeTheater();
theater.watchMovie("The Truman Show");
theater.endMovie();
```

The client obtains a configured facade and does not create or call subsystem objects directly. Subsystems do not reference the facade and remain independently usable.

## Demonstration Scenarios

- Normal movie startup and shutdown.
- Empty movie title: startup fails and devices return to their shutdown state.
- Successful startup after a failed attempt.
- Repeated start: the request is rejected without interrupting the current session.
- Repeated end: an informational message is displayed.

Expected errors are caught and printed by `Main`.

## Clean Code

- **Single Responsibility:** the facade coordinates; each device manages its own behavior.
- **Encapsulation:** device state and facade dependencies are private.
- **Separation of Construction and Use:** `Configuration` handles object creation.
- **No Duplication:** normal shutdown and startup recovery share `shutDown()`.
- **Small Methods:** preparation is divided into focused methods.
- **Error Handling:** startup failures trigger cleanup and preserve the original exception cause.
# Live Football World Cup Scoreboard Simple Library

This project implements a simple library for managing a live football World Cup scoreboard. It demonstrates object-oriented design, SOLID principles, and follows a Test-Driven Development (TDD) approach. The project is developed using Java 17 and maven.

## Classes and Components

### Team

The `Team` class represents a football team. It has a single field `name`, which holds the team's name.

### Match

The `Match` class represents a football match. It is `Comparable` to enable sorting based on total scores and match id . It has fields for `id`, `homeTeam`, `awayTeam`, `homeScore`, and `awayScore`. The `updateScore` method updates the scores of the match.

### ScoreBoard

The `ScoreBoard` interface defines the contract for managing football matches. It includes methods to start a match, update scores, finish a match, and get a summary of live matches.

### FootballScoreBoard

The `FootballScoreBoard` class implements the `ScoreBoard` interface. It uses a map to store ongoing matches. It provides methods to start, update, finish matches, and get a summary of matches. Matches are sorted based on their `Comparable` ordering.

### FootballWorldCupScoreBoardDemo

The `FootballWorldCupScoreBoardDemo` class demonstrates the usage of the `FootballScoreBoard` library. It starts multiple matches, updates scores, prints the live scoreboard, and finishes matches.

## Design Decisions

- **Team**: The `Team` class is simple and encapsulates the concept of a team. It enforces a non-null team name.

- **Match**: The `Match` class is `Comparable` to allow sorting based on scores and id. It enforces non-null teams and a positive match id. Score updates are restricted to non-negative values.

- **ScoreBoard**: The `ScoreBoard` interface defines high-level operations for managing matches.

- **FootballScoreBoard**: The `FootballScoreBoard` class implements the `ScoreBoard` interface. It uses a map to manage ongoing matches efficiently. Matches are sorted using the `Comparable` for the scoreboard summary and return as a unmodifiable list to avoid making changes in the presentation layer.

## Usage

1. Clone the repository to your local machine:

        git clone https://github.com/meysamzamani/ScoreBoard.git

2. Compile the project using Java 17 or later.
3. Run the `FootballWorldCupScoreBoardDemo` class to see the live scoreboard in action.

## TDD Approach

The project follows a Test-Driven Development approach. Unit tests are provided for individual classes, ensuring their correctness and adherence to the specified requirements.

## Object-Oriented and SOLID Principles

The project adheres to object-oriented principles by using appropriate classes and interfaces to model real-world entities. The SOLID principles are followed to achieve modularity, maintainability, and extensibility.

## Java 17

The project is developed using Java 17, leveraging the latest features and enhancements of the Java programming language.

---

Author : Meysam Zamani
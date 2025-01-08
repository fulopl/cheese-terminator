# Cheese Terminator in the Dungeon - a Java/JavaFX sokoban-type offline game

<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ul>
    <li><a href="#what-is-cheese-terminator-in-the-dungeon">What is Cheese Terminator in the Dungeon?</a></li>
    <li><a href="#built-with">Built With</a></li>
    <li><a href="#main-features">Main features</a></li>
    <li><a href="#developer">Developer</a></li>
    <li><a href="#how-to-run-this-app">How to run this app?</a></li>
    <ol>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation-and-run">Installation and run</a></li>
        <li><a href="#stopping-the-application">Stopping the application</a></li>
    </ol>
    <li><a href="#how-to-use">How to use?</a></li>
  </ul>
</details>


## What is Cheese Terminator in the Dungeon?

CTD is a sokoban-type offline game, developed in Java using JavaFX for graphics. It's tribute remake of an old windows game 'Cheese Terminator' developed by Zsolt Krajcsik.

The Game uses classic Dungeon Crawl tile for visual experience. 

I also intended this Game to be a foundation for more complex dungeon games.


## Built with

[![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)](#)
[![Java](https://img.shields.io/badge/JavaFX-green?logo=openjdk&logoColor=white)](#)
[![Git](https://img.shields.io/badge/Git-F05032?logo=git&logoColor=fff)](#)
[![Spring Boot](https://img.shields.io/badge/IntelliJ_IDEA-darkblue?logo=intellijidea&logoColor=fff)](#)
[![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=fff)](#)

<br />

## Description

In this sokoban-like game players are to push every cheese to the mouse holes avoiding deadlocks. Once all cheeses are in the holes players proceed to the next level. The aim of the game is to complete all the levels.

![main2_70pc.png](./images/main2_70pc.png)

## Main features

- JavaFX UI
- Classic dungeon crawl tiles (32*32)
- Mouse movement control by keyboard
- Retry level and quit
- Game status display on status pane
- Welcome and victory screens
- Undo function (TODO)
- Postgres Database connection for saving game data (TODO)
- Users handling - Hall of fame (TODO) 
- Save game (TODO)
- New tiles, direction sensitive heading of the mouse (TODO)


![SstQuery2_70pc.png](./images/SstQuery2_70pc.png)

## Developer
- [Levente Fülöp](https://github.com/fulopl)

## How to run this app?

### Prerequisites
- Ensure the following are installed on your computer:
    - Git (https://git-scm.com/downloads)
    - Docker Desktop (https://www.docker.com/products/docker-desktop/)

### Installation and run
To set up the project locally:
1. Clone the github repo to your computer by typing the following command in the command shell:
```sh
   git clone https://github.com/fulopl/cheese-terminator 
   ```
2. Make sure Docker Desktop is running.
4. Build the application container and run the app by typing the command below (the build process may take some minutes):
```sh
   docker compose up
   ```

### Stopping the application
1. Stop the app by pressing Ctrl+C in the command shell
2. Remove the docker containers by entering "docker compose down" in the shell
```sh
   docker compose down
   ```

## How to use?
- You can use the app in a web browser at this URL: http://localhost:3000/
- You can use the "Sunrise & Sunset Times" feature after signing in.
- You can sign in with one of the existing users by selecting the "Sign in" tab:
    - Choose username "user0" to "user4" or log in with the user with admin rights: "admin"
    - The password is always the same as the username (ie. "user0" for user0, "admin" for admin etc.)

![SolarWatch_signin.png](./images/SolarWatch_signin_60pc.png)

- You can also register a new user:
    - Select the "Sign in" tab, and choosing "Register".
    - Then login with the username / password combination given by you in the previous step.


- Users can only use the "Sunrise & Sunset Times" feature after signing in.
  Here you can give a city name and a date to get sunrise and sunset times.
  By leaving the fields empty you will get the sunrise and sunset times for Budapest on the actual day in UTC time.

![SstResult_70pc.png](./images/SstResult_70pc.png)


- With admin rights you can access the "Edit users" tab, where you are able to give roles to users or delete them.

![Solarwatch_edit_users_67pc.png](./images/Solarwatch_edit_users_67pc.png)


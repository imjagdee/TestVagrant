# TestVagrant
The TestVagrant Store is a Java-based in-memory store that allows users to keep track of their recently played songs. It can accommodate a fixed number of songs per user and automatically removes the least recently played songs when the store becomes full.

## Usage
1. Include the `RecentlyPlayedStore.java` file in your Java project.

## Recently Played Songs Store - JUnit Tests 
# TestRecentlyPlayedStore
This repository contains JUnit test cases for the Recently Played Songs Store, an in-memory store that can accommodate N songs per user, with a fixed initial capacity. The store has the capability to store a list of song-user pairs, with each song linked to a user. It can also fetch recently played songs based on the user and eliminate the least recently played songs when the store becomes full.

## Requirements
- Java 8 or later
- Git
  

## cloning the Repo
Use the following command to clone this repository to your local machine:
1. git clone https://github.com/imjagdee/TestVagrant.git

## Test Cases
The JUnit test cases in this repository cover various scenarios to validate the functionality of the Recently Played Songs Store:
1. "testRecentlyPlayedSongs": Test adding and fetching recently played songs for a user.
2. "testEmptyRecentlyPlayedSongs": Test fetching recently played songs for a non-existent user (empty store).
3. "testAddingSameSongForDifferentUsers": Test adding the same song for different users.
4. "testCapacityExceeded": Test exceeding the store capacity and ensuring the least recently played songs are removed.
5. "testNonExistentUser" : Test fetching recently played songs for a non-existent user.

## Contributing
Contributions to the Recently Played Songs Store - JUnit Tests are welcome! If you find any issues or have improvements to suggest, please open an issue or submit a pull request.




# HexArchNoIOTests
Hexagonal arch + tests of application without IO + fast tests within memory repository

SpringBoot apps tend to depend on data stored in databases and we use Spring Repository interface to talk with their engines.

How to test your restapp with Spring Repository class without relying on actual datasource when you already use one?

That's how. Fast Unit Testing with Spock thanks to custom in-memory implementation of Spring Repository interface.

Inspired by: Jakub Nabrdalik's presentation https://www.youtube.com/watch?v=ILBX9fa9aJo

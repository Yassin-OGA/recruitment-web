# Java Recruitment Exercise

This Java exercise aims at your conceptional and problem solving skills in a real world
problem.

The goal of the exercise is to develop an application (java8 or greater) that manages some aspects
of a fictional library as detailed in the Business Logic bellow.

### Business Logic

```text
    The city of Townsville requires a new Library Management system to replace it's
    current paper based workflow.
    
    The library is attended by two groups of people - Student members and Resident members.
    Only Members can borrow books at the library.
    
    Pricing rules:
    
    Students are charged 10 cents a day (0.10 eu).
    Exception to that rule are students who are in their first year,
    who have 15 days of free period for each book.
    
    If a student, regardless of what year they are in, keeps a book
    for more than 30 days they are considered to be "late".
    
    Residents are allowed to borrow books for a period of 60 days and are
    charged 10 cents a day (0.10 eu) for each day they keep the book
    If a resident keeps a book for more than 60 days they are obliged 
    to pay 20 cents (0.20 eu) for each day after the initial 60 days and
    they are considered to be "late".
    
    If a member (student or resident) is late with their books they cannot 
    borrow any new books before returning the previous ones. 
```

### Requirements

* Time Requirements:

You can spend as much time as you like on the exercises but it should generally not take you more than
one afternoon. 

* Solution

Your solution should compile properly and all the unit tests included in the LibraryTest file should be green. 

* Sending the solution

Ideally you should fork the repository on github and create a branch with your name and send us the link to your repo

If you do not wish to use github, you can send your solution to our HR team via email
 
### Bonus
If you have finished the main exercise you can also implement a module architecture where the main logic is in module called "library-domain" and the repository is in another module called "library-infra".

You will also need something to run the code and provide dependency injection (Spring Boot for example, .NET Dependency Injection)

```
root/
    library-domain
    library-infra
```

### Hints

You should :

* Implement the required business logic
* Implement the unit tests in src/test/LibraryTest.java (TestProjectBook/UnitTestProjectBook.cs project if using .NET)
* Fix the code where it seems badly written or not respecting the programming language conventions
* Use modern APIs for your programming language where possible
* Avoid using heavy frameworks like Spring, unless you decide to implement the bonus part
* Be careful for pitfalls
* Do not bother implementing any logic for ISBN codes - they are completely fictional in our exercise
and serve only as identifiers for books
* Have fun :)


You may :

* Alter the existing code, but please follow the proposed code structure
* Add new code and features at your will
* Add more test cases where it seems logical to you
* Use design patterns to solve different problems

Happy Coding :) !

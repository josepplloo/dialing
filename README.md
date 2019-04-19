# Call Center
This is a call center simulator, in this 
business, there are three types of employees:
 
  - 👸🏾 Director: Answers the call if there is no supervisor available.
  - 👮🏾‍ Supervisor: Answers the call if there is no operator available.
  - 👨🏼‍🔧 Operator: Answers the call if available.

This example has an `App.CLASS` that allows 
a simple simulation.

# Project Setup.
This project has made using `Apache Maven 3.5.2` and
Java version: 11.

  > First of all install `maven` and `Java`.

  - Download this repo.
  - Build with `mvn clean package`
  - Run with `java -cp target/myCallCenter-1.0-SNAPSHOT.jar com.mycompany.app.App`
  - Build the docs: `mvn site`, next go to:
  `target/site/index.html` to watch the docs.
  - Also you can run the tests with: `mvn test`

# Project structure.
You can find the following structure for this project,
fell free to change the variables and navigate.

  > In this project, the test does not use seconds to make faster the bundle construction.


```
mycallcenter/
├── pom.xml
├── README.md
└── src /
    ├── main/java/com/mycompany/app/AppTest.java
    |
    └── main/java/com/mycompany/
        ├── app/
        |    ├── App.java
        |    └── Dispatcher.java
        └──  model/
             ├── Call.java
             ├── Director.java
             ├── Employee.java
             ├── Operator.java
             └── Supervisor.java
```

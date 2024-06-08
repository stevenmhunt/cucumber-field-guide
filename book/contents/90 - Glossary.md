# Glossary

> **{{Backend-for-Frontend}} ({{BFF}})** -
> A type of service in {{microservice}} architecture which provides endpoints for a frontend such as a web UI. It allows the UI to interact with a single service and forwards requests to the microservice(s).
>
> **{{Code Generator}}** -
> A software tool which can automatically generate source code as part of its operation. Code generators are particularly common in the {{C\#}} or {{.NET}} ecosystem with examples including the interactive form editors in {{Visual Studio}}, {{Entity Framework}} model first, and {{SpecFlow}} which converts {{Gherkin}} {{feature file}}s into {{C\#}} code for the target test runner.
>
> **{{Dependency Injection}}** -
> A design pattern in software development where the dependencies of a component are injected into it rather than it creating or managing the dependencies itself. This approach allows for loose coupling between components, making the code more modular, testable, and maintainable.
>
> **{{Domain-Specific Language}} (DSL)** -
> A programming language designed for a specific purpose or to solve a specific set of problems; as opposed to a general-purpose language such as *C++*, {{Java}}, etc.
>
> **{{Fail Fast}}** -
> A testing approach where you stop running tests as soon as a test fails instead of finishing the rest of the tests first, which provides a more rapid response (hence "fast") to {{CI/CD}} tools. The downside of this approach is that you'll lose information from any additional failures that may have occurred, so you will encounter those additional test failures one-at-a-time in future test runs instead of all at once.
>
> **Feature** -
> A set of functionality in your application. Example: "Customers can sign in to the online store."
>
> **{{Interface}}** -
> In statically typed languages such as {{Java}} and {{C\#}}, refers to an abstract type which acts as a contract by requiring specific methods to be present in any classes which claim to implement that type. This language feature allows for different implementations of the same interface to be interchangeable while allowing the compiler to properly enforce types.
>
> **{{Microservice}}** -
> A software architecture in which the service layer of your application consists of many small services which can intercommunicate. This approach is particularly useful in cloud-based applications since it allows each component of the application to scale separately based on resource demands.
>
> **{{Object Mapper}}** -
> A library which can handle serializing and deserializing data to and from objects in your programming language of choice. For example, *Jackson* can automatically convert between {{Java}} {{POJO}}s and {{JSON}} strings.
>
> **{{POJO}}** - An acronym for Plain Old Java Object, refers to a Java object which represents a data model of some kind.
>
> **{{Queue}}** -
> A messaging channel where messages are processed in First in, First out (FIFO) order. An individual message can only be received once.
>
> **Rule** -
> A grouping of scenarios within a feature, can be used for assigning {{Scenario Tag}}s.
>
> **Scenario** -
> A specific test, consisting of one or more steps, which can be used to validate that some part of a feature is either functioning or not.
>
> **Scenario Outline** -
> A set of tests which use the same steps, but with different parameter values. {{Gherkin}} allows for easily adding new test cases to an existing scenario outline, so you don't have to re-write (or even worse copy/paste!) repeating scenarios.
>
> **{{Singleton}}** -
> A design pattern in software development in which a component exists as single instance that can be accessed from anywhere within an application.
>
> **Step Definition** -
> A mapping between a human-readable Gherkin step in a scenario and a function which can execute the step. Steps can also contain parameters for reusability.
>
> **{{Topic}}** -
> A messaging channel which allows messages to be published and then distributed to one or more subscribers. An individual message can be sent to multiple receivers.

\pagebreak

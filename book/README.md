# The Cucumber Field Guide - Book Build Tools

## Description

Cucumber is an open-source tool that enables testers to write automated tests in plain language that can be executed to validate software behavior. With support across most major programming languages, Cucumber has become a popular tool for implementing behavior-driven development (BDD) and specification by example.

This book is a hands-on, technical guide that focuses on implementing automated tests with Cucumber. It contains many ideas, recommendations, and expert opinions on utilizing Cucumber to enhance software testing processes and improve the quality of software applications. Since all code examples provided in Ruby, Java, and JavaScript, readers will find solutions to various testing challenges across different development environments.

## Software Prerequisites

- bash
- [Make](https://www.gnu.org/software/make/)
- [Pandoc](https://pandoc.org/)
- [pdflatex](https://www.math.rug.nl/~trentelman/jacob/pdflatex/pdflatex.html)
- [NodeJS/NPM](https://nodejs.org)
- [Java](https://java.com)
- [Python](https://www.python.org/)
- [Ruby](https://www.ruby-lang.org/en/)
- [Groovy](https://groovy.apache.org/download.html)
- [Yamllint](https://yamllint.readthedocs.io/en/stable/): `pip install --user yamllint`
- [Rubocop](https://github.com/rubocop/rubocop): `gem install rubocop`

Add `GROOVY_HOME=/usr/share/groovy/` to environment variables.

## Building a PDF

Run `make` to generate the .tex file and then create a PDF of *The Cucumber Field Guide*. After building, the PDF will be located at `./build/book.pdf`. You may need to run `make` twice in order to ensure all indices and cross-references are up-to-date, or run `make pdf-final` to run everything twice automatically.

## Graphics and Fonts

- Cover Page Font: DejaVu Sans
- Book Font: Latin Modern Roman, Latin Modern Mono
- Cover Page Graphic: Cucumber plant by Creazilla^[https://creazilla.com/media/clipart/11987/cucumber-plant]^[https://creazilla.com/media/clipart/11988/cucumber-plant]
- Header Icons: Tabler Icons^[https://icon-icons.com/users/wtNmokBMlY0Ee6C38dO9v/icon-sets/]
- Figure Graphics: created by Steven Hunt
- All graphics modifications were made using Pinta^[https://www.pinta-project.com/]

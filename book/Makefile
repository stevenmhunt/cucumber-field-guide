LINT_DIR=./build/lint
LIB_DIR=./build/lib

ifeq ($(OS),Windows_NT)
    CLASSPATH_SEPARATOR = ;
else
    CLASSPATH_SEPARATOR = :
endif

build: index

clean:
	rm -r ./build

install-node-dependencies:
	@if [ ! -d "node_modules" ]; then \
		echo "node_modules directory not found. Running npm install..."; \
		npm install; \
	else \
		echo "node_modules directory exists. Skipping npm install."; \
	fi

CHECKSTYLE_VERSION=checkstyle-10.13.0
CHECKSTYLE_JAR=$(CHECKSTYLE_VERSION)-all.jar
CHECKSTYLE_URL=https://github.com/checkstyle/checkstyle/releases/download/$(CHECKSTYLE_VERSION)/$(CHECKSTYLE_JAR)

CODENARC_VERSION=3.4.0
CODENARC_GROOVY_VERSION=groovy-4.0
CODENARC_JAR=CodeNarc-$(CODENARC_VERSION)-$(CODENARC_GROOVY_VERSION).jar
CODENARC_URL=https://github.com/CodeNarc/CodeNarc/releases/download/v$(CODENARC_VERSION)/$(CODENARC_JAR)

install-checkstyle:
	@if [ ! -f "$(LIB_DIR)/$(CHECKSTYLE_JAR)" ]; then \
		echo "Downloading Checkstyle $(CHECKSTYLE_JAR)..."; \
		mkdir -p $(LIB_DIR); \
		curl -L $(CHECKSTYLE_URL) -o $(LIB_DIR)/$(CHECKSTYLE_JAR); \
	else \
		echo "Checkstyle $(CHECKSTYLE_JAR) already exists."; \
	fi

install-codenarc:
	@if [ ! -f "$(LIB_DIR)/$(CODENARC_JAR)" ]; then \
		echo "Downloading Codenarc $(CODENARC_JAR)..."; \
		mkdir -p $(LIB_DIR); \
		curl -L $(CODENARC_URL) -o $(LIB_DIR)/$(CODENARC_JAR); \
	else \
		echo "Codenarc $(CODENARC_JAR) already exists."; \
	fi

lint: lint-markdown lint-ruby lint-java lint-javascript lint-groovy lint-json lint-xml
	@echo "completed code linting."

lint-markdown: install-node-dependencies
	./node_modules/.bin/markdownlint contents/*

lint-java: install-checkstyle lint-extract
	java -jar $(LIB_DIR)/$(CHECKSTYLE_JAR) -c ./config/checkstyle.xml $(LINT_DIR)/java

lint-javascript: install-node-dependencies lint-extract
	./node_modules/.bin/eslint $(LINT_DIR)/javascript/*.js --config ./config/eslint-js.json

lint-json: install-node-dependencies lint-extract
	@for jsonfile in $(LINT_DIR)/json/*.json; do \
		echo "Linting $$jsonfile..."; \
		./node_modules/.bin/jsonlint "$$jsonfile" -q || exit 1; \
	done

lint-ruby: lint-extract
	rubocop $(LINT_DIR)/ruby/*.rb --config ./config/rubocop.yml

lint-typescript: install-node-dependencies lint-extract
	./node_modules/.bin/eslint $(LINT_DIR)/typescript/*.ts --ext .ts,.tsx --config ./config/eslint-ts.json

lint-groovy: install-codenarc lint-extract
	java -classpath "$(LIB_DIR)/$(CODENARC_JAR)$(CLASSPATH_SEPARATOR)$(GROOVY_HOME)lib/*" org.codenarc.CodeNarc \
	-report=console \
	-rulesetfiles="file:./config/codenarc.ruleset.groovy" \
	-includes=$(LINT_DIR)/groovy/*.groovy

# run optionally.
lint-gherkin: install-node-dependencies lint-extract
	./node_modules/.bin/gherkin-lint $(LINT_DIR)/gherkin/*.feature -c ./config/gherkinlint.json

# run optionally.
lint-xml: lint-extract
	xmllint --noout $(LINT_DIR)/xml/*.xml

# run optionally.
lint-yaml: lint-extract
	yamllint $(LINT_DIR)/yaml/*.yaml

lint-extract:
	chmod +x code-lint.sh && ./code-lint.sh

tex: lint-markdown
	chmod +x build.sh && ./build.sh

pdf: tex
	cd ./build && pdflatex book.tex

index: pdf
	cd ./build && makeindex book.idx

pdf-final: index
	cd ./build && pdflatex book.tex

.PHONY: build tex
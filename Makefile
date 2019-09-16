artifact_name  := pipeline-demo-app
commit         := $(shell git rev-parse --short HEAD)
tag            := $(shell git tag -l 'v*-rc*' --points-at HEAD)
version        := $(shell if [[ -n "$(tag)" ]]; then echo $(tag) | sed 's/^v//'; else echo $(commit); fi)

.PHONY: all
all: build

.PHONY: clean
clean:
	mvn clean
	rm -f *.zip
	rm -rf build-*
	rm -f build.log
	rm -f *.jar

.PHONY: test
test: test-unit

.PHONY: test-unit
test-unit:
	mvn test

.PHONY: build
build:
	mvn package
	mv ./target/$(artifact_name).jar ./$(artifact_name).jar

.PHONY: package
package:
	$(eval tmpdir:=$(shell mktemp -d build-XXXXXXXXXX))
	cp ./$(artifact_name).jar $(tmpdir)
	cp ./start.sh $(tmpdir)
	cd $(tmpdir) && zip ../$(artifact_name)-$(version).zip *
	rm -rf $(tmpdir)

.PHONY: dist
dist: clean build package

.PHONY: sonar
sonar:
	mvn sonar:sonar

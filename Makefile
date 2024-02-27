MAIN=Main
BUILD_DIR=target
SRC_DIR=src

.PHONY: build run

run: build
	java --class-path $(BUILD_DIR) $(MAIN)\

build:
	javac -d $(BUILD_DIR) $(SRC_DIR)/*.java
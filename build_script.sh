#!/bin/bash
# Script to build a RHEV-M portable/executable JAR

cd src/
echo "Main-Class: rhevm/MainView" > manifest.txt
javac rhevm/MainView.java
jar cvfm rhevm.jar manifest.txt rhevm/*.class
mv rhevm.jar ../
rm manifest.txt
rm rhevm/*.class

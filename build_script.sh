#!/bin/bash
# Script to build a RHEV-M portable/executable JAR
echo "[rhevm-java] Building latest local code"
cd src/
echo "Main-Class: rhevm/MainView" > manifest.txt
javac rhevm/MainView.java
jar cvfm rhevm.jar manifest.txt rhevm/*.class
mv rhevm.jar ../
rm manifest.txt
rm rhevm/*.class
echo "[rhevm-java] SUCCESS: rhevm.jar created"
echo -e "[rhevm-java] Run \"java -jar rhevm.jar\" to execute" 

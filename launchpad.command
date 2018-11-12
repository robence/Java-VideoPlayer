#!/bin/bash

mvn clean package

BASEDIR=$(dirname $0)
java -cp $BASEDIR/target/video-player-1.0-SNAPSHOT.jar com.robence.videoplayer.Main

read -p "Press [Enter] key to close"
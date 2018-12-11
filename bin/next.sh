#!/usr/bin/env bash

set -x

PASTED=`pbpaste`

LEVEL=`echo $PASTED | cut -d'/' -f7`

NUMBER=`echo $PASTED | cut -d'/' -f6`

CLASSNAME=${LEVEL}_${NUMBER}

cat << EOF > /Users/lukasz/dev/github/algo/src/main/scala/misc/${CLASSNAME}.scala
import scala.io.StdIn._

object $CLASSNAME extends App {
  val str = readLine()
}
EOF

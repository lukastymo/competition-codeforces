#!/usr/bin/env bash

# Copy the URL and run ./next
# or
# Copy the URL in Google Chrome and press CMD + OPTION + CTRL + C (Alfred automatization)

set -x

PASTED=`pbpaste`

LEVEL=`echo $PASTED | cut -d'/' -f7`

NUMBER=`echo $PASTED | cut -d'/' -f5`

CLASSNAME=${LEVEL}_${NUMBER}

cat << EOF > /Users/lukasz/dev/github/algo/src/main/scala/${CLASSNAME}.scala
import scala.io.StdIn._

object $CLASSNAME extends App {
  readLine()
}
EOF

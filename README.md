# CodeComp
## Overview
CodeComp is envisioned as a system to aid instructors in detecting inappropriate copying of programming code.

A variety of such programs already exist, including MOSS and JPlag.

Although useful, these existing tools have three significant drawbacks.

* They are available only as web services on academic sites, and so could disappear at any time if their project head retires, loses interest, etc.
* They lack a facility for evaluating the statistical significant of their own results.
* These tools can report which pairs of programs are most similar to one another, but cannot indicate whether the significance is beyond the realm of statistical plausibility.

Perhaps most significantly, these existing tools cannot distinguish between code written by students and code provided to all students by the instructor or copied from a textbook or lecture notes.

This project seeks to develop a code comparison tool that can determine when a pair of programs share distinctive phrases of a length unlikely to occur by simple chance.

## Usage
#### java -jar CodeComp.jar [Options] [assignmentDirectory] [outputSpreadsheet]
* [Options] is explained in the next section.
* The [assignmentDirectory] is a path to the root directory of the assignment containing a number of submission directories.
* The [outputSpreadsheet] is a path to where the output (an Excel spreadsheet) should be stored.

## Options
#### -template templateSpreadSheet
* Replaces the default spreadsheet template with one specified by the user.

#### -raw sheetname
* Replaces the sheet name used to identify where to place the raw scores (default is "RawScores").

## Additional Command
java -jar CodeComp.jar -help"
* Prints a summary of the command line parameters.
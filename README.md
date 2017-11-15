CastleCount
===========

#### Java Application Demo

Returns the number of castles to build depending on the number of peaks
and valleys in a stretch of land (defined by an array of integers).
 
These are the rules determining the count:
 
 - always build a castle at the start of the array, provided it is non-empty.
 - build one castle per peak or valley.
 - A peak is an integer or series of integers that is above the immediately preceding and following
   integers. For example, in the sequence [2,6,6,6,3] the sequence of 3 6s is a peak.
 - A valley is an integer or series of integers that is below the immediately preceding and
   following integers. For example, in the sequence [6,1,4] the "1" would be a valley.
   
How to run:

Install JDK SE 8 or later http://www.oracle.com/technetwork/java/javase/downloads/index.html

Run from a command prompt to build:

```
$ javac CastleCount.java
```
	
Then run:

```
$ java CastleCount 2,6,6,6,3
```

The parameter should be a string of comma separated integers.	
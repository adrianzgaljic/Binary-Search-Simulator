###Binary Search Simulator
This is Java application which shows step by step how binary search algorithm works.
Binary search algorithm is used to find the element in a sorted array.
It has worst-case complexity of O(log(n)).



Example of simulation:

```
Input list of elements divided by space. Eg. "3 8 1 17":
1 2 3 8 17 21 7 6 99 12 15
Input element you want to find:
2
 1  2  3  6  7  8  12  15  17  21  99 
 ^              ^                  ^ 
 |              |                  | 
 l             mid                 h 

 1  2  3  6  7  8  12  15  17  21  99 
 ^     ^        ^ 
 |     |        | 
 l    mid       h 

 1  2  3  6  7  8  12  15  17  21  99 
 ^  ^  ^ 
 |  |  | 
 l mid h 

Found: 2
Worst-case complexity log(n): 3.4594316186372978
No of iterations: 3
```

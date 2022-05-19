case 1 word1 is "" / word2 is "abc" so we insert 3 times   
case 2 word1 is "abc" / word2 is "" so we delete 3 times
case 3 word1 is "abc" / word2 is "adc" so we try to get LCS for both words since a=a we solve bc / dc  
we have 3 ways either remove b and solve c & dc we insert d and solve bc & c or replace and solve c & c

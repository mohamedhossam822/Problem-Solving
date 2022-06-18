# Check it again
### Easy
* [Counting Bits](https://github.com/mohamedhossam822/Problem-Solving/tree/main/338-counting-bits) (DP/Bit manipulation)
### Medium
* [Subarray Sum Equals K](https://github.com/mohamedhossam822/Problem-Solving/tree/main/560-subarray-sum-equals-k) (Prefix-sum / Hashtable)
* [Partition Labels](https://github.com/mohamedhossam822/Problem-Solving/tree/main/763-partition-labels) (LinkedHashMap / DP / Sliding window)
* [Best Sightseeing Pair](https://github.com/mohamedhossam822/Problem-Solving/tree/main/1014-best-sightseeing-pair) (DP / Math / Maximize parts of the equation)
* [Word Break](https://github.com/mohamedhossam822/Problem-Solving/tree/main/139-word-break) (DP / Hashing / Decision)
* [Best Time to Buy and Sell Stock with Cooldown](https://github.com/mohamedhossam822/Problem-Solving/tree/main/309-best-time-to-buy-and-sell-stock-with-cooldown) (DP/State Machines/memoization) (Very Important)
* [Construct Binary Tree from Preorder and Inorder Traversal](https://github.com/mohamedhossam822/Problem-Solving/tree/main/105-construct-binary-tree-from-preorder-and-inorder-traversal) (Trees/recursion)
* [Matrix Block Sum](https://github.com/mohamedhossam822/Problem-Solving/tree/main/1314-matrix-block-sum) (Prefix sum/Sliding window / DP/ matrix)
* [Longest Palindromic Substring](https://github.com/mohamedhossam822/Problem-Solving/tree/main/5-longest-palindromic-substring) (String / DP)
* [Longest Palindromic Subsequence](https://github.com/mohamedhossam822/Problem-Solving/tree/main/516-longest-palindromic-subsequence) (String / DP)
* [Coin Change](https://github.com/mohamedhossam822/Problem-Solving/blob/main/322-coin-change/322-coin-change.java) (DP/ Caching)
* [Coin Change 2](https://github.com/mohamedhossam822/Problem-Solving/tree/main/518-coin-change-2) (DP/ Caching) (Very Important)
* [Longest Consecutive Sequence](https://github.com/mohamedhossam822/Problem-Solving/tree/main/128-longest-consecutive-sequence) (hash / new idea)
* [Longest Repeating Character Replacement](https://github.com/mohamedhossam822/Problem-Solving/tree/main/424-longest-repeating-character-replacement) (Sliding window / hash)
* [Shuffle an Array](https://github.com/mohamedhossam822/Problem-Solving/tree/main/384-shuffle-an-array)[Math/ Fisher–Yates shuffle]
* [Bitwise AND of Numbers Range](https://github.com/mohamedhossam822/Problem-Solving/tree/main/201-bitwise-and-of-numbers-range)[Bit manipulation]
* [Water and Jug Problem](https://leetcode.com/problems/water-and-jug-problem/) [Math/Bézout's identity]
* [Possible Bipartition](https://github.com/mohamedhossam822/Problem-Solving/tree/main/886-possible-bipartition) [Graphs / Bipartition]

 ### Hard
* [Design Add and Search Words Data Structure](https://github.com/mohamedhossam822/Problem-Solving/tree/main/211-design-add-and-search-words-data-structure) (Tries/ Backtracking / DFS)
* [Russian Doll Envelopes](https://github.com/mohamedhossam822/Problem-Solving/tree/main/354-russian-doll-envelopes)(DP/ Caching) (Very Important)
* [Concatenated words](https://github.com/mohamedhossam822/Problem-Solving/tree/main/472-concatenated-words)(String/hashing/Caching/Dp)
* [Shortest Path Visiting All Nodes](https://github.com/mohamedhossam822/Problem-Solving/tree/main/847-shortest-path-visiting-all-nodes)(BFS/ DP/ Bit Masking) (Very Important)
* [Binary Tree Cameras](https://github.com/mohamedhossam822/Problem-Solving/tree/main/968-binary-tree-cameras) (Trees/greedy/dfs/DP)
* [Prefix and Suffix Search](https://github.com/mohamedhossam822/Problem-Solving/tree/main/745-prefix-and-suffix-search) (Tries)

# Tips & Patterns
### LinkedList
* Most of time the difficulty of these problem will be to try to optimize the space complexity or to solve in one loop
* Floyd's Tortoise and Hare Algorithm (Cycle Detection) is particularly useful here
* Drawin a pictur can be really helpful what should point to what exactly ? 
* Saving a prev Node can helop ease up reconstructing the links 
### Trees
* Ask yourself is the tree a perfect tree , binary search tree or just a regular tree ?
* For binary search trees : Inorder traversal & Preorder traversal can be a way to solve a lot of problems also level traversal
### Heaps/ Priority queue
* Kth largest/smallest element
   * Kth smallest element -> Maintain a Max Heap and then pop the element O(k) space & vice versa*
* Kth closet points to point (x,y) 
   * Same concept can be used with dijkstra to get min path

### Graphs
* BFS & DFS are your best friends
* Creating an Adjacency Matrix or Adjacency List can be helpful and the latter will be used more than often.
* A* can be useful if you want to get the min distance from 4 points to point x (you only need 1 point).
* Take care if the graph is directed or undirected(helps in making the list)
* Bipartition is when you want to divide some nodes in a graph into 2 sets where there are no cycles between odd number of nodes(think of colouring)
### BFS
* Mostly used when getting min path from point A to all points in a graph
* Use a table with min distances & updated it on finding a smaller value
* Uses queue data structure / A Point is visited when its popped from the queue
* If you use Priority queue then node is visited and has the min path when popped (dijkstra algorthim)
* O(|V|+|E|) time complexity where V number of vertices / E number of edges
### DFS
* Brute force Algorthim : O(|V|+|E|) time complexity where V number of vertices / E number of edges
* Can be used when populating an are with a different value 
* Not every 2D matrix has to be traversed from (0,0) can we approach the problem from a different point and start populating
### Backtracking 
* Brute force Algorthim : O(n!) Hamiltonian Cycle or O(2^n)
* O(2^n) when a problem is solved by dividing it into 2 (n-1) problems T(n)=0(1)+2T(n-1)
* No duplicates ? think about a hashtable to save the points you used while traversing down the tree.
* Don't use the same element twice ? make an index and travers the next level from index +1
* Don't want to travers the same path twice ? HashSet and save the points you already visited in the function (Horizontally)/ also sorting and comparing with previous element can be helpful
* **Very Important**: Draw A **State Space Tree** and write the resultant lists/arrays not the sum/the stopping condition (Also helpful for Memoization/Caching) 
### Dynamic Programming
* The Key is finding the subproblem is it a list that If I get to it I will repeat some computaions I made ? or is that an index in array or 2d array ?
* Top-down Approach
   * Let's say I want to find the min jumps I can make to to reach the end common way is if we start at index 0 compute the min between index 1 & 2 and add it to 0 and so recursively.
   * What if I start from the end ? this will often lead to iterative approach & may reduce the space complexity to O(1) since most times you just need the last 2 element to compare.
* Bottom-up Approach  
   *  Most of the time this will happen when u want to solve a problem of n.
   *  Lets say you want to get all the possible values that sum to n from array nums.
   *  Ok what if we get the solution for DP[O] and DP[1] first wouldn't that give us the solution for DP[2]=DP[1]+DP[1]
   *  And then from that I can get DP[3]=DP[2]+DP[1] I don't need DP[1]+DP[1]+DP[1] since DP[2] already computed D[1]+DP[1] for use.
   *  And then we work our way up till we reach DP[N]
* Both Top-down & Bottom-up will often lead from recursive approach to Iterative approach
* 2D Dynamic programming is often a DFS But you save the values in an other grid so you  walk 0-0 0-1 1-1 1-2 ... and then walk 0-0 1-0 1-1 oh wait didn't I walk from 1-1 before ? 
### Bit manipulation
* AND operation between 2 numbers will always result in a lesser Number (12 & 11 = 8 )
### Math
* For a slope starting from x1,y1 it determines how many points lie on that line slope=(y2-y1/x2-x1) (care for Divison by zero!)
* Bézout's identity

# Useful Resources
* [14 Pattern to ace the Coding Interview](https://hackernoon.com/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed)

# Two Pointers



Two pointers 是一种实现技巧

可以是index 也可以是multiple pointers

常用于Array, String, 和linkedlist上面

sliding windows的题目也用的这个实现技巧

1. 头尾对撞型双指针

- 通过判断条件优化算法 containers with most water, 3sum
- Partition类 比如sort colors 三个指针 left index and right, valid palindrome



2. 前向行双指针

都在头

- Sliding Window ：慢指针正常遍历 快指针通过条件移动
- 快慢指针找中间
- moveZero 慢指针存第一个0 然后swap
- remove dup from sort array in place 用一个update指针来更新
- remove element 专门用一个更新指针

3. 两个数组 并行双指针

    Backspace 并行从后往前扫

   isSubsequence

   merge two sorted array, 从后面扫

   swap LR 先找出数学规律
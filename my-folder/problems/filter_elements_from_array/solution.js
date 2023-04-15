#{"data":{"question":{"content":"Write code that enhances all arrays such that you can call the&nbsp;<code>array.last()</code>&nbsp;method on any array and it will return the last element. If there are no elements in the array, it should return&nbsp;<code>-1</code>.\n<p>&nbsp;</p>\n<p><strong class=\"example\">Example 1:</strong></p>\n\n<pre>\n<strong>Input:</strong> nums = [1,2,3]\n<strong>Output:</strong> 3\n<strong>Explanation:</strong> Calling nums.last() should return the last element: 3.\n</pre>\n\n<p><strong class=\"example\">Example 2:</strong></p>\n\n<pre>\n<strong>Input:</strong> nums = []\n<strong>Output:</strong> -1\n<strong>Explanation:</strong> Because there are no elements, return -1.\n</pre>\n\n<p>&nbsp;</p>\n<p><strong>Constraints:</strong></p>\n\n<ul>\n\t<li><code>0 &lt;= arr.length &lt;= 1000</code></li>\n\t<li><code>0 &lt;= arr[i] &lt;= 1000</code></li>\n</ul>\n","mysqlSchemas":[]}}}
/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    let ans = [];
    for(i=0;i<arr.length;i++){
        if(fn(arr[i], i))
            ans.push(arr[i]);
    }
    return ans;
};
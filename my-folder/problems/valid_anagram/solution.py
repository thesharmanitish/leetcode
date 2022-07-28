class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        return all(s.count(x) == t.count(x) for x in 'abcdefghijklmnopqrstuvwxzy')
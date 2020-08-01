class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        memo = {}
        return self.search(s, wordDict, memo)

    def search(self, s, wordDict, memo):
        if s in memo:
            return memo[s]
        # Base case
        res = []
        if not s:
            res.append("")
            return res
        for word in wordDict:
            if s.startswith(word):
                rest = s[len(word):]
                subStrings = self.search(rest, wordDict, memo)

                for subString in subStrings:
                    optSpace = "" if not subString else " "
                    res.append(word + optSpace + subString)
        memo[s] = res
        return res
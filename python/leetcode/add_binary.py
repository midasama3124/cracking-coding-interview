class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        length = max(len(a), len(b))
        compl = 0
        res = ""
        for i in range(1, length + 1):
            sum_a = 0 if i > len(a) else int(a[-i])
            sum_b = 0 if i > len(b) else int(b[-i])
            _sum = sum_a + sum_b + compl
            compl = 1 if _sum > 1 else 0
            res += str(_sum % 2)
        if compl: res += str(compl)
        return res[::-1]
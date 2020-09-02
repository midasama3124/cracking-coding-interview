class Trie:
    def __init__(self):
        self.children = [None] * 26
        self.isWord = False

    def insert(self, s):
        t = self
        for c in s:
            if not t.children[ord(c) - ord('a')]:
                t.children[ord(c) - ord('a')] = Trie()
            t = t.children[ord(c) - ord('a')]
        t.isWord = True

    def search(self, queries):
        t = self
        for c in queries:
            if  not t.children[ord(c) - ord('a')]: return False
            t = t.children[ord(c) - ord('a')]
            if t.isWord: return True
        return False

class StreamChecker(object):

    def __init__(self, words):
        """
        :type words: List[str]
        """
        self.trie = Trie()
        for s in words:
            self.trie.insert(s[::-1])
        self.queries = collections.deque()

    def query(self, letter):
        """
        :type letter: str
        :rtype: bool
        """
        self.queries.appendleft(letter)
        return self.trie.search(self.queries)
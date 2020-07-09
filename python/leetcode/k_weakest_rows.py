class Solution:
  def __init__(self):
      mat = [[1, 1, 0, 0, 0],
        [1, 1, 1, 1, 0],
        [1, 0, 0, 0, 0],
        [1, 1, 0, 0, 0],
        [1, 1, 1, 1, 1]]
      k = 3
      weakest = self.kWeakestRows(mat, k)
      print weakest

  def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
    soldier_count = []
    result = []
    for people in range(len(mat)):
      soldier_count.append(sum(mat[people]))
    weakest = dict(zip((range(len(soldier_count))),soldier_count))
    sort_weakest = sorted(weakest.items(), key=lambda x: x[1])
    for i in range(k):
      result.append(sort_weakest[i][0])
    return result

def main():
    sol = Solution()
    
if __name__ == '__main__':
    main()
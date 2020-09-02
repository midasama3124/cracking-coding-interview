class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        def spiralHelper(firstRow, lastRow, firstCol, lastCol):
            # First row
            for j in range(firstCol, lastCol + 1):
                yield firstRow, j
            # Last col
            for i in range(firstRow + 1, lastRow + 1):
                yield i, lastCol
            if firstRow < lastRow and firstCol < lastCol:
                # Last row
                for j in range(lastCol - 1, firstCol, -1):
                    yield lastRow, j
                # First col
                for i in range(lastRow, firstRow, -1):
                    yield i, firstCol

        res = []
        if not matrix: return res
        firstRow, lastRow = 0, len(matrix) - 1
        firstCol, lastCol = 0, len(matrix[0]) - 1
        while firstCol <= lastCol and firstRow <= lastRow:
            for i, j in spiralHelper(firstRow, lastRow, firstCol, lastCol):
                res.append(matrix[i][j])
            firstRow += 1
            lastRow -= 1
            firstCol += 1
            lastCol -= 1
        return res
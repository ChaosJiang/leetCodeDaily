#
# @lc app=leetcode id=767 lang=python3
#
# [767] Reorganize String
#
from collections import Counter
from heapq import heappop, heappush


def reorganizeString(s: str) -> str:
    count = Counter(s)

    heap = []
    for char, freq in count.items():
        heappush(heap, (-freq, char))

    if -heap[0][0] > (len(s) + 1) // 2:
        return ""

    result = []
    while len(heap) >= 2:
        freq1, char1 = heappop(heap)
        freq2, char2 = heappop(heap)

        result.extend([char1, char2])
        freq1 += 1  # Remember count1 is negative
        freq2 += 1
        if freq1 < 0:
            heappush(heap, (freq1, char1))
        if freq2 < 0:
            heappush(heap, (freq2, char2))

    if heap:
        count, char = heappop(heap)
        result.append(char)

    return "".join(result)


if __name__ == "__main__":
    # Test case1
    print(reorganizeString("aab"))
    # Test case2
    print(reorganizeString("aaab"))

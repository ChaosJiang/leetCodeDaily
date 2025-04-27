package main

import (
	"container/heap"
	"fmt"
	"strings"
)

// Item represents an item in the priority queue (max-heap).
type Item struct {
	char rune
	freq int
}

// PriorityQueue implements heap.Interface and holds Items.
type PriorityQueue []*Item

func (pq PriorityQueue) Len() int { return len(pq) }

func (pq PriorityQueue) Less(i, j int) bool {
	// We want Pop to give us the highest frequency, so we use > here.
	return pq[i].freq > pq[j].freq
}

func (pq PriorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *PriorityQueue) Push(x any) {
	item := x.(*Item)
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() any {
	old := *pq
	n := len(old)
	item := old[n-1]
	old[n-1] = nil // avoid memory leak
	*pq = old[0 : n-1]
	return item
}

func reorganizeString(s string) string {
	counts := make(map[rune]int)
	for _, char := range s {
		counts[char]++
	}

	pq := &PriorityQueue{}
	heap.Init(pq)
	n := len(s)

	for char, freq := range counts {
		if freq > (n+1)/2 {
			return ""
		}
		heap.Push(pq, &Item{char: char, freq: freq})
	}

	var result strings.Builder

	for pq.Len() >= 2 {
		item1 := heap.Pop(pq).(*Item)
		item2 := heap.Pop(pq).(*Item)

		result.WriteRune(item1.char)
		result.WriteRune(item2.char)

		item1.freq--
		item2.freq--

		if item1.freq > 0 {
			heap.Push(pq, item1)
		}
		if item2.freq > 0 {
			heap.Push(pq, item2)
		}
	}

	if pq.Len() > 0 {
		item := heap.Pop(pq).(*Item)
		result.WriteRune(item.char)
	}

	return result.String()
}

func main() {
	// Test case 1
	fmt.Println(reorganizeString("aab")) // Expected: "aba"
	// Test case 2
	fmt.Println(reorganizeString("aaab")) // Expected: ""
}

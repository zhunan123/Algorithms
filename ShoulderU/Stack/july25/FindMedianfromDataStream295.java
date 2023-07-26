package ShoulderU.Stack.july25;

import java.util.PriorityQueue;

public class FindMedianfromDataStream295 {

  /**
   create a min heap and a max heap, maxheap is the left first half of the int array, will have all element smaller then the top, min heap is the right half of the sequenmces, will have right second half all elements greater then the top.
   so when we add the element, if size of left half max heap is 1 more element greater then the right half minheap, then it is ok. if the size of left half maxHeap is 2 more element greater than right half min heap, in this case we need to balance our heap, then it means too much elements in the maxheap, we need to pop it from maxheap and add to minheap,
   then compare the next element with top of heap, if smaller then max heap top, add to left half maxheap, if greater then minheap top add to right half min heap, but the thing is size of minheap will need to be smaller than maxheap, if size of mminheap is greater than the size of maxheap, we need to pop the minheap and add to maxheap. when taking the medium, if it is odd size of sequence, we just take the top of maxheap, but if it is even number of sequence, we need to pop top of maxheap and min heap and take the average of the two number

   https://www.youtube.com/watch?v=JNKdfHmnMSg&ab_channel=EricProgramming

   // idea: have a maxheap and minhea，把所有的数字分成两半，第一半放在左侧maxheap中，第二半放在右侧minheap中,
   leftside maxheap, rightside minheap, for addNum, first size++,
   is maxheap empty or num < maxheap add to maxheap else add to minheap, if max heap has 2 more num than minheap,
   poll maxheap and add to minheap, else then if minheap has more size than maxheap, poll minheap and add to minheap
   // for findmedian, if size is odd, than return maxheap top, if is odd, peek both minheap and maxheap and calculate the medium
   */

  // initialize the minheap and maxheap, offer(), poll(), peek(), size(), isEmpty()
  PriorityQueue<Integer> minheap = new PriorityQueue<>();
  PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b - a);
  // initialize the size to keep track how many element that we added into data structure.
  int size = 0;

  public FindMedianfromDataStream295() {

  }

  public void addNum(int num) {
    size++; // first increment the size
    // first compare see should add into maxheap or minheap
    // if maxheap is empty on the first pass add to maxheap
    if (maxheap.isEmpty() || num <= maxheap.peek()) {
      maxheap.offer(num);
    } else {
      minheap.offer(num);
    }

    // balance the heap
    // handle case when the size of left half maxHeap is 2 more element greater than right half min heap
    //  we need to pop it from maxheap and add to minheap
    if (maxheap.size() > minheap.size() + 1) {
      minheap.offer(maxheap.poll());
    } else {
      // minheap size should be smaller than maxheap
      // handle the case when minheap size is larger than the maxheap size.
      // pop minheap and offer to the max heap
      if (minheap.size() > maxheap.size()) {
        maxheap.offer(minheap.poll());
      }
    }


  }

  public double findMedian() {
    if (size % 2 == 0) {
      // even, peek top of maxheap and min heap and take the average of the two number
      return (double) (maxheap.peek() + minheap.peek()) / 2;
    } else {
      // odd number so, just pop the maxheap
      return (double) maxheap.peek();
    }
  }
}

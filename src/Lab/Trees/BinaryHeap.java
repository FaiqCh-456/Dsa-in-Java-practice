package Lab.Trees;

public class BinaryHeap {
  int arr[];
  int sizeOfTree;

  public BinaryHeap(int size) {
    arr = new int[size+1];
    this.sizeOfTree = 0;
    System.out.println("Binary Heap has been created");
  }

  public boolean isEmpty() {
    return sizeOfTree == 0;
  }

  public Integer peek() {
    if (isEmpty()) {
      System.out.println("Binary Heap is Empty");
      return null;
    }
    return arr[1];
  }

  public int sizeOfBP() {
    return sizeOfTree;
  }

  public void levelOrder() {
    for (int i = 1; i <= sizeOfTree; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("\n");
  }

  // Heapify for Insert
  public void heapifyBottomToTop(int index, String heapType) {
    int parent = index / 2;
    if (index <= 1) {
      return;
    }
    if (heapType.equals("Min")) {
      if (arr[index] < arr[parent]) {
        int tmp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = tmp;
      }
    } else if (heapType.equals("Max")) {
      if (arr[index] > arr[parent]) {
        int tmp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = tmp;
      }
    }
    heapifyBottomToTop(parent, heapType);
  }

  public void insert(int value, String typeHeap) {
    arr[sizeOfTree+1] = value;
    sizeOfTree++;
    heapifyBottomToTop(sizeOfTree, typeHeap);
    System.out.println("Inserted " + value + " successfully in Heap");
  }

  // heapifyTopToBottom
  public void heapifyTopToBottom(int index, String heapType) {
    int left = index * 2;
    int right = index * 2 + 1;
    int swapChild = 0;
    if (sizeOfTree < left) {
      return;
    }
    if (heapType.equals("Max")) {
      if (sizeOfTree == left) {
        if (arr[index] < arr[left]) {
          int tmp = arr[index];
          arr[index] = arr[left];
          arr[left] = tmp;
        }
        return;
      } else {
        if (arr[left] > arr[right]) {
          swapChild = left;
        } else {
          swapChild = right;
        }
        if (arr[index] < arr[swapChild]) {
          int tmp = arr[index];
          arr[index] = arr[swapChild];
          arr[swapChild] = tmp;
        }
      }
    } else if (heapType.equals("Min")) {
      if (sizeOfTree == left) {
        if (arr[index] > arr[left]) {
          int tmp = arr[index];
          arr[index] = arr[left];
          arr[left] = tmp;
        }
        return;
      } else {
        if (arr[left] < arr[right]) {
          swapChild = left;
        } else {
          swapChild = right;
        }
        if (arr[index] > arr[swapChild]) {
          int tmp = arr[index];
          arr[index] = arr[swapChild];
          arr[swapChild] = tmp;
        }
      }
    }
    heapifyTopToBottom(swapChild, heapType);
  }

  public int extractHeadOfBP(String heapType) {
    if (isEmpty()) {
      return -1;
    } else {
      int extractedValue = arr[1];
      arr[1] = arr[sizeOfTree];
      sizeOfTree--;
      heapifyTopToBottom(1, heapType);
      return extractedValue;
    }
  }

  // delete
  public void deleteBH() {
    arr = null;
    System.out.println("BH has been successfully deleted");
  }
}

class Main1 {
  public static void main(String[] args) {

    BinaryHeap binaryHeap = new BinaryHeap(10);


    binaryHeap.insert(5, "Min");
    binaryHeap.insert(10, "Min");
    binaryHeap.insert(20, "Min");
    binaryHeap.insert(15, "Min");
    binaryHeap.insert(30, "Min");
    binaryHeap.insert(25, "Min");


    System.out.println("Size of binary heap: " + binaryHeap.sizeOfBP());


    System.out.println("Top element of binary heap: " + binaryHeap.peek());


    System.out.println("Binary heap in level order:");
    binaryHeap.levelOrder();


    System.out.println("Extracted head of binary heap: " + binaryHeap.extractHeadOfBP("Min"));


    System.out.println("Binary heap after extracting head:");
    binaryHeap.levelOrder();


    binaryHeap.deleteBH();
  }
}

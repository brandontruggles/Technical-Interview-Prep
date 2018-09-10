/*

*/

import java.util.Random;

public class Main {
  static Random r = new Random();

	public static void main(String [] args) {
    TriStack stack = new TriStack(1);
    stack.add(1, 0);
    stack.add(2, 0);
    stack.add(3, 1);
    System.out.println(stack.pop(0));
    System.out.println(stack.pop(0));
	}

}

class BestSolution {

}

//Node class which holds an integer value for simplicity.
class TriStack {
  int[] endIdxs;
  int[] startIdxs;
  int [] stackArr;
  public TriStack(int initialCapacity) {
    stackArr = new int[initialCapacity * 3];
    endIdxs = new int[3];
    startIdxs = new int[3];
    endIdxs[0] = startIdxs[0] = 0;
    endIdxs[1] = startIdxs[1] = initialCapacity;
    endIdxs[2] = startIdxs[2] = initialCapacity * 2;
  }

  public int peek(int index) {
    if(index < 3 && index > -1) {
      if(startIdxs[index] != endIdxs[index]) {
        return stackArr[endIdxs[index] - 1];
      }
    }
    throw new ArrayIndexOutOfBoundsException();
  }

  public int pop(int index) {
    if(index < 3 && index > -1) {
      if(startIdxs[index] != endIdxs[index]) {
        int val = stackArr[endIdxs[index] - 1];
        endIdxs[index]--;
        return val;
      }
    }
    throw new ArrayIndexOutOfBoundsException();
  }

  public boolean isEmpty(int index) {
    if(index < 3 && index > -1) {
      if(startIdxs[index] == endIdxs[index]) {
        return true;
      }
      return false;
    }
    else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public void add(int num, int index) {
    if(index < 3 && index > -1) {
      int capacityRemaining = endIdxs[index] - startIdxs[index];
      if(capacityRemaining == 0) {
        expandArray(index);
      }
      stackArr[endIdxs[index]] = num;
      endIdxs[index]++;
    }
    else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public void expandArray(int index) {
    if(index < 3 && index > -1) {
      int sizeIncrease = (endIdxs[index] - startIdxs[index]) + 1;
      int[] newArr = new int[stackArr.length + sizeIncrease];
      for(int i = 0; i < index; i++) {
        for(int idx = startIdxs[i]; idx < endIdxs[i]; idx++) {
          newArr[idx] = stackArr[idx];
        }
      }
      endIdxs[index] += sizeIncrease;
      for(int i = index + 1; i < 3; i++) {
        endIdxs[i] += sizeIncrease;
        startIdxs[i] += sizeIncrease;
        for(int idx = startIdxs[i]; idx < endIdxs[i]; idx++) {
          newArr[idx + sizeIncrease] = stackArr[idx];
        }
      }
    }
    else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }

  public void shrinkArray(int index) {
    if(index < 3 && index > -1) {
      
    }
    else {
      throw new ArrayIndexOutOfBoundsException();
    }
  }
}

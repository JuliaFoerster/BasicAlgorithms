
/*
facultat recursive
Creates a Stack . if the stack grows to big for large n -> stack over flow error
*/

class Solution {

  public static double facultat(double n){
    if (n < 2){
      return 1;
    }
    return facultat(n-1)*n;
  }

  public static double facultatTail(double n, int acc){ 
    if (n < 2){
      return 1;
    }
    return facultatTail(n-1, n * acc); // how to notify the compiler that is is tail? 
  }


  public static void main(String[] args) {
    System.out.println(facultat(20));
    facultatTail(20, 1);
  }
}

class ArrayAccesssafe{
  public static void main(String[] args){
   int[] arr={10,20,30,40,50};
   int index=3;
   if(index>=0&&index<arr.length){
     System.out.println(arr[index]);
   }else{
     System.out.println("Invaild index");
   }
 }
}

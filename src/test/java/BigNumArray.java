public class BigNumArray {
    public static void main(String[] args){
        int[] arr={3, 7, 1, 9, 4};
        int b=0;
        int n=arr.length;
        int big=arr[0];
        for(int i=0;i<n;i++){

            if( big<arr[i]){
                big=arr[i];
            }

        }
        System.out.println("biggest number: "+ big);
    }
}

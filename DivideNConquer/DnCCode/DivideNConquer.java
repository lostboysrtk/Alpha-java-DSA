public class DivideNConquer {

    public static void printArr(int arr[]){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si,int ei){
        if(si>=ei){
            return;
        }
        //kaam
        int mid = si+(ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr,mid+1, ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int arr[],int si,int mid, int ei){
        //lft(0,3)=4 ryt(4,6)=3
        int temp[]=new int[ei-si+1];
        int i=si;//iterator for lft part
        int j=mid+1;//for ryt part
        int k=0;//for temp arr

        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k]=arr[i];
                i++;
            }else{
                temp[k]=arr[j];
                j++;
            }
            k++;
        }

        //lft part
        while(i<=mid){
            temp[k++]=arr[i++];
        }

        //ryt part
        while(j<=ei){
            temp[k++]=arr[j++];
        }

        //copy temp to original arr
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }

    public static void quickSort(int arr[], int si,int ei){
        if(si>=ei){
            return;
        }

        //lastelement or pivot
        int pIdx= partition(arr,si,ei);
        quickSort(arr, si, pIdx-1);//lft
        quickSort(arr, pIdx+1, ei);//ryt
    }

        public static int partition(int arr[],int si,int ei){
            int pivot=arr[ei];
            int i=si-1;//to make place for elmts smaller thn pivot

            for(int j=si;j<ei;j++){
                if(arr[j]<=pivot){
                    i++;
                    //swap
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }

            //for placing the pivot at appropriate position
            i++;
            int temp=pivot;
            arr[ei]=arr[i];
            arr[i]=temp;
            return i;
    }

        public static int searchRotatedSorted(int arr[],int tar,int si,int ei){
            //base case
            if(si>ei){
                return -1;
            }

            //kaam
            int mid=si+(ei-si)/2;
            //case found
            if(arr[mid]==tar){
                return mid;
            }

            //mid on l1
            if(arr[si]<=arr[mid]){
                //case a,lft
                if(arr[si]<=tar && tar<=arr[mid]){
                    return searchRotatedSorted(arr, tar, si, mid-1);
                }else{
                    //case b
                    return searchRotatedSorted(arr, tar, mid+1, ei);
                }
            }else{  //mid l2
                //case c ryt
                if(arr[mid]<=tar && tar<=arr[ei]){
                    return searchRotatedSorted(arr, tar, mid+1, ei);
                }else{
                    //case d lft
                    return searchRotatedSorted(arr, tar, si, mid-1);
                }
            }   
        }
    public static void main(String args[]){

        // int arr[]={6,3,5,2,8};
        // mergeSort(arr,0, arr.length-1);
        // printArr(arr);

        // int arr[]={6,3,5,2,8};
        // quickSort(arr,0, arr.length-1);
        // printArr(arr);

        // int arr[]={4,5,6,7,0,1,2};
        // int target=0;
        // int tarIdx=searchRotatedSorted(arr, target, 0,arr.length-1);
        // System.out.println(tarIdx);

    }
}

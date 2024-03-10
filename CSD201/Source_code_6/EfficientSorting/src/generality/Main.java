/*
 *  Efficient Sorting Algorithms.
 */

package generality;

import java.util.*;

class EfficientSort {
    int [] a; int n;
    
    EfficientSort() {}
    
    EfficientSort(int [] b) {
        int i;
        n = b.length;
        a = new int[n];
        for(i=0; i<n; i++) a[i]=b[i];
    }
    
    void setData(int [] b) {
        int i;
        n = b.length;
        a = new int[n];
        for(i=0; i<n; i++) a[i]=b[i];
    }
    
    void setRandom() {
        int i;
        Scanner s = new Scanner(System.in);
        System.out.print(" Enter n = ");
        n = s.nextInt();
        a = new int[n];
        //Create a random number generator,
        //seeds with current time by default:
        Random r = new Random();
        for(i=0; i<n; i++)
           a[i]= r.nextInt(100); //Choose value from 0 to 99
    }
    
    void display() {
        int i;
        for(i=0; i<n; i++)
            System.out.print("  " + a[i]);
        System.out.println();
    }
    
    //Return true if the list is sorted
    boolean sorted() {
        for(int i=0; i<n-1; i++)
            if(a[i]>a[i+1]) return(false);
        return(true);
    }
    
    //Swap element at position i with k 
    void swap(int [] a, int i, int k) {
        int x; x=a[i]; a[i]=a[k]; a[k]=x;
    }

    /*  Cai dat giai thuat Quicksort
        Thu tuc partition se phan hoach danh sach tu low den up thanh 2 phan:
        cac nut co noi dung <= a[pivot] nam ben trai pivot, cac nut co
        noi dung > a[pivot] nam ben phai.
        Chon nuttruc=a[low], quet 2 dau lai, i tu duoi len, j tu tren xuong,
        va doi cho cac cap phan tu sai cho, khi ket thuc quet thi doi cho 
        a[low] va a[j], vay nut truc se chuyen den vi tri j    */  
    
    //Return Pivot index (PivIndex)
    int partition(int low, int up) {
        int pivot, pivotval;
        pivotval=a[low]; //Chon nut dau lam truc
        int i=low, j=up;
        //Bat dau quet
        while(i<j) {
            while(a[i]<=pivotval && i<up) i++; //a[i]>pivotval
            while(a[j]>pivotval)  j--;         //a[j]<=pivotval
            if(i<j) swap(a,i,j); //Doi cho cap nut sai vi tri
        }
        
        /*  Sau vong lap ta co i>=j, cac phan tu tu low den j deu <=pivotval
            cac phan tu tu j+1 deu > pivota
        
            0 1 2  3 4 5 6
            --------------
            5,7,11,3,9,2,6      i=1, j=5 (a[1]=7>pivotval, a[5]=2<=pivotval)
            5,2,3,11,9,7,6      i=3, j=2 (a[3]=11>pivotval, a[2]=3<=pivotval)
            3,2,5,11,9,7,6
      
            Ta chuyen pivotval den vi tri j(2) de bao dam rang pivotval o dung 
            vi tri trong day, tuc la cac phan tu ben trai deu nho hon hoac 
            bang, cac phan tu ben phai lon hon  */
        
        swap(a,low,j);
        pivot=j;
        return(pivot);
    }
    
    void quickSort(int low, int up) {
        int pivot;
        if(low>=up) return;
        pivot=partition(low,up);
        quickSort(low,pivot-1);
        quickSort(pivot+1,up);
    }

    void quickSort() {quickSort(0, n-1);}
    
    /*  Sap xep danh sach theo thu tu tang dan bang Merge Sort.
        -   Input: Day a[0],a[1],...,a[n-1]
        -   Tr.gian: b la danh sach tam dung khi tron, k la chi so cua danh 
            sach nay; size la kich thuoc cua danh sach con, o buoc 1 size=1, 
            buoc 2 size=2, buoc 3 size=4,...
            low1,up1,low2,up2 la can duoi va can tren cua 2 danh sach dang 
            tron
        -   Output: Danh sach da duoc sap xep   */
    
    void mergeSort() {
        int i,j,k,low1,up1,low2,up2; //Can duoi va tren cua 2 ds con
        int size;
        int [] b=new int[n];
        size=1; //Buoc tron 1: gan size bang 1
        while(size<n) {
            low1=0; k=0;
            while(low1+size<n) {
                low2=low1+size;
                up1=low2-1;
                up2=(low2+size-1<n)? low2+size-1 : n-1;
                /*  Cho i quet tu low1 den up1, j quet tu low2 den up2. Voi 
                    moi i va j so sanh va chon phan tu nho hon chuyen sang 
                    danh sach tam.  */
                for(i=low1,j=low2; i<=up1&&j<=up2; k++)
                    if(a[i]<=a[j])
                        b[k]=a[i++];
                    else
                        b[k]=a[j++];
                /*  Vi so phan tu duoc chon tu 2 ds khong nhu nhau nen co the 
                    i hoac j se den dich truoc. Trong truong hop nay ta chuyen 
                    phan con lai cua day chua quet xong sang ds tam.    */
                for(; i <= up1; k++) b[k] = a[i++];
                for(; j <= up2; k++) b[k] = a[j++];
                low1 = up2+1;
            } //While(low1+size<n)
            /*  Neu so ds con la so le thi khi tron tung cap se con lai ds cuoi
                cung. Ta phai chuyen danh sach nay sang ds tam  */
            for(i = low1; k < n; i++) b[k++] = a[i];
            for(i = 0; i < n; i++) a[i] = b[i];
            size *= 2;//Tang co cua danh sach con len 2 lan.
        } // end of size<n
    }

    /*  Sap xep danh sach theo thu tu tang dan bang Heap Sort. 
        Heap la cay nhi phan gan day duoc cai dat bang mang mot chieu voi cac 
        nut tren heap co noi dung nho hon nut goc va cac nhanh cay con cung 
        la cac heap */
    
    void heapSort() {       
        /*  Chuyen danh sach thanh Heap bang cach xem khoi dau heap gom nut 
            a[0], sau do lan luot chuyen cac nut a[1], a[2], ..., a[n-1] 
            vao heap    */        
        int i,s,f; int x;       
        for(i=1; i<n; i++) {
            //Nut can them vao Heap
            x=a[i]; //Ban dau heap co mot nut a[0].
            //Insert x vao vi tri thich hop cua Heap: xuat phat tu i, di dan 
            //ve goc de tim mot vi tri nut cha thich hop. Vay f se giam dan ...
            s=i; //s la nut con, hien tai tren heap chua co a[i]
            while(s>0 && x>a[(s-1)/2]) { //f=(s-1)/2 la nut cha
                a[s]=a[(s-1)/2]; //Keo nut < x xuong 1 muc
                s=(s-1)/2;
            }
            a[s]=x; //Dua nut x vao vi tri phu hop
        } //Ket thuc chuyen danh sach thanh heap         
        /*           11                 a = {5,7,11,3,9,2,6}
                    /  \                heap = {11,9,7,3,5,2,6}
                   9    7               
                  /\    /\
                 3  5  2  6                                          */                                   
        //Lan luot xoa nut a[0] tren Heap, dua ve vi tri thich hop tren ds
        for(i=n-1;i>0;i--) {
            x=a[i]; a[i]=a[0];
        /*  O buoc i heap co i+1 nut, la a[0], a[1],...,a[i]
            Muc dich cua chung ta la dua nut a[0] ve vi tri a[i],
            dong thoi, chen a[i] vao heap sao cho cau truc heap van bao
            toan. De lam dieu nay ta bat dau tu nut f=0, theo con duong cha - 
            con trai hoac phai, tim mot vi tri de chen nut a[i]. De co duoc 
            nut trong de chen a[i], ta can dich cac nut tren duong di len mot 
            muc, bang cong thuc nutgoc=max(contrai,conphai,a[i])
            
                     9                  heap = {11,9,7,3,5,2,6}
                    /  \                a = {9,6,7,3,5,2,11}    6  
                   6    7               
                  /\    /
                 3  5  2     
            
                     7                  heap = {7,6,2,3,5}
                    /  \                a = {7,6,2,3,5,9,11}    2  
                   6    2               
                  /\    
                 3  5     
            
                     6                  heap = {6,5,2,3}
                    /  \                a = {6,5,2,3,7,9,11}    5  
                   5    2               
                  /    
                 3   
            
                     5                  heap = {5,3,2}
                    /  \                a = {5,3,2,6,7,9,11}    3  
                   3    2               
                      
                     3                  heap = {3,2}
                       \                a = {3,2,5,6,7,9,11}    2  
                        2       
            
                     2                  heap = {2}
                                        a = {2,3,5,6,7,9,11}    2  
            
                                        heap = {}
                                        a = {2,3,5,6,7,9,11}                                                           
            */
            f=0; //f la nut cha, s la nut con lon hon
            s=2*f+1; //gan s la nut con ben trai
            //neu co nut phai va lon hon thi chon nut phai
            if(s+1<i && a[s]<a[s+1]) s=s+1;
            while(s<i && x<a[s]) {
                a[f]=a[s]; //con lon thay the cha
                f=s;//chuyen den con lon tiep theo
                s=2*f+1;
                if(s+1<i && a[s]<a[s+1]) s=s+1;
            }
            a[f]=x; //Nut a[k] duoc chen dung cho
        }
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int choice;
        int [] b = {5,7,11,3,9,2,6};
        EfficientSort t = new EfficientSort(b);
        while(true) {
            System.out.println("\n Choose your option:");
            System.out.println("  1. Create list randomly");
            System.out.println("  2. Display data");
            System.out.println("  3. Check sorted");
            System.out.println("  4. Quick sort");
            System.out.println("  5. Merge sort");
            System.out.println("  6. Heap sort");
            System.out.println("  0. Exit\n");
            System.out.print("  Your selection (0 -> 6): ");
            choice = s.nextInt();
            if(choice==0) {
                System.out.println(" Good bye, have a nice day!");
                break;
            }
            switch(choice) {
                case 1:  t.setRandom();
                      break;
                case 2:  t.display();
                      break;
                case 3:  if(t.sorted())
                       System.out.println(" The list is sorted");
                        else
                        System.out.println(" The list is not sorted");
                      break;
                case 4:  t.quickSort();t.display();
                      break;
                case 5:  t.mergeSort();t.display();
                      break;
                case 6:  t.heapSort();t.display();
                      break;
                default: System.out.println("**Invalid choice. Try again.**");
            }
        }
    }
}


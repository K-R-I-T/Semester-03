
import java.util.Arrays;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Sort {

    public void insertionSort(Employees[] empArr, boolean asc) {
        insertionSort(empArr);
        if (!asc) {
            Collections.reverse(Arrays.asList(empArr));
        }
    }

    public void selectSort(Employees[] empArr, boolean asc) {
        selectSort(empArr);
        if (!asc) {
            Collections.reverse(Arrays.asList(empArr));
        }
    }

    public void bubbleSort(Employees[] empArr, boolean asc) {
        bubbleSort(empArr);
        if (!asc) {
            Collections.reverse(Arrays.asList(empArr));
        }
    }

    public void heapSort(Employees[] empArr, boolean asc) {
        heapSort(empArr);
        if (!asc) {
            Collections.reverse(Arrays.asList(empArr));
        }
    }

    public void quickSort(Employees[] empArr, boolean asc) {
        quickSort(empArr, 0, empArr.length - 1);
        if (!asc) {
            Collections.reverse(Arrays.asList(empArr));
        }
    }

    public void mergeSort(Employees[] empArr, boolean asc) {
        mergeSort(empArr);
        if (!asc) {
            Collections.reverse(Arrays.asList(empArr));
        }
    }

    private void insertionSort(Employees[] empArr) {
        int n = empArr.length;
        for (int i = 1; i < n; i++) {
            Employees tmp = empArr[i];
            int j = i;
            while (j > 0 && tmp.compareTo(empArr[j - 1]) < 0) {
                empArr[j] = empArr[j - 1];
                j--;
            }
            empArr[j] = tmp;
        }
    }

    private void selectSort(Employees[] empArr) {
        int n = empArr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (empArr[j].compareTo(empArr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Employees tmp = empArr[i];
            empArr[i] = empArr[minIndex];
            empArr[minIndex] = tmp;
        }
    }

    private void bubbleSort(Employees[] empArr) {
        int n = empArr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (empArr[j].compareTo(empArr[i]) < 0) {
                    Employees tmp = empArr[i];
                    empArr[i] = empArr[j];
                    empArr[j] = tmp;
                }
            }
        }
    }

    private void heapSort(Employees[] empArr) {
        int n = empArr.length;
        for (int i = 1; i < n; i++) {
            Employees tmp = empArr[i];
            int j = i;
            while (j > 0 && tmp.compareTo(empArr[(j - 1) / 2]) > 0) {
                empArr[j] = empArr[(j - 1) / 2];
                j = (j - 1) / 2;
            }
            empArr[j] = tmp;
        }
        for (int i = n - 1; i > 0; i--) {
            Employees tmp = empArr[i];
            empArr[i] = empArr[0];
            int r = 0;
            int j = 2 * r + 1;
            if (j + 1 < i && empArr[j].compareTo(empArr[j + 1]) < 0) {
                j = j + 1;
            }
            while (j < i && tmp.compareTo(empArr[j]) < 0) {
                empArr[r] = empArr[j];
                r = j;
                j = 2 * r + 1;
                if (j + 1 < i && empArr[j].compareTo(empArr[j + 1]) < 0) {
                    j = j + 1;
                }
            }
            empArr[r] = tmp;
        }
    }

    private void quickSort(Employees[] empArr, int f, int l) {
        if (f >= l) {
            return;
        }
        int i = f, j = l;
        while (i < j) {
            while (empArr[i].compareTo(empArr[f]) <= 0 && i < l) {
                i++;
            }
            while (empArr[j].compareTo(empArr[f]) > 0) {
                j--;
            }
            if (i < j) {
                Employees tmp = empArr[i];
                empArr[i] = empArr[j];
                empArr[j] = tmp;
            }
        }
        Employees tmp = empArr[f];
        empArr[f] = empArr[j];
        empArr[j] = tmp;
        int pivot = j;
        quickSort(empArr, f, pivot - 1);
        quickSort(empArr, pivot + 1, l);
    }

    private void mergeSort(Employees[] empArr) {
        int i, j, k, f1, l1, f2, l2;
        int size = 1;
        Employees[] temp = new Employees[empArr.length];
        while (size < empArr.length) {
            f1 = 0;
            k = 0;
            while (f1 + size < empArr.length) {
                f2 = f1 + size;
                l1 = f2 - 1;
                l2 = (f2 + size - 1 < empArr.length) ? f2 + size - 1 : empArr.length - 1;
                for (i = f1, j = f2; i <= l1 && j <= l2; k++) {
                    if (empArr[i].compareTo(empArr[j]) <= 0) {
                        temp[k] = empArr[i++];
                    } else {
                        temp[k] = empArr[j++];
                    }
                }
                for (; i <= l1; k++) {
                    temp[k] = empArr[i++];
                }
                for (; j <= l2; k++) {
                    temp[k] = empArr[j++];
                }
                f1 = l2 + 1;
            }
            for (i = f1; k < empArr.length; i++) {
                temp[k++] = empArr[i];
            }
            for (i = 0; i < empArr.length; i++) {
                empArr[i] = temp[i];
            }
            size *= 2;
        }
    }
    
    public void display(Employees[] empArr) {
        for (Employees empArr1 : empArr) {
            System.out.println(empArr1.toString());
        }
    }
}

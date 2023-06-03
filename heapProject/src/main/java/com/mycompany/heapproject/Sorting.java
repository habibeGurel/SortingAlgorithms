/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.heapproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 *
 * @author Habibe
 */
public class Sorting extends javax.swing.JFrame {

    DefaultListModel dlm = new DefaultListModel();
    DefaultListModel dlm2 = new DefaultListModel();
    int array[];
    double[] sure = new double[6];

    /**
     * Creates new form Heap
     */
    public Sorting() {
        initComponents();
    }

    //bubble sorting
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //heap sorting
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    //insertation Sorting
    void insertationSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    //selection sorting
    void selectionSort(int arr[]) {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    //quick sorting
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    //merge sorting
    void merge(int arr[], int l, int m, int r) {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rbtn_heapSort = new javax.swing.JRadioButton();
        rbtn_insertationSort = new javax.swing.JRadioButton();
        rbtn_bubbleSort = new javax.swing.JRadioButton();
        rbtn_quickSort = new javax.swing.JRadioButton();
        rbtn_mergeSort = new javax.swing.JRadioButton();
        rbtn_selectionSort = new javax.swing.JRadioButton();
        btn_generateRandomArray = new javax.swing.JButton();
        lbl_arrayLength = new javax.swing.JLabel();
        txt_arrayLength = new javax.swing.JTextField();
        lbl_sortingTime = new javax.swing.JLabel();
        txt_sortingTime = new javax.swing.JTextField();
        lbl_sortedArray = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_randomArrays = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lst_sortedArrays = new javax.swing.JList<>();
        btn_grafikCiz = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(rbtn_heapSort);
        rbtn_heapSort.setText("Heap Sort");
        rbtn_heapSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_heapSortActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtn_insertationSort);
        rbtn_insertationSort.setText("Insertation Sort");
        rbtn_insertationSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_insertationSortActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtn_bubbleSort);
        rbtn_bubbleSort.setText("Bubble Sort");
        rbtn_bubbleSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_bubbleSortActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtn_quickSort);
        rbtn_quickSort.setText("Quick Sort");
        rbtn_quickSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_quickSortActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtn_mergeSort);
        rbtn_mergeSort.setText("Merge Sort");
        rbtn_mergeSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_mergeSortActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtn_selectionSort);
        rbtn_selectionSort.setText("Selection Sort");
        rbtn_selectionSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_selectionSortActionPerformed(evt);
            }
        });

        btn_generateRandomArray.setText("Generate Random Array");
        btn_generateRandomArray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generateRandomArrayActionPerformed(evt);
            }
        });

        lbl_arrayLength.setText("Array Length:");

        lbl_sortingTime.setText("Sorting Time:");

        lbl_sortedArray.setText("Sorted Array");

        jScrollPane1.setViewportView(lst_randomArrays);

        jScrollPane2.setViewportView(lst_sortedArrays);

        btn_grafikCiz.setText("grafik çiz");
        btn_grafikCiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grafikCizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbl_arrayLength)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_arrayLength, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl_sortingTime)
                        .addComponent(rbtn_mergeSort)
                        .addComponent(rbtn_heapSort)
                        .addComponent(rbtn_selectionSort)
                        .addComponent(rbtn_quickSort)
                        .addComponent(rbtn_insertationSort)
                        .addComponent(rbtn_bubbleSort))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_sortingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_grafikCiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_generateRandomArray, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_sortedArray, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_arrayLength)
                            .addComponent(txt_arrayLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_generateRandomArray)
                            .addComponent(lbl_sortedArray, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(rbtn_heapSort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn_bubbleSort)
                                .addGap(6, 6, 6)
                                .addComponent(rbtn_insertationSort)
                                .addGap(3, 3, 3)
                                .addComponent(rbtn_selectionSort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn_quickSort)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn_mergeSort)
                                .addGap(104, 104, 104)
                                .addComponent(lbl_sortingTime)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_sortingTime, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(82, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(btn_grafikCiz)
                .addGap(97, 97, 97))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_generateRandomArrayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generateRandomArrayActionPerformed
        // TODO add your handling code here:
        dlm.clear();
        array = new int[Integer.parseInt(txt_arrayLength.getText())];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100) + 1;
            dlm.addElement(array[i]);
        }
        lst_randomArrays.setModel(dlm);
    }//GEN-LAST:event_btn_generateRandomArrayActionPerformed

    private void rbtn_heapSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_heapSortActionPerformed
        // TODO add your handling code here:
        long time1 = System.nanoTime();
        //sorting
        heapSort(array);
        long time2 = System.nanoTime();
        double sortingTime = (time2 - time1) / 1000000.0;
        dlm2.clear();
        heapSort(array);
        for (int i = 0; i < array.length; i++) {
            dlm2.addElement(array[i]);
        }
        lst_sortedArrays.setModel(dlm2);
        
        txt_sortingTime.setText(Double.toString(sortingTime));
    }//GEN-LAST:event_rbtn_heapSortActionPerformed

    private void rbtn_bubbleSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_bubbleSortActionPerformed
        // TODO add your handling code here:
        long time1 = System.nanoTime();
        //sorting
        bubbleSort(array);
        long time2 = System.nanoTime();
        double sortingTime = (time2 - time1) / 1000000.0;
        dlm2.clear();
        bubbleSort(array);
        for (int i = 0; i < array.length; i++) {
            dlm2.addElement(array[i]);
        }
        lst_sortedArrays.setModel(dlm2);
        
        txt_sortingTime.setText(Double.toString(sortingTime));
    }//GEN-LAST:event_rbtn_bubbleSortActionPerformed

    private void rbtn_insertationSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_insertationSortActionPerformed
        // TODO add your handling code here:
        long time1 = System.nanoTime();
        //sorting
        insertationSort(array);
        long time2 = System.nanoTime();
        double sortingTime = (time2 - time1) / 1000000.0;
        dlm2.clear();
        insertationSort(array);
        for (int i = 0; i < array.length; i++) {
            dlm2.addElement(array[i]);
        }
        lst_sortedArrays.setModel(dlm2);
        
        txt_sortingTime.setText(Double.toString(sortingTime));
    }//GEN-LAST:event_rbtn_insertationSortActionPerformed

    private void rbtn_selectionSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_selectionSortActionPerformed
        // TODO add your handling code here:
        long time1 = System.nanoTime();
        //sorting
        selectionSort(array);
        long time2 = System.nanoTime();
        double sortingTime = (time2 - time1) / 1000000.0;
        dlm2.clear();
        selectionSort(array);
        for (int i = 0; i < array.length; i++) {
            dlm2.addElement(array[i]);
        }
        lst_sortedArrays.setModel(dlm2);
        
        txt_sortingTime.setText(Double.toString(sortingTime));
    }//GEN-LAST:event_rbtn_selectionSortActionPerformed

    private void rbtn_quickSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_quickSortActionPerformed
        // TODO add your handling code here:
        long time1 = System.nanoTime();
        //sorting
        quickSort(array, 0, (array.length - 1));
        long time2 = System.nanoTime();
        double sortingTime = (time2 - time1) / 1000000.0;
        dlm2.clear();
        quickSort(array, 0, (array.length - 1));
        for (int i = 0; i < array.length; i++) {
            dlm2.addElement(array[i]);
        }
        lst_sortedArrays.setModel(dlm2);
        
        txt_sortingTime.setText(Double.toString(sortingTime));
    }//GEN-LAST:event_rbtn_quickSortActionPerformed

    private void rbtn_mergeSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_mergeSortActionPerformed
        // TODO add your handling code here:
        long time1 = System.nanoTime();
        //sorting
        mergeSort(array, 0, (array.length - 1));
        long time2 = System.nanoTime();
        double sortingTime = (time2 - time1) / 1000000.0;
        dlm2.clear();
        mergeSort(array, 0, (array.length - 1));
        for (int i = 0; i < array.length; i++) {
            dlm2.addElement(array[i]);
        }
        lst_sortedArrays.setModel(dlm2);

        txt_sortingTime.setText(Double.toString(sortingTime));
    }//GEN-LAST:event_rbtn_mergeSortActionPerformed

    private void btn_grafikCizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grafikCizActionPerformed
        // TODO add your handling code here:
        long time1 = System.nanoTime();
        //sorting
        heapSort(array);
        long time2 = System.nanoTime();
        double sortingTime = (time2 - time1) / 1000000.0;
        sure[0] = sortingTime;

        time1 = System.nanoTime();
        //sorting
        bubbleSort(array);
        time2 = System.nanoTime();
        sortingTime = (time2 - time1) / 1000000.0;
        sure[1] = sortingTime;
        
        time1 = System.nanoTime();
        //sorting
        insertationSort(array);
        time2 = System.nanoTime();
        sortingTime = (time2 - time1) / 1000000.0;
        sure[2] = sortingTime;
        
        time1 = System.nanoTime();
        //sorting
        selectionSort(array);
        time2 = System.nanoTime();
        sortingTime = (time2 - time1) / 1000000.0;
        sure[3] = sortingTime;
        
        time1 = System.nanoTime();
        //sorting
        quickSort(array, 0, (array.length - 1));
        time2 = System.nanoTime();
        sortingTime = (time2 - time1) / 1000000.0;
        sure[4] = sortingTime;
        
        time1 = System.nanoTime();
        //sorting
        mergeSort(array, 0, (array.length - 1));
        time2 = System.nanoTime();
        sortingTime = (time2 - time1) / 1000000.0;
        sure[5] = sortingTime;
        
        SwingUtilities.invokeLater(() -> {
            LineChartExample example = new LineChartExample("Sorting Times Graph", sure);
            example.setAlwaysOnTop(true);
            example.pack();
            example.setSize(600, 400);
            // example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
            example.setVisible(true);
        });

    }//GEN-LAST:event_btn_grafikCizActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Sorting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sorting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sorting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sorting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sorting().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generateRandomArray;
    private javax.swing.JButton btn_grafikCiz;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_arrayLength;
    private javax.swing.JLabel lbl_sortedArray;
    private javax.swing.JLabel lbl_sortingTime;
    private javax.swing.JList<String> lst_randomArrays;
    private javax.swing.JList<String> lst_sortedArrays;
    private javax.swing.JRadioButton rbtn_bubbleSort;
    private javax.swing.JRadioButton rbtn_heapSort;
    private javax.swing.JRadioButton rbtn_insertationSort;
    private javax.swing.JRadioButton rbtn_mergeSort;
    private javax.swing.JRadioButton rbtn_quickSort;
    private javax.swing.JRadioButton rbtn_selectionSort;
    private javax.swing.JTextField txt_arrayLength;
    private javax.swing.JTextField txt_sortingTime;
    // End of variables declaration//GEN-END:variables
}

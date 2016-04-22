package ru.java1.lesson5_1;

import java.util.*;

/**
 * Created by Abilis on 22.04.2016.
 */
public class BinaryHeap {

    private List<Integer> list;
    public int heapSize;

    public int getHeapSize() {
        return heapSize;
    }

    //инициализируем кучу. Создаем новый аррей-лист размером равным размеру принятого списка
    public BinaryHeap(List<Integer> list) {
        heapSize = list.size();
        this.list = new ArrayList<>(heapSize);

        //строим кучу написанным ниже методом
        this.buildHeap(list);
    }

    //метод добавляет новый элемент в кучу
    public void add(int value) {

        list.add(value);
        int i = heapSize - 1; //индекс только что добавленного элемента
        int parent = (i - 1) / 2; //индекс родителя только что добавленного элемента

        //проталкиваем добавленный элемент к корню
        while (i > 0 && list.get(i) > list.get(parent)) {

            //меняем элемент и его родителя местами
            int temp = list.get(i);
            list.set(i, list.get(parent));
            list.set(parent, temp);

            //определяем заново индексы только что добавленного элемента и его родителя
            i = parent;
            parent = (i - 1) / 2;
        }
    }

    //метод упорядочивает кучу для дерева с корнем в вершине i
    public void heapify(int i) {

        int leftChild;
        int rightChild;
        int largestChild;

        while (true) {

            //определяем текущую вершину и его потомков
            largestChild = i;
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;

            //проверка левого потомка. Если он больше родителя, то индексом родителя становится индекс левого потомка
            if (leftChild < heapSize && list.get(leftChild) > list.get(largestChild)) {
                largestChild = leftChild;
            }

            //проверка правого потомка. Если он больше родителя, то индексом родителя становится индекс правого потомка
            if (rightChild < heapSize && list.get(rightChild) > list.get(largestChild)) {
                largestChild = rightChild;
            }

            //если в результате первых двух проверок оказалось, что ни один из потомков не больше родителя, то завершаем цикл
            if (largestChild == i) {
                break;
            }

            //меняем местами i-ый элемент и тот, который теперь находится под индексом родителя
            int temp = list.get(i);
            list.set(i, list.get(largestChild));
            list.set(largestChild, temp);

            //и определяем индекс нового корня
            i = largestChild;

        }

    }

    //построение кучи на основе полученного списка
    public void buildHeap(List<Integer> list) {

        //добавляем список в "список кучи"
        this.list.addAll(list);

        //и перестраиваем дерево для каждой вершины
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    //взятие максимального элемента. Он всегда хранится на 0 позиции
    public int getMax() {
        return list.get(0);
    }

    //удаление максимального элемента
    public void removeMax() {

        //меняем местами 0 элемент и последний, затем удаляем последний и применяем упорядочивание для корня всего дерева
        int temp = list.get(0);
        list.set(0, list.get(heapSize - 1));
        list.set(heapSize - 1, temp);

        heapify(0);

    }

    //взятия минимального элемента

}

package ru.java1.lesson5_1;

import java.util.*;

/**
 * Created by Abilis on 22.04.2016.
 */
public class Collections {

    private static final int sizeFirstColl = 10;
    private static final int sizeSecondColl = 15;

    public static void main(String[] args) {

        //создаем коллекции и заполняем их случайными числами
        Collection<Integer> coll1 = new ArrayList<Integer>(sizeFirstColl);
        Collection<Integer> coll2 = new ArrayList<Integer>(sizeSecondColl);

        for (int i = 0; i < sizeFirstColl; i++) {
            coll1.add((int) (Math.random() * sizeFirstColl));
        }

        for (int i = 0; i < sizeSecondColl; i++ ) {
            coll2.add((int) (Math.random() * sizeSecondColl));
        }

        //Выводим содержимое полученных коллекций на печать
        System.out.println("Первая коллекция:\n" + coll1);
        System.out.println();
        System.out.println("Вторая коллекция:\n" + coll2);
        System.out.println();

        //1 задание
        //формируем новую коллекцию, которая будет состоять из пересечение этих двух коллекций
        Collection<Integer> intersectionsColl = getIntersection(coll1, coll2);

        //печатаем ее
        System.out.println("Пересечение: " + intersectionsColl);


        //2 задание
        //формируем новую коллекцию, которая будет состоять из объединения первоначальных двух коллекций
        Collection<Integer> unionColl = getUnion(coll1, coll2);

        //печатаем ее тоже
        System.out.println("Объединение: " + unionColl);
        System.out.println();

        //3 задание
        //сортируем 2 коллекцию и печатаем ее
        System.out.println("Отсортированная вторая коллекция:\n" + sort(coll2));

        //печатаем вторую коллекцию, чтобы убедиться, что она не была затронута сортировкой
        System.out.println("Вторая коллекция:\n" + coll2);


    }


    public static Collection<Integer> getIntersection(Collection<Integer> coll1, Collection<Integer> coll2) {

        //пересечение есть множество, состоящее из элементов, которые есть в обеих множествах
        Collection<Integer> result = new HashSet<Integer>();

        if (coll1 == null || coll2 == null) {
            return result;
        }

        int size1 = coll1.size();
        int size2 = coll2.size();

        //оптимизация на случай двух коллекций сильно разного размера
        if (size1 < size2) {

            //пробегам по всем элементам coll1. Если элемент содержится и в coll2 - добавляем в результат
            for (Integer elem : coll1) {
                if (coll2.contains(elem)) {
                    result.add(elem);
                }
            }
        }
        else {
            //пробегам по всем элементам coll2. Если элемент содержится и в coll1 - добавляем в результат
            for (Integer elem : coll2) {
                if (coll1.contains(elem)) {
                    result.add(elem);
                }
            }
        }


        return result;
    }


    public static Collection<Integer> getUnion(Collection<Integer> coll1, Collection<Integer> coll2) {

        //объединение есть множество, состоящее из элементов, которые есть хотя бы в одном множестве
        //Будем использовать свойство HashSet - оно не содерижит повторов.
        Collection<Integer> result = new HashSet<Integer>();

        if (coll1 == null || coll2 == null) {
            return result;
        }

        result.addAll(coll1);
        result.addAll(coll2);

        return result;
    }



    public static Collection<Integer> sort(Collection<Integer> coll) {

        if (coll == null) {
            return null;
        }

        //Мапы не сортируем :(
        if (coll instanceof Map) {
            return coll;
        }

        //создаем новый лист, в который переносим элементы входной коллекции, чтобы была возможность отсортировать
        //Hash* и Tree* с каким-нибудь хитрым компаратором

        List collList = new ArrayList<Integer>(coll.size());

        collList.addAll(coll);
        return qSort(collList, 0, coll.size() - 1);

    }

    private static Collection<Integer> qSort(List<Integer> list, int start, int end) {

        //условие выхода из рекурсивных вызовов
        if (start >= end) {
            return list;
        }

        //определяем индексы на каждом вызове метода
        int minIndex = start;
        int maxIndex = end;

        //опорный элемент пусть будет в середине между двумя индексами по краям
        int midIndex = minIndex + (maxIndex - minIndex) / 2;


        //пока минимальный и максимальный индексы не совпали
        while (minIndex < maxIndex) {

            //ищем индекс, где минимальный элемент больше опорного, но пока индекс меньше опорного
            while (minIndex < midIndex && list.get(minIndex) <= list.get(midIndex)) {
                minIndex++;
            }

            //ищем индекс, где максимальный элемент меньше опорного, но пока индекс больше опорного
            while (maxIndex > midIndex && list.get(maxIndex) >= list.get(midIndex)) {
                maxIndex--;
            }

            //если minIndex меньше maxIndex, значит, в процессе предыдущих циклов нашлись такие элементы, что
            //элемент слева больше опорного, а элемент справа меньше опорного. Их нужно поменять местами
            if (minIndex < maxIndex) {
                int tmp = list.get(minIndex);
                list.set(minIndex, list.get(maxIndex));
                list.set(maxIndex, tmp);

                //на случай, если с одной стороны дошли до опорного элемента
                if (minIndex == midIndex) {
                    midIndex = maxIndex;
                }
                else if (maxIndex == midIndex) {
                    midIndex = minIndex;
                }
            }

        }

        //мыло и мочало - начинаем все сначала!
        qSort(list, start, midIndex);
        qSort(list, midIndex + 1, end);

        return list;
    }
}

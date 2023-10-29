package pro.sky.homework_2_15.service;

import org.springframework.stereotype.Service;
import pro.sky.homework_2_15.exception.ElementNotFoundException;

import java.util.Arrays;

@Service
public class StringListServiceImpl implements StringList {

    private int listLength = 0; // размер массива по умолчанию
    String[] list; // сам массив

    public StringListServiceImpl(String[] list) {
        this.list = list;
    }

    // метод добавления элемента по значению
    public String add(String item) {

        listLength ++;
        String[] newList = new String[listLength];
        System.arraycopy(list, 0, newList, 0, list.length);

        this.list = newList;

        newList[listLength - 1] = item;
        return item;
    }

    // метод добавления элемента по индексу
    @Override
    public String add(int index, String item) throws IndexOutOfBoundsException {

        if (index >= listLength && index != 0) {
            throw new IndexOutOfBoundsException("Ошибка! Индекс выходит за пределы размера списка!");
        }

        listLength ++;
        String[] newList = new String[listLength];
        System.arraycopy(list, 0, newList, 0, list.length);

        for (int i = listLength - 1; i > index; i--) {
            newList[i] = list[i - 1];
        }

        this.list = newList;

        newList[index] = item;
        return item;
    }

    // метод добавления элемента по индексу и значению
    @Override
    public String set(int index, String item) throws IndexOutOfBoundsException {

        if (index >= listLength && index != 0) {
            throw new IndexOutOfBoundsException("Ошибка! Индекс выходит за пределы размера списка!");
        }

        list[index] = item;
        return item;
    }

    // метод удаления элемента по значению
    // в данной реализации удаляется только первое вхождение элемента в список, а не все элементы,
    // если список содержит несколько идентичных элементов, так как в тексте ДЗ не указано обратного
    @Override
    public String remove(String item) throws ElementNotFoundException {

        boolean isContains = false;

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(item)){
                list[i] = null;
                isContains = true;
                break;
            }
        }

        if (!isContains) {
            throw new ElementNotFoundException("Такой элемент отсутствует!");
        }

        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == null){
                list[i] = list[i + 1];
            }
        }
        listLength--;

        String[] newList = new String[listLength];
        for (int i = 0; i < listLength; i++) {
            newList[i] = list[i];
        }

        this.list = newList;

        return item;
    }

    // метод удаления элемента по индексу
    @Override
    public String remove(int index) throws ElementNotFoundException, IndexOutOfBoundsException {

        if (index >= listLength) {
            throw new IndexOutOfBoundsException("Ошибка! Индекс выходит за пределы размера списка!");
        }

        String item = "";
        boolean isContains = false;

        for (int i = 0; i < list.length; i++) {
            if (i == index){
                item = list[i];
                list[i] = null;
                isContains = true;
                break;
            }
        }

        if (!isContains) {
            throw new ElementNotFoundException("Такой элемент отсутствует!");
        }

        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == null){
                list[i] = list[i + 1];
            }
        }
        listLength--;

        String[] newList = new String[listLength];
        for (int i = 0; i < listLength; i++) {
            newList[i] = list[i];
        }

        this.list = newList;

        return item;
    }

    // проверка вхождения элемента в массив
    @Override
    public boolean contains(String item) {

        boolean isContains = false;

        for (int i = 0; i < listLength; i++) {
            if (list[i].equals(item)) {
                isContains = true;
                break;
            }
        }
        return isContains;
    }

    // метод определения индекса первого вхождения элемента в массив
    @Override
    public int indexOf(String item) {

        for (int i = 0; i < listLength; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // метод определения индекса последнего вхождения элемента в массив
    @Override
    public int lastIndexOf(String item) {

        for (int i = listLength - 1; i > 0; i--) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // метод получения элемента по индексу
    @Override
    public String get(int index) throws IndexOutOfBoundsException {

        if (index >= listLength) {
            throw new IndexOutOfBoundsException("Ошибка! Индекс выходит за пределы размера списка!");
        }

        return list[index];
    }

    // метод сравнения массивов
    @Override
    public boolean equals(String[] otherList) throws IllegalArgumentException {

        if (otherList == null){
            throw new IllegalArgumentException("Ошибка! Необходимо указать не пустой массив для сравнения!");
        }

        boolean isEquals = false;

        if (Arrays.equals(list, otherList)) {
            isEquals = true;
        }
        return isEquals;
    }

    // метод определения размера массива
    @Override
    public int size() {

        int counter = 0;

        for (int i = 0; i < listLength; i++) {

            if (list[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    // метод определения наличия в массиве элементов
    @Override
    public boolean isEmpty() {

        boolean isEmpty = true;

        for (int i = 0; i < listLength; i++) {
            if (list[i] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    // метод для очистки массива
    @Override
    public void clear() {

        listLength = 0;
        list = new String[listLength];
    }

    @Override
    public String[] toArray() {
        String[] newList = new String[listLength];

        System.arraycopy(list, 0, newList, 0, newList.length);
        return new String[]{Arrays.toString(newList)};
    }
}

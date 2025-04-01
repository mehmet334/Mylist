//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;

class MyList<T> {

    private T[] array;
    private int size = 0;
    private int capacity;

    // Varsayılan constructor (capacity = 10)
    public MyList() {
        this(10);
    }

    // Kapasiteyi belirleyen constructor
    public MyList(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    // Dizi kapasitesini 2 katına çıkarır
    private void growSize() {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
    }

    // Eleman ekleme metodu
    public void add(T data) {
        if (size == capacity) {
            growSize();
        }
        array[size++] = data;
    }

    // Eleman sayısını verir
    public int size() {
        return size;
    }

    // Kapasiteyi verir
    public int getCapacity() {
        return capacity;
    }

    // Belirli indeksteki elemanı getirir
    public T get(int index) {
        if (index < 0 || index >= size) return null;
        return array[index];
    }

    // Belirli indeksteki elemanı siler
    public T remove(int index) {
        if (index < 0 || index >= size) return null;
        T removed = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return removed;
    }

    // Belirli indeksteki elemanı değiştirir
    public T set(int index, T data) {
        if (index < 0 || index >= size) return null;
        T oldValue = array[index];
        array[index] = data;
        return oldValue;
    }

    // Listeyi String olarak döndürür
    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            sb.append(array[i]).append(", ");
        }
        sb.append(array[size - 1]).append("]");
        return sb.toString();
    }

    // Verilen elemanın ilk indeksini döndürür
    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) return i;
        }
        return -1;
    }

    // Verilen elemanın son indeksini döndürür
    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(data)) return i;
        }
        return -1;
    }

    // Liste boş mu?
    public boolean isEmpty() {
        return size == 0;
    }

    // Listeyi array olarak döndürür
    public T[] toArray() {
        return Arrays.copyOf(array, size);
    }

    // Tüm elemanları siler
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // Alt liste döndürür
    public MyList<T> subList(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) return null;
        MyList<T> sub = new MyList<>(finish - start + 1);
        for (int i = start; i <= finish; i++) {
            sub.add(array[i]);
        }
        return sub;
    }

    // Eleman var mı kontrolü
    public boolean contains(T data) {
        return indexOf(data) != -1;
    }
}

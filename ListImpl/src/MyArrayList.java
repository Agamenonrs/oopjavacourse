import java.util.*;

// "generic" type <E> : Element
public class MyArrayList<E> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;

    public MyArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            elementData = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    // <? extends E> -> any type that extends E
    public MyArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        Object[] o;
        if (a.length < size){
            o = new Object[size];
        }else{
            o = (Object[]) a;
        }
        for (int i = 0; i < size; i++){
            o[i]=elementData[i];
        }
        return (T[]) o;
    }

    @Override
    public boolean add(E e) {
        if (size == elementData.length) {
            // grow (increases by 50%)
            elementData = grow(size + 1);
        }
        elementData[size] = e;
        size++;
        return true;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    /*
    The maximum size of array to allocate.
    Attempts to allocate larger arrays "may" result in OutOfMemoryOrder
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * @param minCapacity the desired minimum capacity
     * @return
     */
    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity <= minCapacity) {
            if (minCapacity < 0 || minCapacity > MAX_ARRAY_SIZE) {
                throw new OutOfMemoryError("integer overflow");
            }
            return minCapacity;
        }
        return (newCapacity <= MAX_ARRAY_SIZE) ? newCapacity : Integer.MAX_VALUE;
    }

    @Override
    public boolean remove(Object o) {
        int i = 0;
        boolean removed = false;
        while ( i < size && !removed ){
            if ( o != null && o.equals(elementData[i] )) {
                removed = true;
                elementData[i] = null;
            }
            i++;
        }
        if (!removed)
            return removed;

        Object[] aux = new Object[size-1];
        int j = 0;
        i = 0;
        while (i < size ){
            if(elementData[i] !=null){
                aux[j] = elementData[i];
                j++;
            }
            i++;
        }
        size--;
        elementData = aux;
        return removed;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean contains = false;
        for (Object o : c){
            for (int j = 0; j < size; j++){
                if(o !=null && o.equals(elementData[j])){
                    contains = true;
                    break;
                }
            }
            if(!contains)
                return  false;
            contains = false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] source = c.toArray();

        int newSize = size + source.length;
        Object[] aux = new Object[newSize + (newSize >> 1)];
        addToArray(aux,elementData,0,size);
        addToArray(aux,source,size,source.length);
        elementData = Arrays.copyOf(aux,newSize);
        size = newSize;
        return source.length > 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if(index < 0 || index > size-1)
            throw  new ArrayIndexOutOfBoundsException();

        Object[] source1 = Arrays.copyOf(elementData,index);
        Object[] source2 = c.toArray();
        Object[] source3 = Arrays.copyOfRange(elementData,index,size);
        int newSize = size + source2.length;
        Object[] aux = new Object[newSize + (newSize >> 1)];
        addToArray(aux,source1,0,source1.length);
        addToArray(aux,source2,source1.length,source2.length);
        addToArray(aux,source3,source1.length+source2.length,source3.length);
        elementData = Arrays.copyOf(aux,newSize);
        size = newSize;
        return c.size() > 0;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] array = c.toArray();
        Object[] aux = new Object[elementData.length];
        int count = 0;
        boolean removed = false;
        for (int i = 0; i < size; i++){
            boolean found = false;
            for (int k = 0; k < array.length; k++){
                if (!(array[k] == null ^ elementData[i] == null)){
                    if((array[k] == null && elementData[i] == null )
                            || (elementData[i].equals(array[k]))){
                        found = true;
                        break;
                    }
                }

            }
            if(!found){
                aux[count]= elementData[i];
                count++;
            }
        }
        elementData = aux;
        removed = size != count;
        size = count;

        return removed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] array = c.toArray();
        Object[] aux = new Object[elementData.length];
        int count = 0;
        boolean changed = false;
        for (int i = 0; i < array.length; i++){
            if(contains(array[i])){
                aux[count] = array[i];
                count++;
            }
        }
        changed = size != count;
        size = count;
        elementData = aux;
        return changed;
    }

    @Override
    public void clear() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = DEFAULT_CAPACITY;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
        return (E) elementData[index];
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + ", size: " + size);
        }
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        if(index < 0 || index > size)
            throw  new ArrayIndexOutOfBoundsException();
        if(index == size){
            add(element);
            return;
        }

        Object[] source1 = Arrays.copyOf(elementData,index);
        Object[] source2 = {element};
        Object[] source3 = Arrays.copyOfRange(elementData,index,size);
        int newSize = size +1;
        Object[] aux = new Object[newSize + (newSize >> 1)];
        addToArray(aux,source1,0,source1.length);
        addToArray(aux,source2,source1.length,source2.length);
        addToArray(aux,source3,source1.length+source2.length,source3.length);
        size ++;
        elementData = aux;
    }

    @Override
    public E remove(int index) {
        E element = get(index);
        Object[] source1 = Arrays.copyOf(elementData,index);
        Object[] source2 = Arrays.copyOfRange(elementData,index+1,size);
        Object[] aux = new Object[size];
        addToArray(aux,source1,0,source1.length);
        addToArray(aux,source2,source1.length,source2.length);
        elementData = aux;
        size--;

        return element;
    }

    @Override
    public int indexOf(Object o) {
        int index = -1;
        int i = 0;
        while (index < 0 && i < size){
            if(!(o == null ^ elementData[i] == null)){
                if ((o == null && elementData[i] == null) || elementData[i].equals(o)){
                    index = i;
                }
            }
            i++;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = size-1; i > 0; i-- ){
            if(!(o == null ^ elementData[i] == null)){
                if ((o == null && elementData[i] == null) || elementData[i].equals(o)){
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || fromIndex > size
            || toIndex < 0 || toIndex > size )
            throw  new ArrayIndexOutOfBoundsException();
        Object[] aux = Arrays.copyOfRange(elementData,fromIndex,toIndex);
        MyArrayList<E> result= new MyArrayList<>();
        for (int i = 0; i< aux.length;i++){
            result.add((E)aux[i]);
        }
        return result;
    }

    private void addToArray(Object[] target,Object[] source,int start,int end){
        int lengh = target.length;
        for(int i = 0; i< end; i++) {
            target[i + start] = source[i];
        }
    }
}

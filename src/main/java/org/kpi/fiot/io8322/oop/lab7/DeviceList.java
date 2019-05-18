package org.kpi.fiot.io8322.oop.lab7;

import org.kpi.fiot.io8322.oop.lab6_2.Device;

import java.util.*;

public class DeviceList implements List<Device> {
    private Device[] elements;
    private int sizeReal;

    public DeviceList(){
        elements = new Device[15];
        sizeReal = 0;
    }

    public DeviceList(Device device){
        this();
        add(device);
    }

    public DeviceList(Collection<? extends Device> collectione){
        this();
        addAll(collectione);
    }

    @Override
    public int size() {
        return sizeReal;
    }

    @Override
    public boolean isEmpty() {
        return sizeReal == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null || sizeReal == 0 || !(o instanceof Device)) return false;
        for (int i = 0; i < sizeReal; i++) {
            if (elements[i].equals(o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<Device> iterator() {
        return new DeviceListIterator(this);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOfRange(elements, 0, sizeReal, (new Object[0]).getClass());
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return Arrays.copyOfRange(elements, 0, sizeReal, (Class<? extends T[]>)ts.getClass());
    }

    @Override
    public boolean add(Device device) {
        if (device == null) throw new NullPointerException();
        expandArray(1);
        elements[sizeReal] = device;
        sizeReal++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0) return false;
        return remove(index) != null;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) return true;
        for (Object o : collection) {
            if (o == null) throw new NullPointerException();
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Device> collection) {
        if (collection == null || collection.isEmpty()) return true;
        for (Device device : collection) {
            if (device == null) throw new NullPointerException();
        }
        expandArray(collection.size());
        for (Device device : collection) {
            elements[sizeReal] = device;
            sizeReal++;
        }
        return true;
    }

    @Override
    public boolean addAll(int i, Collection<? extends Device> collection) {
        if (collection == null || collection.isEmpty()) return true;
        for (Device device : collection) {
            if (device == null) throw new NullPointerException();
        }
        expandArray(collection.size());
        for (int index = sizeReal - 1; index >= i; index--) {
            elements[index + collection.size()] = elements[index];
        }
        int indexCur = i;
        for (Device device : collection) {
            elements[indexCur] = device;
            indexCur++;
        }
        sizeReal = sizeReal+collection.size();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) return true;
        if (sizeReal == 0) return false;
        boolean flRemove = false;
        List<Device> listNew = new ArrayList<>();
        for (int i = 0; i < sizeReal; i++) {
            boolean flRemoveElement = false;
            for (Object o : collection) {
                if (o != null && elements[i].equals(o)) {
                    flRemoveElement = true;
                    break;
                }
            }
            if (flRemoveElement) {
                flRemove = true;
            } else {
                listNew.add(elements[i]);
            }
        }
        if (flRemove) {
            for (int i = 0; i < listNew.size(); i++) {
                elements[i] = listNew.get(i);
            }
            sizeReal = listNew.size();
            squeezeArray();
        }
        return flRemove;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null || collection.isEmpty()) {
            if (sizeReal > 0) {
                sizeReal = 0;
                squeezeArray();
                return true;
            } else {
                return false;
            }
        }
        if (sizeReal == 0) return false;
        boolean flRemove = false;
        List<Device> listNew = new ArrayList<>();
        for (int i = 0; i < sizeReal; i++) {
            boolean flKeepElement = false;
            for (Object o : collection) {
                if (o != null && elements[i].equals(o)) {
                    flKeepElement = true;
                    break;
                }
            }
            if (flKeepElement) {
                listNew.add(elements[i]);
            } else {
                flRemove = true;
            }
        }
        if (flRemove) {
            for (int i = 0; i < listNew.size(); i++) {
                elements[i] = listNew.get(i);
            }
            sizeReal = listNew.size();
            squeezeArray();
        }
        return flRemove;
    }

    @Override
    public void clear() {
        sizeReal = 0;
        squeezeArray();
    }

    @Override
    public Device get(int i) {
        if (i < 0 || i >= sizeReal) throw new IndexOutOfBoundsException();
        return elements[i];
    }

    @Override
    public Device set(int i, Device device) {
        if (i < 0 || i >= sizeReal) throw new IndexOutOfBoundsException();
        if (device == null) throw new NullPointerException();
        Device old = elements[i];
        elements[i] = device;
        return old;
    }

    @Override
    public void add(int i, Device device) {
        if (i < 0 || i > sizeReal) throw new IndexOutOfBoundsException();
        if (device == null) throw new NullPointerException();
        expandArray(1);
        for (int index = sizeReal - 1; index >= i; index--) {
            elements[index + 1] = elements[index];
        }
        elements[i] = device;
        sizeReal++;
    }

    @Override
    public Device remove(int i) {
        if (i < 0 || i >= sizeReal) throw new IndexOutOfBoundsException();
        Device old = elements[i];
        for (int index = i + 1; index < sizeReal; index++) {
            elements[index - 1] = elements[index];
        }
        sizeReal--;
        squeezeArray();
        return old;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) throw new NullPointerException();
        for (int i = 0; i < sizeReal; i++) {
            if (elements[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) throw new NullPointerException();
        for (int i = sizeReal - 1; i >= 0; i--) {
            if (elements[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public ListIterator<Device> listIterator() {
        return new DeviceListListIterator(this);
    }

    @Override
    public ListIterator<Device> listIterator(int i) {
        if (i < 0 || i > sizeReal) throw new IndexOutOfBoundsException();
        return new DeviceListListIterator(this, i);
    }

    @Override
    public List<Device> subList(int i, int i1) {
        if (i < 0 || i1 >= sizeReal || i > i1) throw new IndexOutOfBoundsException();
        DeviceList deviceList = new DeviceList();
        for (int index = i; index <= i1; index++) {
            deviceList.add(elements[index]);
        }
        return deviceList;
    }

    private void expandArray(int countAdd) {
        while (sizeReal + countAdd > elements.length) {
            Device[] m = new Device[elements.length * 13 / 10];
            for (int i = 0; i < sizeReal; i++) {
                m[i] = elements[i];
            }
            elements = m;
        }
    }

    private void squeezeArray() {
        int sizeArray = 15;
        while (sizeReal > sizeArray) {
            sizeArray = sizeArray * 13 / 10;
        }
        if (elements.length != sizeArray) {
            Device m[] = new Device[sizeArray];
            for (int i = 0; i < sizeReal; i++) {
                m[i] = elements[i];
            }
            elements = m;
        }
    }
}

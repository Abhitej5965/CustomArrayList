package org.example;

import java.util.*;

public class CustomArrayList<T> implements List<T> {
    Object tempArray[]={};
    int size;
    int default_Capacity=10;
    public CustomArrayList(){

        tempArray=new Object[default_Capacity];
    }
    public CustomArrayList(int size){

        tempArray=new Object[size];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(tempArray[0]==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        int flag1=0;
        for(int index=0;index<tempArray.length;index++){
            if(tempArray[index]==o){
                flag1++;
            }
        }
        if(flag1>0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int arrayCopy= tempArray.length;
        return Arrays.copyOf(tempArray,arrayCopy);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        size++;
        int newSize=size();
        if(newSize==0){
            tempArray[0]=t;
            return true;
        }else if(newSize<tempArray.length){
            tempArray[newSize-1]=t;
            return true;
        }
        else if(newSize== tempArray.length) {
            increaseCapacity();
            tempArray[newSize-1] = t;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean remove(Object o) {
        Object temp[]=new Object[tempArray.length-1];

        for(int index=0,use=0;index< tempArray.length;index++){
            if(tempArray[index]!=o){
                tempArray[use]=tempArray[index];
                use++;
            }
        }
        for(int index=0;index<tempArray.length-1;index++){
            temp[index]=tempArray[index];
        }
        tempArray=temp;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Iterator<T> iterable= c.iterator();
        int flag2=0;
        int counter=0;
        while(iterable.hasNext()) {
            counter++;
            size++; //Each time counter increases size should also increase
            int newSize=size();
            if(newSize== tempArray.length){
                increaseCapacity();
                tempArray[newSize-1]=iterable.next();
                flag2++;
            }else if(newSize<tempArray.length){
                tempArray[newSize-1]=iterable.next();
                flag2++;
            }
        }

        if(flag2==counter){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {
        Object temp1[]={};
        tempArray=temp1;

    }

    @Override
    public T get(int index) {
        T temp=null;
        for(int index1=0;index1< tempArray.length;index1++){
            if(index1==index){
                temp= (T) tempArray[index];
            }
        }
        return temp;
    }

    @Override
    public T remove(int index) {
        Object temp[]=new Object[tempArray.length-1];
        T a=null;
        for(int index1=0,use=0;index1< tempArray.length;index1++){
            if(index1!=index){
                a= (T) tempArray[index1];
                tempArray[use]=tempArray[index1];
                use++;
            }
        }
        for(int index1=0;index1<tempArray.length-1;index1++){
            temp[index1]=tempArray[index1];
        }
        tempArray=temp;
        return a;
    }

    @Override
    public T set(int index, T element) {
        T temp4= (T) tempArray[index];
        tempArray[index]=element;
        return temp4;
    }

    @Override
    public void add(int index, T element) {
        size++;
        Object temp5[]=new Object[tempArray.length+1];
        if(index==0){
            temp5[0]=element;
        }else if(index!=0){
            for(int i = 0; i < index; i++){
                temp5[i] = tempArray[i];}
            temp5[index] = element;
            for(int i = index + 1; i < temp5.length; i++){
                temp5[i] = tempArray[i - 1];}
        }

        increaseCapacity();
        tempArray=temp5;
    }



    @Override
    public int indexOf(Object o) {
        int flag5=-3;
        for(int index=0;index<=tempArray.length-1;index++){
            if(tempArray[index]==o){
                flag5=index;
                break;
            }
        }
        if(flag5!=-3){
            return flag5;
        }else{
            return -1;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int flag6=-3;
        for(int index= tempArray.length-1;index>=0;index--){
            if(tempArray[index]==o){
                flag6=index;
                break;
            }
        }
        if(flag6!=-3){
            return flag6;
        }else{
            return -1;
        }
    }

    @Override
    public ListIterator<T> listIterator() {
        Iterator<T> iterator = (Iterator<T>) Arrays.stream(tempArray).iterator();
        ListIterator<T> listIterator = null;
        while(iterator.hasNext()){
//            System.out.println( iterator.next());
            listIterator.next();
        }
        return listIterator;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        Object temp10[]=new Object[tempArray.length-index];
        for(int i=index;i<=tempArray.length-1;i++){
            temp10[i]=tempArray[i];
        }
        ListIterator<T> listIterator1 = (ListIterator<T>) Arrays.asList(temp10);
        return listIterator1;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> checkList=new CustomArrayList<T>();
        for(int index=fromIndex;index<=toIndex;index++){
            checkList.add((T) tempArray[index]);
        }
        return checkList;
    }


    @Override
    public boolean retainAll(Collection c) {
        Object temp11[]=new Object[tempArray.length];
        Iterator<T> iterable=c.iterator();
        while(iterable.hasNext()){
            for(int index=0,use=0;index< tempArray.length;index++){
                if(tempArray[index].equals(iterable.next())){
                    temp11[use]=tempArray[index];
                    use++;
                }
            }
        }
        System.out.println(Arrays.toString(temp11));
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        Iterator<T> iterable= c.iterator();
        int flag7=0;
        int counter1=0;
        Object temp9[]=new Object[tempArray.length-1];
        while(iterable.hasNext()) {
            counter1++;
            Object var=iterable.next();
            for(int index=0,use=0;index< tempArray.length;index++){
                if(tempArray[index]!=var){
                    temp9[use]=tempArray[index];
                    use++;
                }
            }
            tempArray=temp9;
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator<T> iterable=c.iterator();
        int counter3=0,flag9=0;
        while(iterable.hasNext()){
            counter3++; //this counter3 gives the size of the collection c(Arg)
            for(int index=0;index< tempArray.length;index++){
                if(tempArray[index]==iterable.next()){
                    flag9++;
                }
            }
        }
        if(counter3==flag9 && flag9!=0){
            return true;
        }else{
            return false;
        }
    }
    private void increaseCapacity(){
        int newCapacity= tempArray.length*2;
        tempArray= Arrays.copyOf(tempArray,newCapacity);
    }

    @Override
    public String toString() {
        return
                "tempArray=" + Arrays.toString(tempArray) ;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User:${USER}
 * Date:${YEAR}-${MONTH}-${DAY}
 * Time:${TIME}
 */

class ArrayOutOfIndexException extends Exception {

    public ArrayOutOfIndexException(String message) {
        super(message);
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}

public class MyArraylist {

    public int[] elem;
    public int usedSize;//0
    //默认容量
    private static final int DEFAULT_SIZE = 5;

    public MyArraylist() {
        this.elem = new int[DEFAULT_SIZE];
    }

    public void display() throws ArrayOutOfIndexException {
        if(this.usedSize == 0){
            throw new ArrayOutOfIndexException("该顺序表内无内容！");
        }
        for (int i = 0; i < this.usedSize; i++) {
            System.out.println(elem[i]);
        }
    }

    public void add(int data) throws ArrayOutOfIndexException{
        if(isFull()){
            throw new ArrayOutOfIndexException("数组满了");
        }
        elem[this.usedSize] = data;
        this.usedSize++;
    }

    public boolean isFull() {
        if(this.usedSize == DEFAULT_SIZE) {
            return true;
        }else{
            return false;
        }
    }

    private boolean checkPosInAdd(int pos) {
        if(pos >= 0 && pos <= this.usedSize){
            return true;
        }else{
            return false;
        }
    }

    // 在 pos 位置新增元素
    public void add(int pos, int data) throws ArrayOutOfIndexException {
        if(!checkPosInAdd(pos)){
            throw new ArrayOutOfIndexException("下标越界！");
        }
        int i = this.usedSize - 1;
        for(; i >= pos;i--){
            elem[i+1] = elem[i];
        }
        elem[pos] = data;
        this.usedSize++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
       if( !this.isEmpty() ){
           for (int i = 0; i < this.usedSize; i++) {
               if(get(i) == toFind){
                   return true;
               }
           }
       }
        return false;
    }

    // 查找某个元素对应的位置
    public int indexOf(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if(get(i) == toFind){
                return i;
            }
        }
        return -1;
    }

    // 获取 pos 位置的元素
    public int get(int pos){
        if(!checkPosInAdd(pos)){
            System.out.println("get方法有误！");
        }
        if(isEmpty()) {
            System.out.println("获取元素的时候，顺序表为空！");
        }
        return elem[pos];
    }

    private boolean isEmpty() {
        if(this.usedSize == 0){
            return true;
        }else{
            return false;
        }
    }

    // 给 pos 位置的元素设为【更新为】 value
    public void set(int pos, int value) throws ArrayOutOfIndexException {
        if(!checkPosInAdd(pos)){
            throw new ArrayOutOfIndexException("下标越界！");
        }else if(isEmpty()) {
            System.out.println("获取元素的时候，顺序表为空！");
        }else{
            elem[pos] = value;
        }
    }

    /**
     * 删除第一次出现的关键字key
     *
     * @param key
     */
    public void remove(int key) {
        int k = indexOf(key);
        if(k == -1){
            System.out.println(key+"不在顺序表当中！");
        }else if(isEmpty()) {
            System.out.println("获取元素的时候，顺序表为空！");
        }else{
            while(k < this.usedSize - 1){
                elem[k] = elem[k+1];
                k++;
            }
            this.usedSize--;
        }
    }

    public int size() {
        return this.usedSize;
    }

    public void clear() {
        this.usedSize = 0;
    }
}
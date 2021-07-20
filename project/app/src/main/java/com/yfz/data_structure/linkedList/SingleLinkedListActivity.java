package com.yfz.data_structure.linkedList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yfz.data_structure.R;

public class SingleLinkedListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linked_list);
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.addNewNode("小明");
        singleLinkedList.addNewNode("王二");
        singleLinkedList.addNewNode("刘强");
        singleLinkedList.addNewNode("张三");
        System.out.println("----");
        singleLinkedList.print("完整链表：");
//        singleLinkedList.deleteNodeByIndex(0);//删除第一个节点（小明）
//        singleLinkedList.print("删除首位节点，小明：");
//        singleLinkedList.deleteNodeByIndex(2);//删除第三个节点（刘强）
//        singleLinkedList.print("删除中间的节点，刘强：");
//        singleLinkedList.deleteNodeByIndex(3);//删除第四个节点（张三）
//        singleLinkedList.print("删除尾位的节点，张三：");
        System.out.println("----");
    }

    /**
     * 单向链表的实现,每个Node节点里的指针，都指向下个Node节点，这样就形成了一个链表。
     * 需创建个头部Node作为开始，头部Node不储存数据(或者也可以设置数据，可以用于查找是哪条链表)，只作为指向第一个真正储存数据的节点的开始。
     * 链表有头有尾，头节点有了，尾部节点就是最后一个真正储存数据的节点。
     * 尾部节点有数据，但是指针会指向null，因为没有下个节点了，链表结束。
     */
    public class SingleLinkedList{
        private Node node_head;//头节点Node
        public SingleLinkedList(){
            node_head = new Node();//链表中需有个头部节点Node作为开始
            node_head.setData("1年纪2班的链表");//头节点Node不存放任何数据，所以数据本应为null，但是为了直观的表现，头链表我们放个数据
            node_head.setNext_node(null);//初始化单向链表，里面只有头Node，没有其他节点Node，所以头的指针指向null
        }
        /**
         * 在链表后面添加一个新的node
         * @param data
         */
        public void addNewNode(String data){
            Node newNode = new Node();//创建新node节点对象
            newNode.setData(data);//新加入的Node节点储存数据
            newNode.setNext_node(null);//此刻没有可以指向的下一个节点，指向null node
            /**
             * 添加时判断一下当前链表中每个节点的状态，
             * 当节点中的指针指向null的时候，就代表着它是目前的尾节点，
             * 那么我们将尾节点指向本次新创建的Node节点，这样新创建的Node就成为了尾节点了
             */
            getTailNode().setNext_node(newNode);
            //假设第一次添加时的情况 头Node.指针 -> null;
            //那么头Node其实也充当了尾节点，那么将头Node指向本次新创建的Node
            //头Node.指针 -> 第一个newNode.指针 -> null;

            //假设第二次添加时的情况 第一个newNode.指针 -> null;
            //那么第一个newNode充当了尾节点，将第一个Node指向本次新创建的Node
            //头Node.指针 -> 第一个newNode.指针 -> 第二个newNode.指针 -> null;
        }

        /**
         * 根据下坐标，从链表的某个位置中删除对应节点
         * 例如我们要删除王二，index为1；
         * 那么我们就需要获取到小明节点index0，和刘强节点index2，
         * 将小明的指针指向刘强即可。
         */
        private void deleteNodeByIndex(int index){
            int maxSize = getSize();
            //先判断一下位置下坐标是否符合范围内
            if(index < 0 || index > maxSize-1){
                return;
            }
            //如果下坐标是0，则它是第一个node，直接将head node的指针指向第二个node即可，没有第二个就指向null
            if(index == 0){
                Node firstNode = node_head.getNext_node();
                Node secondNode = firstNode.getNext_node();
                node_head.setNext_node(secondNode);
                firstNode.setNext_node(null);//释放
                firstNode.setData(null);//释放
                return;
            }
            //如果下坐标处于链表中间的某一位置,获取其前一个node，将前一个node的指针，指向本次删除的node的指针
            if(maxSize-1>index && index>0){
                Node preNode = node_head.getNext_node();
                for(int i=0; i<index-1; i++){
                    preNode = preNode.getNext_node();
                }
                Node deleteNode = preNode.getNext_node();
                preNode.setNext_node(deleteNode.getNext_node());
            }
            //如果下坐标==链表总数量,则它是尾node，将其前一个node的指针设为null
            if(index == maxSize-1 ){
                Node preNode = node_head.getNext_node();
                for(int i=0; i<index-1; i++){
                    preNode = preNode.getNext_node();
                }
                preNode.setNext_node(null);
                return;
            }

            //从头node开始循环找对应下坐标的node
//            Node tempNode = node_head.getNext_node();
//            for(int i=0; i<index; i++){
//                tempNode = tempNode.getNext_node();
//            }
        }

        /**
         * 获取尾部节点
         * 从头部节点开始查找，直到找到节点的指针为null停止
         * @return 返回指针为null的节点（它就是链表中的尾节点）
         * 如果链表中只有头节点，那么它自己就是尾节点
         */
        private Node getTailNode(){
//            if(node_head == null){ //防止头node为空
//                node_head = new Node();//链表中需有个头部节点Node作为开始
//                node_head.setData("1年纪2班的链表");//头节点Node不存放任何数据，所以数据本应为null，但是为了直观的表现，头链表我们放个数据
//                node_head.setNext_node(null);//初始化单向链表，里面只有头Node，没有其他节点Node，所以头的指针指向null
//            }

            Node node = node_head; //从头节点Node开始找
            while (node.getNext_node() != null){
                node = node.getNext_node();
            }
            return node;
        }
        /**
         * 循环遍历获取总长度
         */
        private int getSize(){
            int size = 0;
            Node node = node_head; //从头节点Node开始找,指针域里存在的话，size++;
            while (node.getNext_node() != null){
                node = node.getNext_node();
                size++;
            }
            return size;
        }

        //将单向链表内的情况打印出来
        private void print(String str){
            String suffix = " -> ";
            String printLog = "";
            Node node = node_head.getNext_node();
            while (null != node ){
                if(null != node.getData()) {
                    printLog = printLog + node.getData() + suffix;
                    node = node.getNext_node();
                }
            }
            System.out.println(str+node_head.getData()+ suffix +printLog);
        }
    }
}
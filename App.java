
import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        int [] arr={3,4,5,1,2,-1,-1,-1,-1,0};
        tree n=new tree();
        n.builtree(arr);
        n.levelOrder(n.root);
    }
        
}
class node{
    int data;
    node left;
    node right;
    node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
class tree{
    static node root;
    static int idx=-1;


    private node buildtree(int data[]){
        idx+=1;
        if(data[idx]==-1){  
            return null;
        }
        node curr=new node(data[idx]);
        curr.left=buildtree(data);
        curr.right=buildtree(data);
        return curr;
    }  
    
    
    public void builtree(int arr[]){
        root=buildtree(arr);
    }
    public void print(node r){
        if(r==null){
            return;
        }
        print(r.left);
        System.out.println(r.data);
        print(r.right);
    }


    public int hight(node r){
        if(r==null){
            return 0;
        }
        int le=hight(r.left);
        int ri=hight(r.right);
        int x=Math.max(le,ri)+1;  
        return x;
    }



    public void levelOrder(node p){
        Queue<node> q=new LinkedList<>();
        q.add(p);
        Stack<Integer>st=new Stack<>();
        while(!q.isEmpty()){
            node top=q.poll();
            st.push(top.data);
            if(top.left!=null){
                q.add(top.left);
            }
            if(top.right!=null){
                q.add(top.right);
            }
        }
        while(!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
}
        
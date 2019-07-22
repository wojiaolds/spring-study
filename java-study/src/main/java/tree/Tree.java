package tree;

import stack.LinkStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>注释</p>
 *
 * @author lds
 * @version $Id: Tree.java , v 0.1 2018/12/21 13:33 By lds Edit  $$
 */
public class Tree<E extends Comparable> {

	class Node<E>{
		private E data;
		private Node<E> left;
		private Node<E> right;
		Node(E e){
			this(e,null,null);
		}
		Node(E e,Node<E> left,Node<E> right){
			this.data = e;
			this.left = left;
			this.right = right;
		}

	}

	private Node<E> root;
	

	public Tree(){
		root = null;
	}
	
	public  Node CreateInRecur(Scanner scanner){
		int data = scanner.nextInt();
		if(data==0)                     //输入data为0时，认为该节点为空节点
			return null;
		root =new Node(data,CreateInRecur(scanner),CreateInRecur(scanner));
		return root;
	}

	/**
	 * 递归创建二叉树
	 * @param node
	 * @param data
	 */
	public void buildTree(Node node,E data){
		if(root == null){
			root = new Node<>(data);
		}else{
			if(data.compareTo (node.data) == -1){
				if(node.left == null){
					node.left = new Node<>(data);
				}else{
					buildTree(node.left,data);
				}
			}else{
				if(node.right == null){
					node.right = new Node<>(data);
				}else{
					buildTree(node.right,data);
				}
			}
		}
	}
	
	/**
	 * 前序遍历
	 * @param node
	 */
	public void preOrder(Node<E> node,List<E> list){
		if(node != null){
			list.add (node.data);
			preOrder(node.left,list);
			preOrder(node.right,list);
		}
	}

	public void preOrder2(Node<E> root,List<E> list){
		
		LinkStack<Node<E>> linkStack = new LinkStack<> ();
		while(root != null || !linkStack.isEmpty ()){
			if(root != null){
				list.add (root.data);
				linkStack.push (root);
				root = root.left;
			}else if(!linkStack.isEmpty ()){
				Node<E> node = linkStack.pop ();
				root = node.right;
			}
		}
	}
	/**
	 * 中序遍历
	 * @param node
	 */
	public void inOrder(Node<E> node,List<E> list){
		if(node != null){
			inOrder(node.left,list);
			list.add (node.data);
			inOrder(node.right,list);
		}
	}
	

	public void inOrder2(Node<E> root,List<E> list){
		
		LinkStack<Node<E>> linkStack = new LinkStack<> ();
		while(root != null || !linkStack.isEmpty ()){
			if(root != null){
				linkStack.push (root);
				root = root.left;
				
			}else if(!linkStack.isEmpty ()){
				Node<E> node = linkStack.pop ();
				list.add (node.data);
				root = node.right;
			}
		}
	}
	/**
	 * 后序遍历
	 * @param node
	 */
	public void postOrder(Node<E> node,List<E> list){
		if(node != null){
			postOrder(node.left,list);
			postOrder(node.right,list);
			list.add (node.data);
		}
	}
	
	public void postOrder2(Node<E> root,List<E> list){
		LinkStack<Node<E>> linkStack = new LinkStack<> ();
		LinkStack<E> stack = new LinkStack<> ();
		while(root != null || !linkStack.isEmpty ()){
			if(root != null){
				stack.push(root.data);
				linkStack.push (root);
				root = root.right;
			}else if(!linkStack.isEmpty ()){
				Node<E> node = linkStack.pop ();
				root = node.left;
			}
		}
		while (!stack.isEmpty()){
			list.add(stack.pop());
		}

	}
	
	
	public static void main(String[] args) {
		int[] a = {2,4,12,45,21,6,111};
		Tree<Integer> bTree = new Tree<>();
		for ( int i:a ) {
			bTree.buildTree(bTree.root, i);
		}
		
//		bTree.CreateInRecur(new Scanner (System.in));
		System.out.println ("递归前序遍历");
		List<Integer> list = new ArrayList <> ();
		bTree.preOrder(bTree.root,list);
		System.out.println (list);
		System.out.println ("非递归前序遍历");
		list.clear ();
		bTree.preOrder2(bTree.root,list);
		System.out.println (list);
		System.out.println ("递归中序遍历");
		list.clear ();
		bTree.inOrder(bTree.root,list);
		System.out.println (list);
		System.out.println ("非递归中序遍历");
		list.clear ();
		bTree.inOrder2(bTree.root,list);
		System.out.println (list);
		System.out.println ("递归后序遍历");
		list.clear ();
		bTree.postOrder(bTree.root,list);
		System.out.println (list);
		System.out.println ("非递归后序遍历");
		list.clear ();
		bTree.postOrder2(bTree.root,list);
		System.out.println (list);
		
//		System.out.println(Integer.valueOf (1).compareTo (Integer.valueOf (2)));
		
	}



}

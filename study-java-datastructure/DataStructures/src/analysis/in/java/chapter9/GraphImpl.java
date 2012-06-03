package analysis.in.java.chapter9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import analysis.in.java.chapter3.MyLinkedQueue;
import analysis.in.java.chapter3.MyQueue;
import analysis.in.java.util.CycleFoundException;

public class GraphImpl implements Graph{

	private Vertex[] vertexs;
	private int n;
	public GraphImpl(int n){
		this.n=n;
		vertexs=new Vertex[n];
	}
	public void  topsort() throws CycleFoundException{
		MyQueue<Vertex> q = new MyLinkedQueue<Vertex>();
		int counter=0;
		for(int i=0;i<n;i++){
			if(inDegree(i)==0){
				q.enqueue(vertexs[i]);
			}
		}
		while(!q.isEmpty()){
			Vertex ver=q.dequeue();
		}
	}
	
	public static class Vertex<DistType>{
		public List adj;
		public boolean know;
		public DistType dist;
		public Vertex path;
	}

	@Override
	public void addEdge(int i, int j) {
		vertexs[i].adj.add(j);
	}
	@Override
	public boolean hasEdge(int i, int j) {
		return vertexs[i].adj.contains(j);
	}
	@Override
	public int inDegree(int i) {
		int degree=0;
		for(int k=0;k<n;k++){
			if(vertexs[k].adj.contains(i)){
				++degree;
			}
		}
		return degree;
	}
	@Override
	public List<Integer> inEdges(int i) {
		List<Integer> edges=new LinkedList();
		for(int k=0;k<n;k++){
			if(vertexs[k].adj.contains(i)){
				edges.add(k);
			}
		}
		return edges;
	}
	@Override
	public int nVertices() {
		return n;
	}
	@Override
	public int outDegree(int i) {
		int degree=0;
		for(int k=0;k<n;k++){
			if(vertexs[i].adj.contains(k)){
				++degree;
			}
		}
		return degree;
	}
	@Override
	public List<Integer> outEdges(int i) {
		List<Integer> edges=new LinkedList();
		for(int k=0;k<n;k++){
			if(vertexs[i].adj.contains(k)){
				edges.add(k);
			}
		}
		return edges;
	}
	@Override
	public void removeEdge(int i, int j) {
		Iterator<Integer> it = vertexs[i].adj.iterator();
		while (it.hasNext()) {
			if (it.next() == j) {
				it.remove();
				return;
			}
		}
	}
}
